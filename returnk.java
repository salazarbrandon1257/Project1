import java.util.ArrayList;

public class returnk {
    static class node  
    { 
        int val; 
        node next; 
  
        public node(int val)  
        { 
            this.val = val; 
        } 
    } 
    public static Integer findK(node head, int k){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        node current = head;
        while (current != null){
            arr.add(current.val); 
            current = current.next;  
        }
        return arr.get(arr.size() - k -1);
    }
    public static void main(String[] args) {
           /* The constructed linked list is: 
             10->12->11->11->12->11->10*/
             int k = 2;
             node start = new node(10); 
             start.next = new node(12); 
             start.next.next = new node(11); 
             start.next.next.next = new node(11); 
             start.next.next.next.next = new node(12); 
             start.next.next.next.next.next = new node(11); 
             start.next.next.next.next.next.next = new node(10); 
             System.out.println(findK(start, k));
    }
}
