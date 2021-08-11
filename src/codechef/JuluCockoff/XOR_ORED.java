package codechef.JuluCockoff;

import java.util.Scanner;

public class XOR_ORED {
    public static void main(String arr[]){
        Scanner sc=new Scanner(System.in);
        int testCase=sc.nextInt();
        while(testCase-->0){
            int NumberOfElement=sc.nextInt();
            long X=0;
            long ans=0;
            long[] inputArray=new long[NumberOfElement];
            for(int i=0;i<NumberOfElement;i++){
                long input=sc.nextInt();
                inputArray[i]=input;
                X=X|input;
            }
            for(int i=0;i<NumberOfElement;i++){
                inputArray[i]=inputArray[i]^X;
                ans=ans|inputArray[i];
            }
            System.out.println(ans);
        }
    }
}
