package hackerrank;

/*
Given an amount and the denominations of coins available, determine how many ways change can be made for amount. There is a limitless supply of each coin type.
 */

public class CoinChangeProblem {

    public static int countTotalWayForGivenChange(int[] coin,int change,int startIndex,int[][] ansArray){
        if(change==0) return 1;
        if(ansArray[change][startIndex]!=0) return ansArray[change][startIndex];

        int count=0;
        for (int i=startIndex;i<coin.length;i++) {
            if ( coin[i] <= change) count +=countTotalWayForGivenChange(coin, change - coin[i],i,ansArray);
        }
        ansArray[change][startIndex]=count;
        return count;
    }

    public static void main(String[] arr){
        int change=4;
        int[] availableCoin={1,2,3};
        int[][] ansArray=new int[change+1][availableCoin.length];
        System.out.println(countTotalWayForGivenChange(availableCoin,change,0,ansArray));
    }
}
