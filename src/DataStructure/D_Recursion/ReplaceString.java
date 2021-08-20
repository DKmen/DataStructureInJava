package DataStructure.D_Recursion;

// replace pi with 3.14 in given string

import java.util.Scanner;

public class ReplaceString {

    private static String replacePWith(String str){
        if(str.length()==0) return str;

        if(str.charAt(0)=='p' && str.charAt(1)=='i'){
            str="3.14".concat(replacePWith(str.substring(2)));
        }else {
            str=String.valueOf(str.charAt(0)).concat(replacePWith(str.substring(1)));
        }
        return str;
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        String givenString="pisncjdjjpisdjcnspidpi";
        givenString= replacePWith(givenString);
        System.out.println(givenString);
    }
}
