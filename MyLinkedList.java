
public class MyLinkedList<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty LinkedList.
     */
    public MyLinkedList( )
    {
        clear( );
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        beginMarker = new Node<AnyType>( null, null, null );
        endMarker = new Node<AnyType>( null, beginMarker, null );
        beginMarker.next = endMarker;
        
        theSize = 0;
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }
    
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add( AnyType x )
    {
        add( size( ), x );   
        return true;         
    }
    
    /**
     * Adds an item to this collection, at specified position.
     * Items at or after that position are slid one position higher.
     * @param x any object.
     * @param idx position to add at.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */
    public void add( int idx, AnyType x )
    {
        addBefore( getNode( idx, 0, size( ) ), x );
    }
    
    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     * @param p Node to add before.
     * @param x any object.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */    
    private void addBefore( Node<AnyType> p, AnyType x )
    {
        Node<AnyType> newNode = new Node<AnyType>( x, p.prev, p );
        newNode.prev.next = newNode;
        p.prev = newNode;         
        theSize++;
    }   
    
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx )
    {
        return getNode( idx ).data;
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
        Node<AnyType> p = getNode( idx );
        AnyType oldVal = p.data;
        
        p.data = newVal;   
        return oldVal;
    }
    
    /**
     * Gets the Node at position idx, which must range from 0 to size( ) - 1.
     * @param idx index to search at.
     * @return internal node corrsponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size( ) - 1, inclusive.
     */
    private Node<AnyType> getNode( int idx )
    {
        return getNode( idx, 0, size( ) - 1 );
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper.
     * @param idx index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corrsponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between lower and upper, inclusive.
     */    
    private Node<AnyType> getNode( int idx, int lower, int upper )
    {
        Node<AnyType> p;
        
        if( idx < lower || idx > upper )
            throw new IndexOutOfBoundsException( "getNode index: " + idx + "; size: " + size( ) );
            
        if( idx < size( ) / 2 )
        {
            p = beginMarker.next;
            for( int i = 0; i < idx; i++ )
                p = p.next;            
        }
        else
        {
            p = endMarker;
            for( int i = size( ); i > idx; i-- )
                p = p.prev;
        } 
        
        return p;
    }
    
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove( int idx )
    {
        return remove( getNode( idx ) );
    }
    
    /**
     * Removes the object contained in Node p.
     * @param p the Node containing the object.
     * @return the item was removed from the collection.
     */
    private AnyType remove( Node<AnyType> p )
    {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        
        return p.data;
    }
        
    /** IS O(n), due to getNode method
     * Receives two index positions as parameters, then swap
     * @param idx the index of the object.
     * @param idx2 the index of the object.
     */
    public void swap(int idx , int idx2){
        swap(getNode(idx), getNode(idx2));
    }

    private void swap (Node<AnyType> p, Node<AnyType> q){
        Node<AnyType> temp2;
        Node<AnyType> temp3;

        q.next.prev = p;
        p.next.prev = q;

        temp2 = p.next;
        p.next = q.next;
        q.next = temp2;

        temp3 = p.prev;
        p.prev = q.prev;
        q.prev = temp3;

        q.prev.next = q;
        p.prev.next = p;

    }
    // Both condiditions are O(n) 
    public void shift(int n){
        if(n < 0){
            for (int i = 0; i < -n; i++){
                Node<AnyType> temp = endMarker.prev;
                Node<AnyType> temp2 = endMarker.prev.prev;

                endMarker.prev.next = beginMarker.next;
                beginMarker.next = temp;

                beginMarker.next.prev = beginMarker;
                beginMarker.next.next.prev = beginMarker.next;

                temp2.next = endMarker;
                endMarker.prev = temp2;


            }
        }else if(n > 0){
            for (int i = 0; i < n; i++){
                Node<AnyType> temp = beginMarker.next;
                Node<AnyType> temp2 = endMarker.prev;

                beginMarker.next = beginMarker.next.next;
                beginMarker.next.prev = beginMarker;

                temp.next = endMarker;
                temp2.next = temp;
                endMarker.prev = temp;
                temp.prev = temp2;


            }
        }
    }
    // Is O(n). 
    public void erase(int idx , int idx2)
    {
        erase(getNode(idx), idx2);
    }

    private void erase(Node<AnyType> p, int n)
    { 
        for(int i = 0; i < n; i++){
            p.next.prev = p.prev;
            p.prev.next = p.next;
            theSize--;
            p = p.next;
        }
    }

    // Is O(n) due to getNode method, if you call this function twice however we would not result in our required array
    // since we are modifying lst2, so we can either create a copy of the ls2 inside the insertList method or before calling the method
    // but i beleive it is more efficient to just create a new copy of lst2 right before calling the insertList method
    public void insertList(int idx, MyLinkedList<AnyType> insert)
    {
        insertList(getNode(idx), insert);
    }
    private void insertList(Node<AnyType> p, MyLinkedList<AnyType> insert){
        MyLinkedList<AnyType> ins = insert;
        p.prev.next = ins.beginMarker.next;
        ins.beginMarker.next.prev = p.prev;

        ins.endMarker.prev.next = p;
        p.prev = ins.endMarker.prev;
        theSize += ins.theSize;
    }


    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( "[ " );
        for( AnyType x : this ){
            sb.append( x + " " );
        }
        sb.append( "]" );
        return new String( sb );
    }
    
    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )
    {
        return new LinkedListIterator( );
    }

    /**
     * This is the implementation of the LinkedListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyLinkedList.
     */
    private class LinkedListIterator implements java.util.Iterator<AnyType>
    {
        private Node<AnyType> current = beginMarker.next;
        private boolean okToRemove = false;
        
        public boolean hasNext( )
        {
            return current != endMarker;
        }
        
        public AnyType next( )
        {
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException( ); 
                   
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }
        
        public void remove( )
        {
            if( !okToRemove )
                throw new IllegalStateException( );
                
            MyLinkedList.this.remove( current.prev );
            okToRemove = false;       
        }
    }
    
    /**
     * This is the doubly-linked list node.
     */
    private static class Node<AnyType>
    {
        public Node( AnyType d, Node<AnyType> p, Node<AnyType> n )
        {
            data = d; prev = p; next = n;
        }
        
        public AnyType data;
        public Node<AnyType>   prev;
        public Node<AnyType>   next;
    }
    
    private int theSize; 
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;
}

class TestLinkedList
{
    public static void main( String [ ] args )
    {
        MyLinkedList<Integer> lst = new MyLinkedList<Integer>( );
        MyLinkedList<Integer> lstCopy = new MyLinkedList<Integer>( );
        MyLinkedList<Integer> lst2 = new MyLinkedList<Integer>( );

        for(int i = 1; i < 5; i++){
            lst.add(i);
            lstCopy.add(i);
        }
        for( int i = 3; i < 8; i+=2 )
            lst2.add( i );

        System.out.println("a. swap");
        System.out.print(lst + "  swap(0, 2)  ");
        lst.swap(0, 2);
        System.out.println(lst); 
        lst.swap(0, 2); // I now return to the original list by swapping the two nodes back
        System.out.println(" "); 


        System.out.println("b. shift"); 
        System.out.print(lst + "  shifted + 1  ");  
        lst.shift(1);
        System.out.println(lst);
        lst.shift(-1); // to return to the original list
        System.out.print(lst + "  shifted - 1  ");
        lst.shift(-1);
        System.out.println(lst);
        lst.shift(1); // to return to the original list 
        System.out.println(""); 


        System.out.println("c. erase"); 
        System.out.print(lst + "  erase(1, 2)  ");  
        lst.erase(1, 2);
        System.out.println(lst);
        System.out.println(""); 


        // using lstCopy because lst was modified
        System.out.println("d. insertList"); 
        System.out.println("With lst2 = [3 5 7]");
        System.out.print(lstCopy + "  insert(1, lst2)  ");  
        lstCopy.insertList(1, lst2);
        System.out.println(lstCopy);
        System.out.println(""); 
    }
}
