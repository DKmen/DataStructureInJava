package DataStructure.L_GreedyPrograming;

import java.util.HashSet;

public class KruskalAlgorithm {
    public static void main(String[] arr){
        int totalNodes = 4;
        int[][] adjacentMatrix={
                {0,3,0,0},
                {3,0,2,4},
                {0,2,0,5},
                {0,4,5,0}
        };

        int totalCost=0;


        HashSet<Integer> vertexSet = new HashSet<Integer>();
        while (vertexSet.size()<totalNodes){
            int minimumCost=Integer.MAX_VALUE;
            int firstNode=0;
            int secondNode=0;
            for(int i=0;i<adjacentMatrix.length;i++) {
                for (int j = 0; j < adjacentMatrix[i].length; j++) {
                    if (adjacentMatrix[i][j] < minimumCost && adjacentMatrix[i][j]!=0) {
                        firstNode = i;
                        secondNode = j;
                        minimumCost = adjacentMatrix[i][j];
                    }
                }
            }
            boolean firstNodeIsContain = false,secondNodeIsContain=false;
            for(int data : vertexSet){
                if(data==firstNode) firstNodeIsContain=true;
                if(data==secondNode) secondNodeIsContain=true;
            }
            adjacentMatrix[firstNode][secondNode]=0;
            if(firstNodeIsContain && secondNodeIsContain){
                continue;
            }
            else {
                vertexSet.add(firstNode);
                vertexSet.add(secondNode);
                totalCost += minimumCost;
            }
        }
        System.out.println(totalCost);
    }
}
