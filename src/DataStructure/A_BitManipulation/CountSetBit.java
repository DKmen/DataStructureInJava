package DataStructure.A_BitManipulation;

import java.util.Scanner;

public class CountSetBit {
    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int number= sc.nextInt();
        int count=0;
        while (number>0){
            number=number&(number-1);
            count++;
        }
        System.out.println(count);
    }
}
