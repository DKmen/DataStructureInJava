package DataStructure.Problems;

// if arr[i]>arr[j] and i< j then call inversion so count inversion in given array

public class CountInversion {

    public static int mergeArray(int[] elementArray,int startIndex,int endIndex){
        int mid=(startIndex+endIndex)/2;
        int[] leftArray=new int[mid-startIndex+1];
        int[] rightArray=new int[endIndex-mid];
        int inversion=0;

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
                inversion+=(leftArray.length-leftIndex);
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
        return  inversion;
    }

    public static int mergeSort(int[] elementArray,int startIndex,int endIndex){
        if(startIndex<endIndex){
            int mid=(startIndex+endIndex)/2;
            int leftInversion= mergeSort(elementArray,startIndex,mid);
            int rightInversion= mergeSort(elementArray,mid+1,endIndex);
            int inversion=mergeArray(elementArray,startIndex,endIndex);
            return leftInversion+rightInversion+inversion;
        }
        return 0;
    }

    public static void main(String[] arr){
        int[] elementArray={3,2,1};
        System.out.println(mergeSort(elementArray,0,elementArray.length-1));
    }
}
