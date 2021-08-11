package codechef.JuluCockoff;

import java.util.Arrays;
import java.util.Scanner;

public class ChefInInfinitePlane {
    public static void main(String arr[]){
        Scanner sc=new Scanner(System.in);
        int testCase=sc.nextInt();
        while(testCase-->0){
            int NumberOfElement=sc.nextInt();
            int[] Elements_Array= new int[NumberOfElement];

            for(int i=0;i<NumberOfElement;i++){
                int inputElement=sc.nextInt();
                Elements_Array[i]=inputElement;
            }

            Arrays.sort(Elements_Array);

            int answer=0;
            int index=-1;
            while (index<Elements_Array.length-1){
                index++;
                long Element=Elements_Array[index];
                int ElementCount=1;
                while ((index+1)<Elements_Array.length && Elements_Array[index]==Elements_Array[index+1]){
                    ElementCount++;
                    index++;
                }
                answer+=Math.min(Element-1,ElementCount);
            }
            System.out.println(answer);
        }
    }
}
