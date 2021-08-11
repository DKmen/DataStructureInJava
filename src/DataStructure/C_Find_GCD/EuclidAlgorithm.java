package DataStructure.C_Find_GCD;

import java.util.Scanner;

public class EuclidAlgorithm {

    public static int findGreatestCommonDividend(int firstNumber, int secondNumber){
        int minNumber=Math.min(firstNumber,secondNumber);
        int maxNumber=Math.max(firstNumber,secondNumber);

        while (true){
            firstNumber=maxNumber%minNumber;
            if(firstNumber==0) return minNumber;
            secondNumber=minNumber;
            minNumber=Math.min(firstNumber,secondNumber);
            maxNumber=Math.max(firstNumber,secondNumber);
        }
    }

    public static void main(String[] arr){
        Scanner sc = new Scanner(System.in);
        int firstNumber= sc.nextInt();
        int secondNumber= sc.nextInt();
        int gcd= findGreatestCommonDividend(firstNumber,secondNumber);
        System.out.println(gcd);
    }
}
