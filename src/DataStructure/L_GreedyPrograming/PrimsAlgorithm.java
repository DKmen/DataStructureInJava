package DataStructure.L_GreedyPrograming;

import java.util.HashMap;
import java.util.Map;

public class PrimsAlgorithm {
    public static void main(String[] arr){
        int[][] adjacentMatrix={
                {0,3,0,0},
                {3,0,2,4},
                {0,2,0,5},
                {0,4,5,0}
        };
        boolean[] visitedVertex=new boolean[4];

        Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
        for(int i=0;i<adjacentMatrix.length;i++){
            if(adjacentMatrix[0][i]!=0) temp.put(i,adjacentMatrix[0][i]);
        }


        int selectedVertx=0;
        int totalCost=0;

        int count=0;
        while (true){
            int minValue=Integer.MAX_VALUE;
            visitedVertex[selectedVertx]=true;
            count++;
            if(count==4) break;

            for(Map.Entry m:temp.entrySet()){
                if(minValue > (int)m.getValue()){
                    minValue = (int) m.getValue();
                    selectedVertx=(int) m.getKey();
                }
            }

            for(Map.Entry m:temp.entrySet()){
                System.out.print(" "+m.getKey()+"  "+m.getValue()+"  ");
            }
            System.out.println();
            temp.remove(selectedVertx,minValue);
            for(int i=0;i<adjacentMatrix.length;i++){
                if(adjacentMatrix[selectedVertx][i]!=0 && !visitedVertex[i]) temp.put(i,adjacentMatrix[selectedVertx][i]);
            }

            totalCost+=minValue;
        }
        System.out.println(totalCost);
    }
}
