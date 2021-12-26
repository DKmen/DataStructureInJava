package DataStructure.Problems;

import java.util.Stack;

public class RedundantParenthesis {

    public static int countTotalNumberOfRegency(String exp){
        Stack<Character> st=new Stack<Character>();
        int count=0;

        for (int i=0;i<exp.length();i++){
            if(exp.charAt(i)=='(' || exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*' || exp.charAt(i)=='/'){
                st.push(exp.charAt(i));
                continue;
            }

            if(exp.charAt(i)==')'){
                if(st.peek()!='('){
                    st.pop();
                    st.pop();
                    continue;
                }
                count++;
            }

        }
        return count;
    }

    public static void main(String[] arr){
        String exp="(b+(a+b))";
        int regency= countTotalNumberOfRegency(exp);
        System.out.println(regency);
    }
}
