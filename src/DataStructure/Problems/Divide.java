package DataStructure.Problems;

import java.util.Scanner;

public class Divide {

    private static int count=0;

    public static int power(int a,int b){
        if(b==0) return 1;
        else if(b%2==0){
            int temp=power(a,b/2);
            count++;
            return temp*temp;
        }else {
            count++;
            return power(a, b - 1) * a;
        }
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int ans=power(a,b);
        System.out.println(ans);
        System.out.println("Total number of iteration "+count);
    }
}
