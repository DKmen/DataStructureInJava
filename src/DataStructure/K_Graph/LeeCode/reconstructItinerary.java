package DataStructure.K_Graph.LeeCode;

import java.util.LinkedList;
import java.util.Queue;

public class reconstructItinerary {
    public static String printRout(int[][] adjacentMatrix){

        return "";
    }
    public static void main(String[] arr){
        int[][] adjacentMatrix={
                {0,1,1},
                {1,0,1},
                {1,0,0}
        };
        String ans="";
        Queue<Integer> tempQueue=new LinkedList<Integer>();
        tempQueue.add(1);
        while (!tempQueue.isEmpty()){
            int peekElement=tempQueue.peek();
            for(int i=0;i<adjacentMatrix[peekElement].length;i++){
                if(adjacentMatrix[peekElement][i]!=0){
                    tempQueue.add(i);
                    adjacentMatrix[peekElement][i]=0;
                    break;
                }
            }
            System.out.println(tempQueue.remove());
        }
    }
}
