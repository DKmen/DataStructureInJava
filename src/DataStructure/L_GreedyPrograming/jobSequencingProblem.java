package DataStructure.L_GreedyPrograming;

public class jobSequencingProblem {
    public static void main(String[] arr){
        int[] jobProfit=new int[]{35,30,25,20,15,12,5};
        int[] jobDeadline=new int[]{3,4,4,2,3,1,2};
        int totalAvailableSlots=4;
        boolean[] slotIsOccupied=new boolean[totalAvailableSlots];

        int makingProfit=0;

        for(int i=0;i<jobProfit.length;i++){
            boolean slotIsFind=false;
            for(int j=jobDeadline[i]-1;j>=0;j--){
                if(slotIsOccupied[j]==false){
                    slotIsOccupied[j]=true;
                    slotIsFind=true;
                    break;
                }
            }
            if(slotIsFind) makingProfit+=jobProfit[i];
        }

        System.out.println(makingProfit);
    }
}
