package DataStructure.J_DynamicPrograming;

public class StockMaximizeProfile {
    public static int maxProfit(int[] val, int availableStock, int prize, int day){
        if(day==val.length) return prize;
        if(availableStock!=0){
            int temp=Math.max(maxProfit(val,availableStock+1,prize-val[day],day+1), maxProfit(val,0,prize+val[day]*availableStock,day+1));
            return Math.max(temp, maxProfit(val,availableStock,prize,day+1));
        }else {
            return Math.max(maxProfit(val,availableStock+1,prize-val[day],day+1), maxProfit(val,availableStock,prize,day+1));
        }
    }
    public static void main(String[] arr){
        int[] val={1,2,100};
        System.out.println(maxProfit(val,0,0,0));
    }
}
