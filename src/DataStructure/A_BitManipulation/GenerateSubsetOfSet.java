package DataStructure.A_BitManipulation;

//Find all possible sub array of given array

import java.util.Scanner;

public class GenerateSubsetOfSet {
    public static void main(String[] arr){
        Scanner sc= new Scanner(System.in);
        int arraySize=sc.nextInt();
        int[] elementArray=new int[arraySize];
        for(int i=0;i<arraySize;i++){
            elementArray[i]=sc.nextInt();
        }
        for(int i=0;i<(1<<elementArray.length);i++){
            for(int j=0;j<elementArray.length;j++){
                if((i&(1<<j))!=0){
                    System.out.print(elementArray[j]+" ");
                }
            }
            System.out.println();
        }
    }
}
