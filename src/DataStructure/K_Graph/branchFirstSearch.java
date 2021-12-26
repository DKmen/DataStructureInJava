package DataStructure.K_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class branchFirstSearch {
    public static void main(String[] arr){
        int[][] adjacentGraphMatrix={{0,0,1,0,1,0,0,0},
                                     {0,1,0,1,1,0,1,1},
                                     {0,0,1,0,1,1,1,0},
                                     {0,1,1,1,0,1,0,0},
                                     {0,0,0,1,0,1,0,1},
                                     {0,0,1,1,0,0,0,0},
                                     {0,0,1,0,0,1,0,0}};


        Queue<Integer> makeResultQueue=new LinkedList<Integer>();
        makeResultQueue.add(2);

        while (!makeResultQueue.isEmpty()){
            for(int i=1;i<adjacentGraphMatrix[makeResultQueue.peek()].length;i++){
                if(adjacentGraphMatrix[makeResultQueue.peek()][i]==1 && adjacentGraphMatrix[i-1][0]!=1){
                    makeResultQueue.add(i-1);
                    adjacentGraphMatrix[i-1][0]=1;
                }
            }
            adjacentGraphMatrix[makeResultQueue.peek()][0]=1;
            System.out.print(makeResultQueue.remove()+" ");
        }
    }
}
