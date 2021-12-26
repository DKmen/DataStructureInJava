package DataStructure.J_DynamicPrograming;

import java.util.Scanner;

public class BinomialCoefficient {

    public static int binomialCoefficientNumber(int n, int k){
        if(k==n || k==0) return 1;
        return binomialCoefficientNumber(n-1,k-1)+ binomialCoefficientNumber(n-1,k);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(binomialCoefficientNumber(n,k));
    }
}
