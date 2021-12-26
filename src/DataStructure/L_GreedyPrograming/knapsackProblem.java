package DataStructure.L_GreedyPrograming;

public class knapsackProblem {
    public static void main(String[] arr){
        int[] profit=new int[]{10,5,15,7,6,18,3};
        int[] weight=new int[]{2,3,5,7,1,4,1};
        float[] profitRatio=new float[profit.length];
        int availableWeight=15;
        float makeProfit=0;

        for(int i=0;i<profit.length;i++){
            profitRatio[i]=(float) profit[i]/weight[i];
        }

        while (availableWeight>0){
            float maxProfitRatio=Integer.MIN_VALUE;
            int maxProfitRatioIndex=-1;
            for(int i=0;i<profitRatio.length;i++){
                if(profitRatio[i]>maxProfitRatio && weight[i]>0){
                    maxProfitRatioIndex=i;
                    maxProfitRatio=profitRatio[i];
                }
            }
            if(weight[maxProfitRatioIndex]>availableWeight){
                makeProfit+=maxProfitRatio*availableWeight;
                weight[maxProfitRatioIndex]-=availableWeight;
                availableWeight=0;
            }else {
                makeProfit+=maxProfitRatio*weight[maxProfitRatioIndex];
                availableWeight-=weight[maxProfitRatioIndex];
                weight[maxProfitRatioIndex]=0;
            }
        }
        System.out.println(makeProfit);
    }
}
