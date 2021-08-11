package DataStructure.A_BitManipulation;

//find unique number of given array

public class FindUniqueNumber {
    public static void main(String[] arr){
        int[] elementArray={2,5,5,3,3,4,4};

        int xorSum=elementArray[0];
        for(int i=1;i<elementArray.length;i++){
            xorSum=xorSum^elementArray[i];
        }
        System.out.println(xorSum);
    }
}
