package DataStructure.D_Recursion;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void printSteps(int number,char source,char destination,char helper){
        if(number==0) return;
        printSteps(number-1,source,helper,destination);
        System.out.println("block move from "+source+" to "+destination);
        printSteps(number-1,helper,destination,source);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        printSteps(3,'a','c','b');
    }
}
