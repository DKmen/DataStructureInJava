package DataStructure.Problems;

public class numberOfIslands {

    public static void makeIsland(int[][] inputArray,int x,int y){
        if(x<0 || x>=inputArray.length ) return;
        if(y<0 || y>=inputArray[0].length ) return;

        if(inputArray[x][y]!=1) return;
        inputArray[x][y]=2;

            makeIsland(inputArray,x-1,y);
            makeIsland(inputArray,x+1,y);
            makeIsland(inputArray,x,y+1);
            makeIsland(inputArray,x,y-1);
    }

    public static void main(String[] arr){
        int[][] inputArray={
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };

        int numberOfIsland=0;
        for(int i=0;i<inputArray.length;i++){
            for(int j=0;j<inputArray[i].length;j++){
                if(inputArray[i][j]==1){
                    makeIsland(inputArray,i,j);
                    numberOfIsland++;
                }
            }
        }
        System.out.println(numberOfIsland);
    }
}
