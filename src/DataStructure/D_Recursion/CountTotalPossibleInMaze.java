package DataStructure.D_Recursion;

import java.util.Scanner;

// count all possible path of maze

public class CountTotalPossibleInMaze {

    public static int countTotalPossiblePath(int dimension,int x,int y){
        if(x==(dimension-1) && y==(dimension-1)) return 1;
        if(x>=dimension || y>=dimension) return 0;

        return countTotalPossiblePath(dimension,x+1,y)+countTotalPossiblePath(dimension,x,y+1);
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int dimension=sc.nextInt();
        int ans = countTotalPossiblePath(dimension,0,0);
        System.out.println(ans);
    }
}
