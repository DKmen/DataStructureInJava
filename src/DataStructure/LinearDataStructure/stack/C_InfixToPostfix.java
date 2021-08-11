package DataStructure.LinearDataStructure.stack;

import java.util.Stack;

public class C_InfixToPostfix {
    //getPriority number
    private int getPrecident(char sine){
        switch (sine){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixToPostfix(String expericion){
        String result="";
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<expericion.length();i++){
            char pointer=expericion.charAt(i);

            if(Character.isLetterOrDigit(pointer)){
                result+=pointer;
            }else if(pointer=='('){
                stack.push(pointer);
            }else if(pointer==')'){
                while (!stack.isEmpty() && stack.peek()!='('){
                    result+=stack.pop();
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && getPrecident(pointer)<=getPrecident(stack.peek())){
                    result+=stack.pop();
                }
                stack.push(pointer);
            }
        }

        while (!stack.isEmpty()){
            if(stack.peek()=='(') return "Inviled expericion";
            result+=stack.pop();
        }
        return result;
    }

    //evolutation postfix expericion
    public int evolutationPostfix(String experision){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<experision.length();i++){
            if(Character.isLetterOrDigit(experision.charAt(i))){
                stack.push(experision.charAt(i)-'0');
            }else {
                int value1=stack.pop();
                int value2=stack.pop();
                if(experision.charAt(i)=='+'){
                    stack.push(value1+value2);
                }else if(experision.charAt(i)=='-'){
                    stack.push(value2-value1);
                }else if(experision.charAt(i)=='/'){
                    stack.push(value2/value1);
                }else{
                    stack.push(value1*value2);
                }
            }
        }
        return stack.pop();
    }
}
