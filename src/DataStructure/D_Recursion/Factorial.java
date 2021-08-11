package DataStructure.D_Recursion;

import java.util.Scanner;

// find N! of given N

public class Factorial {

    public static int findFactorial(int number){
        if(number==1) return 1;
        int previousAns=findFactorial(number-1);
        return previousAns*number;
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int answer=findFactorial(number);
        System.out.println(answer);
    }
}
