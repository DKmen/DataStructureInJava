package DataStructure.B_Sieve_Problem;

//print all prime number factor of given number

import java.util.Scanner;

public class primeFactorisation {

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        int[] smallestPrimeFactor=new int[number+1];

        for(int i=2;i<=number;i++){
            smallestPrimeFactor[i]=i;
        }

        for (int i=2;i<=(int) Math.ceil(Math.sqrt((double)number));i++){
            if(smallestPrimeFactor[i]!=i) continue;
            for(int j=i*i;j<=number;j+=i){
                if(smallestPrimeFactor[j]==j){
                    smallestPrimeFactor[j]=i;
                }
            }
        }

        while (number!=1){
            int smallestPrimeFactorNumber=smallestPrimeFactor[number];
            number/=smallestPrimeFactorNumber;
            System.out.println(smallestPrimeFactorNumber);
        }
    }
}
