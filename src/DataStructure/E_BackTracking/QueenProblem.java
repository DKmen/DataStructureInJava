package DataStructure.E_BackTracking;

// arrange n queen in nxn bord such that any queen not kill other queen

import java.util.Scanner;

public class QueenProblem {

    public static boolean isSafePlace(int x,int y,int[][] chessBord){
        int i=x,j=y;
        while (i>=0 && j<chessBord.length){
            if(chessBord[i][j]==1){
                return false;
            }
            i--;
            j++;
        }
        i=x;
        j=y;
        while (i>=0 && j>=0){
            if(chessBord[i][j]==1){
                return false;
            }
            i--;
            j--;
        }
        i=x;
        j=y;
        while (i>=0){
            if(chessBord[i][j]==1){
                return false;
            }
            i--;
        }

        return true;
    }

    public static boolean arrangeRightPlace(int[][] chessBord,int row){
        if(row==chessBord.length) return true;

        for (int i=0;i<chessBord[row].length;i++){
            if(isSafePlace(row,i,chessBord)){
                chessBord[row][i]=1;
                if(arrangeRightPlace(chessBord,row+1)){
                    return true;
                }
                chessBord[row][i]=0;
            }
        }

        return false;
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] chessBord=new int[N][N];
        arrangeRightPlace(chessBord,0);
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++) System.out.print(chessBord[i][j]+" ");
            System.out.println();
        }
    }
}
