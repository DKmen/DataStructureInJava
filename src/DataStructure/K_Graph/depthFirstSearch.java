package DataStructure.K_Graph;

public class depthFirstSearch {

    public static void depthFirstSearchPrint(int[][] adjacentGraphMatrix,int node){
        adjacentGraphMatrix[node][0]=1;
        for (int i=1;i<adjacentGraphMatrix[0].length;i++){
            if(adjacentGraphMatrix[node][i]==1 && adjacentGraphMatrix[i-1][0]!=1) depthFirstSearchPrint(adjacentGraphMatrix,i-1);
        }
        System.out.print(node+" ");
    }

    public static void main(String[] arr){
        int[][] adjacentGraphMatrix={{0,0,1,0,1,0,0,0},
                                     {0,1,0,1,1,0,1,1},
                                     {0,0,1,0,1,1,1,0},
                                     {0,1,1,1,0,1,0,0},
                                     {0,0,0,1,0,1,0,1},
                                     {0,0,1,1,0,0,0,0},
                                     {0,0,1,0,0,1,0,0}};

//        Stack<Integer> resultStack=new Stack<Integer>();
//        resultStack.push(0);
//
//        while (!resultStack.isEmpty()){
//            adjacentGraphMatrix[resultStack.peek()][0]=1;
//            int peekElement=resultStack.pop();
//            for(int i=1;i<adjacentGraphMatrix[peekElement].length;i++){
//                if(adjacentGraphMatrix[peekElement][i]==1 && adjacentGraphMatrix[i-1][0]!=1){
//                    resultStack.push(i-1);
//                    adjacentGraphMatrix[i-1][0]=1;
//                }
//            }
//            System.out.print(peekElement+" ");
//        }
        depthFirstSearchPrint(adjacentGraphMatrix,0);
    }
}
