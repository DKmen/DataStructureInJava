package DataStructure.J_DynamicPrograming;

public class SubsetSumProblem {

    public static boolean sumPresent(int[] array,int sum,int start,int end){
        if(sum==0) return true;
        if(start==array.length) return false;

        for(int i=start;i<=end;i++){
            if(array[i]<sum){
                if(sumPresent(array, sum - array[i], i + 1, end)) return true;
            }
        }

        return false;
    }

    public static void main(String[] arr){
        int[] array={2,3,5,6,7};
        int sum=11;
        System.out.println(sumPresent(array,sum,0,array.length-1));
    }
}
