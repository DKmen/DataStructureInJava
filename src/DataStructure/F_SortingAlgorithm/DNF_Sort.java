package DataStructure.F_SortingAlgorithm;

// only work for  0 , 1 and 2 contain array

public class DNF_Sort {

    public static void swap(int[] elementArray,int firstIndex,int secondIndex){
        int temp=elementArray[firstIndex];
        elementArray[firstIndex]=elementArray[secondIndex];
        elementArray[secondIndex]=temp;
    }

    public static void dnfSorting(int[] elementArray){
        int low=0;
        int mid=0;
        int high=elementArray.length-1;

        while (mid<=high){
            if(elementArray[mid]==0){
                swap(elementArray,low,mid);
                low++;
                mid++;
            }else if(elementArray[mid]==2){
                swap(elementArray,high,mid);
                high--;
            }else {
                mid++;
            }
        }
    }

    public static void main(String[] arr){
        int[] elementArray={1,0,0,2,1,1,2,0,2,0,1,1};
        dnfSorting(elementArray);
        for(int element : elementArray) System.out.print(element+" ");
        System.out.println();
    }
}
