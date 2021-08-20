package DataStructure.D_Recursion;

// find Nth fibonacci number using recursion

import java.util.Scanner;

public class Fibonacci {

    public static int findNthFibonacciNumber(int number){
        if(number==0) return 0;
        if(number==1) return 1;
        int firstNumber=findNthFibonacciNumber(number-1);
        int secondNumber=findNthFibonacciNumber(number-2);
        return firstNumber+secondNumber;
    }

    public static void main(String[] arr){
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        int answer=findNthFibonacciNumber(number);
        System.out.println(answer);
    }
}
