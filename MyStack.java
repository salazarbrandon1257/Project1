import java.util.ArrayList;
import java.util.HashSet;

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
    public static boolean balancingSymbols(String S){
        char[] ch = S.toCharArray();
        MyStack<Character> stack = new MyStack<Character>( );
        HashSet<Character> open = new HashSet<Character>();
        open.add('[');
        open.add('(');
        open.add('{');
        for(int i = 0; i < S.length(); i++){
            if(open.contains(ch[i])){
                stack.push(ch[i]);
            }else{
                if(stack.peek() == '[' && ch[i] == ']'){
                    stack.pop();
                }else if (stack.peek() == '(' && ch[i] == ')'){
                    stack.pop();
                }else if(stack.peek() == '{' && ch[i] == '}'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main( String [ ] args )
    {
        System.out.println(balancingSymbols("[({}{})]"));
    }
}

