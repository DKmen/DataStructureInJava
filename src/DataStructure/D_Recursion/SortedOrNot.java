package DataStructure.D_Recursion;

import java.util.Scanner;

public class SortedOrNot {

    public static boolean arrayIsSorted(int[] array,int startIndex){

        if(startIndex==(array.length-1)) return true;

        boolean restArray=arrayIsSorted(array,startIndex+1);
        return (restArray && array[startIndex]<=array[startIndex+1]);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int[] array={1,2,4,5,6,7};
        boolean sorted=arrayIsSorted(array,0);
        System.out.println(sorted);
    }
}
