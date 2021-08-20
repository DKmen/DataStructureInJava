package DataStructure.D_Recursion;

import java.util.Scanner;

//print all possible permutation of given string

public class PermutationString {

    public static void printAllPossibleString(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            StringBuilder tempStr=new StringBuilder(str);
            tempStr.deleteCharAt(i);
            printAllPossibleString(tempStr.toString(),ans+str.charAt(i));
        }
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        String inputString=sc.nextLine();

        printAllPossibleString(inputString,"");
    }
}
