package DataStructure.K_Graph;

public class detectCycleInUndirectedGraph {

    public static boolean detectCycle(int[][] adjacentMatrix,int[] nodeVisitedCount,int node){
        if(nodeVisitedCount[node]==2) return true;
        nodeVisitedCount[node]++;
        for(int i=0;i<adjacentMatrix[node].length;i++){
            if(adjacentMatrix[node][i]==1){
                if(nodeVisitedCount[adjacentMatrix[node][i]]==1) nodeVisitedCount[adjacentMatrix[node][i]]++;
                else {
                    if(detectCycle(adjacentMatrix,nodeVisitedCount,i)) return true;
                }
            }
        }
        nodeVisitedCount[node]--;
        return false;
    }

    public static boolean detectCycleInGraph(int[][] adjacentMatrix){
        for (int i=0;i<adjacentMatrix.length;i++){
            int[] nodeVisitedCount=new int[adjacentMatrix.length];
            if(detectCycle(adjacentMatrix,nodeVisitedCount,i)) return true;
        }
        return false;
    }

    public static void main(String[] arr){
        int[][] adjacentMatrix={
                {0,1,1,1},
                {1,0,0,0},
                {1,0,0,1},
                {1,0,1,0}
        };
        System.out.println(detectCycleInGraph(adjacentMatrix));
    }
}
