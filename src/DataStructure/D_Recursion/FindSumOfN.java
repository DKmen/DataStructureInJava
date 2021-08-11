package DataStructure.D_Recursion;

//find sum of n number like 1+2+3+...+n

import java.util.Scanner;

public class FindSumOfN {

    public static int findSum(int number){
        if(number==0) return 0;
        int previousSum=findSum(number-1);
        return previousSum+number;
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int sum=findSum(number);
        System.out.println(sum);
    }
}
