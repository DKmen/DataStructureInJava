package DataStructure.K_Graph;

public class detectCycleInDirectedGraph {
    private static boolean detectCycle(int[][] adjacentMatrix,boolean[] visitedArray,int node){
        if(visitedArray[node]) return true;
        visitedArray[node]=true;
        for(int i=0;i<adjacentMatrix[node].length;i++){
            if(adjacentMatrix[node][i]==1){
                if(detectCycle(adjacentMatrix,visitedArray,i)){
                    visitedArray[node]=false;
                    return true;
                }
            }
        }
        visitedArray[node]=false;
        return false;
    }

    public static void detectCycleInGraph(int[][] adjacentMatrix,boolean[] visitedArray){
        for(int i=0;i<adjacentMatrix.length;i++){
            if(detectCycle(adjacentMatrix,visitedArray,i)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
    public static void main(String[] arr){
        int[][] adjacentMatrix={
                {0,1,0,0,0},
                {0,0,0,0,0},
                {0,1,0,1,0},
                {0,0,0,0,1},
                {1,0,1,0,0}
        };
        boolean[] visitedArray=new boolean[adjacentMatrix.length];
        detectCycleInGraph(adjacentMatrix,visitedArray);
    }
}
