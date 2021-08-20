package DataStructure.D_Recursion;

import java.util.Scanner;

public class PrintNumber {

    public static void printInc(int number){

        if(number==1){
            System.out.print(1+" ");
            return;
        }

        printInc(number-1);
        System.out.print(number+" ");
    }

    public static void printDec(int number){
        if(number==1){
            System.out.print(1+" ");
            return;
        }

        System.out.print(number+" ");
        printInc(number-1);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        printInc(number);
        System.out.println();
        printDec(number);
    }
}
