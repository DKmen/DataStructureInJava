package DataStructure.J_DynamicPrograming;

import java.util.Scanner;

public class AssemblyLineScheduling {

    public static int calculateMinimumCost(int[][] a,int[][] t,int[] e,int[] x){
        int[] T1=new int[a[0].length];
        int[] T2=new int[a[0].length];

        T1[0]=e[0]+a[0][0];
        T2[0]=e[1]+a[1][0];

        for(int i=1;i<T1.length;++i){
            T1[i]=Math.min(T1[i-1]+a[0][i],T2[i-1]+t[1][i]+a[0][i] );
            T2[i]=Math.min(T2[i-1]+a[1][i],T1[i-1]+t[0][i]+a[1][i] );
        }
        return Math.min(T1[T1.length-1]+x[0],T2[T2.length-1]+x[1]);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total number of station");
        int numberOfStation=sc.nextInt();
        int[][] a=new int[2][numberOfStation];
        int[][] t=new int[2][numberOfStation];
        int[] e=new int[2];
        int[] x=new int[2];
        System.out.println("Enter first line time");
        for(int i=0;i<numberOfStation;i++) a[0][i]=sc.nextInt();
        System.out.println("Enter second line time");
        for(int i=0;i<numberOfStation;i++) a[1][i]=sc.nextInt();
        System.out.println("switch time for first line");
        for(int i=1;i<numberOfStation;i++) t[0][i]=sc.nextInt();
        System.out.println("switch time second first line");
        for(int i=1;i<numberOfStation;i++) t[1][i]=sc.nextInt();
        System.out.println("entry and exict time for first line");
        e[0]=sc.nextInt();
        x[0]=sc.nextInt();
        System.out.println("entry and exict time for second line");
        e[1]=sc.nextInt();
        x[1]=sc.nextInt();
        System.out.println(calculateMinimumCost(a,t,e,x));
    }
}
