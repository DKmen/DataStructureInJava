package DataStructure.F_SortingAlgorithm;

public class MergeSort {

    public static void mergeArray(int[] elementArray,int startIndex,int endIndex){
        int mid=(startIndex+endIndex)/2;
        int[] leftArray=new int[mid-startIndex+1];
        int[] rightArray=new int[endIndex-mid];

        for(int i=0;i<leftArray.length;i++){
            leftArray[i]=elementArray[startIndex+i];
        }
        for(int i=0;i<rightArray.length;i++){
            rightArray[i]=elementArray[mid+1+i];
        }

        int leftIndex=0,rightIndex=0;
        for(int i=startIndex;i<=endIndex;i++){
            if(leftIndex<leftArray.length && rightIndex<rightArray.length && leftArray[leftIndex]<rightArray[rightIndex]){
                elementArray[i]=leftArray[leftIndex];
                leftIndex++;
            }
            else if(leftIndex<leftArray.length && rightIndex<rightArray.length && leftArray[leftIndex]>rightArray[rightIndex]){
                elementArray[i]=rightArray[rightIndex];
                rightIndex++;
            }

            else if(rightIndex>=rightArray.length && leftIndex<leftArray.length){
                elementArray[i]=leftArray[leftIndex];
                leftIndex++;
            }
            else {
                elementArray[i]=rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void mergeSort(int[] elementArray,int startIndex,int endIndex){
        if(startIndex<endIndex){
            int mid=(startIndex+endIndex)/2;
            mergeSort(elementArray,startIndex,mid);
            mergeSort(elementArray,mid+1,endIndex);
            mergeArray(elementArray,startIndex,endIndex);
        }
    }

    public static void main(String[] arr){
        int[] elementArray={10,2,5,1,6,4,3,8,7,9};
        mergeSort(elementArray,0,elementArray.length-1);
        for(int element : elementArray) System.out.print(element+" ");
        System.out.println();
    }
}
