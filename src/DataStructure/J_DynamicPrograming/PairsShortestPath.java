package DataStructure.J_DynamicPrograming;

public class PairsShortestPath {
    public static void main(String[] arr){
        int totalNodes=4;
        int[][] adjacentMatrix={
                {0,3,Integer.MAX_VALUE,5},
                {2,0,Integer.MAX_VALUE,8},
                {Integer.MAX_VALUE,1,0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,2,0}
        };
        for(int i=0;i<totalNodes;i++){
            for(int j=0;j<adjacentMatrix.length;j++){
                if(j==i) continue;
                for(int k=0;k< adjacentMatrix.length;k++){
                    if(k==i) continue;
                    if(j==k) continue;
                    if(adjacentMatrix[j][i]==Integer.MAX_VALUE || adjacentMatrix[i][k]==Integer.MAX_VALUE) continue;
                    adjacentMatrix[j][k]=Math.min(adjacentMatrix[j][k],adjacentMatrix[j][i]+adjacentMatrix[i][k]);
                }
            }
        }
        for(int j=0;j<adjacentMatrix.length;j++){
            for(int k=0;k< adjacentMatrix.length;k++){
                System.out.print(adjacentMatrix[j][k]+" ");
            }
            System.out.println();
        }
    }
}
