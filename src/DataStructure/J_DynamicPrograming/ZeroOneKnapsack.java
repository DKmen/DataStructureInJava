package DataStructure.J_DynamicPrograming;

public class ZeroOneKnapsack {

    public static int zeroOneKnapsack(int[] weightArray,int[] prizeArray,int availableWeight,int remainSize,int[][] ansArray,int count){
        if(availableWeight==0 || remainSize==0){
            return 0;
        }
        count++;
        if(ansArray[availableWeight][remainSize]!=0) return ansArray[availableWeight][remainSize];
        if(availableWeight>=weightArray[remainSize-1]){
            return ansArray[availableWeight][remainSize]=Math.max(prizeArray[remainSize-1]+zeroOneKnapsack(weightArray,prizeArray,availableWeight-weightArray[remainSize-1],remainSize-1,ansArray,count),zeroOneKnapsack(weightArray,prizeArray,availableWeight,remainSize-1,ansArray,count));
        }else{
            return ansArray[availableWeight][remainSize]=zeroOneKnapsack(weightArray,prizeArray,availableWeight,remainSize-1,ansArray,count);
        }
    }

    public static void main(String[] arr){
        int[] val={10,5,6,8,10};
        int[] wei={10,5,12,5,12};
        int weight=20;
        int[][] ansArray=new int[weight+1][wei.length+1];
//        for(int i=1;i<=weight;i++){
//            for(int j=1;j<=val.length;j++){
//                if(wei[j-1]<=i){
//                    ansArray[i][j]=Math.max(val[j-1]+ansArray[i-wei[j-1]][j-1],+ansArray[i][j-1] );
//                }else{
//                    ansArray[i][j]=ansArray[i][j-1];
//                }
//            }
//        }
        System.out.println(zeroOneKnapsack(wei,val,weight,val.length,ansArray,0));
    }
}
