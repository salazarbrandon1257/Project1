import java.util.ArrayList;

public class MyStack<AnyType>{
    ArrayList<AnyType> arr;
    MyStack(){
        arr = new ArrayList<>();
    }
    public void push(AnyType x){
        arr.add(x);
    }
    public AnyType peek(){
        return arr.get(arr.size() - 1);
    }
    public AnyType pop(){
        return arr.remove(arr.size() - 1);
    }
    public boolean isEmpty(){
        return arr.isEmpty();
    }


}
class TestMystack
{
    public static void main( String [ ] args )
    {
        MyStack<Integer> stack = new MyStack<Integer>( );
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.isEmpty();

        System.out.println("After here we have the original ");
    }
}

