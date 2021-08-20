package DataStructure.F_SortingAlgorithm;

public class QuickSort {

    public static void swap(int[] elementArray,int firstElement,int secoundElement){
        int temp=elementArray[firstElement];
        elementArray[firstElement]=elementArray[secoundElement];
        elementArray[secoundElement]=temp;
    }

    public static int partition(int[] elementArray, int startIndex, int endIndex){
        int key=elementArray[endIndex];
        int elementIndex=startIndex;
        int elementChangingIndex=startIndex-1;

        while (elementIndex<endIndex){
            if(key>elementArray[elementIndex]){
                elementChangingIndex++;
                swap(elementArray,elementIndex,elementChangingIndex);
            }
            elementIndex++;
        }
        swap(elementArray,elementChangingIndex+1,endIndex);
        return elementChangingIndex+1;
    }

    public static void quickSort(int[] elementArray,int startIndex,int endIndex){
        if(startIndex<endIndex){
            int partisanIndex= partition(elementArray,startIndex,endIndex);
            quickSort(elementArray,startIndex,partisanIndex-1);
            quickSort(elementArray,partisanIndex+1,endIndex);
        }
    }

    public static void main(String[] arr){
        int[] elementArray={50,23,9,18,61,32};
        quickSort(elementArray,0,elementArray.length-1);
        for(int element : elementArray) System.out.print(element+" ");
        System.out.println();
    }
}
