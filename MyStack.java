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
        System.out.println(arr.get(arr.size() - 1));
        return arr.get(arr.size() - 1);
    }
    public AnyType pop(){
        return  arr.remove(arr.size() - 1);
    }


}
class TestMystack
{
    public static void main( String [ ] args )
    {
        MyStack<Integer> stack = new MyStack<Integer>( );
        stack.push(1);
        stack.push(2);
        stack.peek();
    }
}

