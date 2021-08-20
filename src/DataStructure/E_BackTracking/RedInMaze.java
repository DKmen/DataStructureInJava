package DataStructure.E_BackTracking;

// find possible path for red to reach to end of maz

public class RedInMaze {

    public static boolean isMove(int x,int y,int[][] maz){
        return (x < maz.length && y < maz[0].length && maz[x][y] == 1);
    }

    public static boolean findPossiblePath(int[][] maz,int[][] ans,int x,int y){

        if(x==(maz.length-1) && y==(maz[0].length-1)){
            ans[x][y]=1;
            return true;
        }

        if(isMove(x,y,maz)){
            ans[x][y]=1;
            if(findPossiblePath(maz,ans,x+1,y)) return true;
            if(findPossiblePath(maz,ans,x,y+1)) return true;
            ans[x][y]=0; // Backtracking
            return false;
        }
        return false;
    }

    public static void main(String[] arr){
        int[][] maz={{1,0,1,0,1},{1,1,1,1,1},{0,1,0,1,0},{1,0,0,1,1},{1,1,1,0,1}};
        int[][] ans=new int[maz.length][maz[0].length];

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j]=0;
            }
        }

        findPossiblePath(maz,ans,0,0);

        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
