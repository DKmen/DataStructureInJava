package DataStructure.H_Stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] arr){

        String str="Hi how are you? what is you doing";
        String[] strArray=str.split(" ");
        str="";

        Stack<String> stack=new Stack<String>();
        for (String s : strArray) stack.push(s);
        for(int i=0;i<strArray.length;i++) str+=stack.pop()+" ";

        System.out.println(str);

    }
}
