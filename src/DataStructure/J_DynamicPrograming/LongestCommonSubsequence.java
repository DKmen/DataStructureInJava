package DataStructure.J_DynamicPrograming;

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static int lcmOfString(String str1,String str2,int firstIndex,int secondIndex,int[][] memorizeAnswerArray){
        if(firstIndex==str1.length() || secondIndex==str2.length()) return 0;
        else if(memorizeAnswerArray[firstIndex][secondIndex]!=0) return memorizeAnswerArray[firstIndex][secondIndex];
        else if(str1.charAt(firstIndex)==str2.charAt(secondIndex)){
            return memorizeAnswerArray[firstIndex][secondIndex]=1+lcmOfString(str1,str2,firstIndex+1,secondIndex+1,memorizeAnswerArray);
        }else {
            return memorizeAnswerArray[firstIndex][secondIndex]=Math.max(lcmOfString(str1,str2,firstIndex,secondIndex+1,memorizeAnswerArray),lcmOfString(str1,str2,firstIndex+1,secondIndex,memorizeAnswerArray));
        }
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        int[][] memorizeAnswerArray=new int[str1.length()+1][str2.length()+1];
        System.out.println(lcmOfString(str1,str2,0,0,memorizeAnswerArray));
    }
}
