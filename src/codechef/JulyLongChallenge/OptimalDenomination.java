package codechef.JulyLongChallenge;

import java.util.Scanner;

public class OptimalDenomination {
    public static int findDivedent(int array[],int ignoreElementIndex){
        if(ignoreElementIndex==array.length){

        }
        return 1;
    }
    public static void main(String arr[]){
        Scanner sc=new Scanner(System.in);
        int tastCase=sc.nextInt();
        while (tastCase-->0){
            int N=sc.nextInt();
            int[] array =new int[N];
            int Sum=0;
            for(int i=0;i<N;i++){
                int input=sc.nextInt();
                Sum+=input;
                array[i]=input;
            }
            int answer=Integer.MIN_VALUE;
            for(int i=0;i<=array.length;i++){
                int divident=findDivedent(array,i);
            }
        }
    }
}
