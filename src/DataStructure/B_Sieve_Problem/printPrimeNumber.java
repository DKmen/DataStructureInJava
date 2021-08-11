package DataStructure.B_Sieve_Problem;

import java.util.Arrays;
import java.util.Scanner;

public class printPrimeNumber {
    public static void printPrimeNumberGivenRange(int range){

        int[] numberArray=new int[range+1];
        Arrays.fill(numberArray,0);

        for(int i=2;i<=(int) Math.ceil(Math.sqrt((double) range));i++){
            if(numberArray[i]==1) continue;
            for (int j=i*i;j<=range;j+=i){
                numberArray[j]=1;
            }
        }

        for(int i=2;i<=range;i++){
            if(numberArray[i]==0) System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int numberRange=sc.nextInt();
        printPrimeNumberGivenRange(numberRange);
    }
}
