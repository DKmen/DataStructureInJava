package Algorithm.Searching;

public class searchFunction {

    /*
    A simple approach is to do a linear search, i.e
        Start from the leftmost element of arr[] and one by one compare x with
        each element of arr[]
        If x matches with an element, return the index.
        If x does’t match with any of elements, return -1.
    */
    public int LinearSearch(int key,int[] array){

        for(int i=0;i<array.length;i++) if(key==array[i]) return i;
        return -1;

    }

    //Binary Search is used to searching in sorting array
    public int BinarySearch(int key,int[] array){
        int startIndex=0;
        int endIndex=array.length-1;
        while (startIndex<=endIndex){
            int midPoint=(startIndex+endIndex)/2;
            if(array[midPoint]<key) startIndex=midPoint+1;
            else if(array[midPoint]>key) endIndex=midPoint-1;
            else return midPoint;
        }
        return -1;
    }

    public int BinarySearch(int key,int[] array,int start,int end){
        if(start>end) return -1;

        int midPoint=(start+end)/2;
        if(array[midPoint]<key) return BinarySearch(key,array,midPoint+1,end);
        else if(array[midPoint]>key) return BinarySearch(key,array,start,midPoint-1);
        else return midPoint;
    }

    /*
    For example, suppose we have an array arr[] of size n and block (to be jumped) size m. Then we search at the    indexes arr[0], arr[m], arr[2m]…..arr[km] and so on. Once we find the interval (arr[km] < x < arr[(k+1m], we    perform a linear search operation from the index km to find the element x.
    Let’s consider the following array: (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610). Length of    the array is 16. Jump search will find the value of 55 with the following steps assuming that the block size    to be jumped is 4.
        STEP 1: Jump from index 0 to index 4;
        STEP 2: Jump from index 4 to index 8;
        STEP 3: Jump from index 8 to index 12;
        STEP 4: Since the element at index 12 is greater than 55 we will jump back a step to come to index 8.
        STEP 5: Perform linear search from index 8 to get the element 55.
    */

    public int jumpSearch(int key,int[] array){
        int jumpInterVel=(int)Math.floor(Math.sqrt(array.length));
//        System.out.println(jumpInterVel);
        int searchInterVel=jumpInterVel;
        while (searchInterVel<array.length){
            if(array[Math.min(searchInterVel-1,array.length-1)]<key){
                searchInterVel=searchInterVel+jumpInterVel;
            }else {
                searchInterVel-=jumpInterVel;
                break;
            }
        }

        if(searchInterVel>array.length) searchInterVel-=jumpInterVel;
        for (int i=searchInterVel;i<=(searchInterVel+jumpInterVel) && i<array.length;i++){
            if(array[i]==key) return i;
        }
        return -1;
    }
}

class tested{
    public static void main(String[] arr){
        searchFunction F=new searchFunction();
        int[] Array ={10,20,30,23,43,23,56,54,32,53,60,1,23,6,3,54};
        int[] arraySorted ={10,20,40,50,70,80,81,90,92,94,96,99,102,120};
        System.out.println(F.LinearSearch(1,Array));
        System.out.println(F.BinarySearch(40,arraySorted,0,arraySorted.length-1));
        System.out.println(F.BinarySearch(70,arraySorted));
        System.out.println(F.jumpSearch(70,arraySorted));
    }
}
