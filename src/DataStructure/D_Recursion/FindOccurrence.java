package DataStructure.D_Recursion;

// find last and first occurrence of given element

import java.util.Scanner;

public class FindOccurrence {

    public static int findFirstOccurrence(int[] arr, int index,int key){

        if(index==arr.length) return -1;
        if(arr[index]==key) return index;
        return findFirstOccurrence(arr,index+1,key);

    }

    public static int findSecondOccurrence(int[] arr, int index,int key){
        if(index<0) return -1;
        if(arr[index]==key) return index;
        return findSecondOccurrence(arr,index-1,key);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int[] array={2,4,7,8,2,3,4,2,8};
        int firstOccurrenceIndex= findFirstOccurrence(array,0,2);
        int secondOccurrenceIndex= findSecondOccurrence(array,array.length-1,2);
        System.out.println(firstOccurrenceIndex+" "+secondOccurrenceIndex);
    }
}
