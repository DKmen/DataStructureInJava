package DataStructure.D_Recursion;

import java.util.Scanner;

// reverse string using recursion

public class ReverseString {

    public static String reverseString(String str){
        if(str.length()==1) return str;
        String restReverseString=reverseString(str.substring(1));
        return restReverseString+String.valueOf(str.charAt(0));
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        name=reverseString(name);
        System.out.println(name);
    }
}
