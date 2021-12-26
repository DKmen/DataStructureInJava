package DataStructure.H_Stack;

import java.util.Stack;

public class ReverseStack {

    public static void pushBottom(Stack<Integer> stack, int element){

        if(stack.isEmpty()){
            stack.push(element);
            return;
        }

        int topElement=stack.pop();
        pushBottom(stack,element);
        stack.push(topElement);
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int topElement=stack.pop();
        reverseStack(stack);

        pushBottom(stack,topElement);
    }

    public static void main(String[] arr){
        Stack<Integer> st = new Stack<Integer>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        reverseStack(st);
        while (!st.isEmpty()) System.out.println(st.pop());
    }
}
