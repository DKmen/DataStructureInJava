package DataStructure.F_SortingAlgorithm;

public class WaveSort {

    public static void swap(int[] elementArray,int firstIndex,int secondIndex){
        int temp=elementArray[firstIndex];
        elementArray[firstIndex]=elementArray[secondIndex];
        elementArray[secondIndex]=temp;
    }

    public static void waveSort(int[] elementArray){
        for (int i=1;i<elementArray.length;i+=2){
            if(elementArray[i]>elementArray[i-1]) swap(elementArray,i,i-1);
            else if ((i+1)<elementArray.length && elementArray[i]>elementArray[i+1]) swap(elementArray,i,i+1);
        }
    }

    public static void main(String[] arr){
        int[] elementArray={50,23,9,18,61,32};
        waveSort(elementArray);
        for(int element : elementArray) System.out.print(element+" ");
        System.out.println();
    }
}
