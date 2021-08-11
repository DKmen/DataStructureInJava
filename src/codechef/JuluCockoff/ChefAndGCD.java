package codechef.JuluCockoff;

import java.util.Scanner;

public class ChefAndGCD {
    public static void main(String arr[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(gcd(a,b)!=1){
                System.out.println("0");
            }else if(gcd(a+1,b)!=1){
                System.out.println("1");
            }else if(gcd(a,b+1)!=1){
                System.out.println("1");
            }else{
                System.out.println("2");
            }
        }
    }

    public static int gcd (int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
