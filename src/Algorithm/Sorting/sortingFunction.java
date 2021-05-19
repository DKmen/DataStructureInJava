package Algorithm.Sorting;

public class sortingFunction {

    //Selection Sort
    /*
    The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.
     */

    public void selectionSort(int[] array){
        for (int i=0;i<array.length;i++){
            int minElementIndex=i;
            int minElement=array[i];
            for (int j=i;j<array.length;j++){
                if(minElement>array[j]){
                    minElement=array[j];
                    minElementIndex=j;
                }
            }
            array[minElementIndex]=array[i];
            array[i]=minElement;
        }
    }

    //Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
    public void swap(int[] array,int indexA,int indexB){
        int temp=array[indexA];
        array[indexA]=array[indexB];
        array[indexB]=temp;
    }
    public void bubbleSort(int[] array){
        boolean swap=false;
        for(int i=0;i<array.length;i++){
            swap=false;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]) {
                    swap=true;
                    swap(array,j,j+1);
                }
            }
            if(!swap) break;
        }
    }
}

class tested{
    public static void main(String[] arr){
       sortingFunction F=new sortingFunction();
        int[] Array ={10,20,30,23,43,23,56,54,32,53,60,1,23,6,3,54};
//        F.selectionSort(Array);
//        for (int i=0;i<Array.length;i++) System.out.print(Array[i]+"  ");
//        System.out.println();
        F.bubbleSort(Array);
        for (int i=0;i<Array.length;i++) System.out.print(Array[i]+"  ");
        System.out.println();
    }
}
