package DataStructure.F_SortingAlgorithm;

import java.util.Arrays;

public class CountSort {

    public static int maxElement(int[] elementArray){
        int max=elementArray[0];
        for (int j : elementArray) {
            if (max < j) max = j;
        }
        return max;
    }

    public static void countSort(int[] elementArray){
        int maxElement= maxElement(elementArray);
        int[] elementCountArray=new int[maxElement+1];
        int[] copyArray=elementArray.clone();

        Arrays.fill(elementCountArray,0);
        for (int element : elementArray) elementCountArray[element]++;

        for(int i=1;i<elementCountArray.length;i++) elementCountArray[i]+=elementCountArray[i-1];

        for (int j : copyArray) {
            elementCountArray[j]--;
            int index = elementCountArray[j];
            elementArray[index] = j;
        }

    }

    public static void main(String[] arr){
        int[] elementArray={6,2,5,3,8,10,4,7,9,1};
        countSort(elementArray);
        for(int element : elementArray) System.out.print(element+" ");
        System.out.println();
    }
}
