package DataStructure.D_Recursion;

//find n to power m

import java.util.Scanner;

public class FindPower {

    public static int power(int n,int m){
        if(m==0) return 1;
        int previousAns=power(n,m-1);
        return previousAns*n;
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int ans=power(n,m);
        System.out.println(ans);
    }
}
