package DataStructure.D_Recursion;

import java.util.Scanner;

//count all possible path of by given dice

public class CountTotalPossiblePath {

    public static void countTotalNumberOfPath(int pathLength,String ans,int[] dice){
        if(pathLength==1){
            System.out.println(ans);
        }
        for(int i=0;i<dice.length;i++){
            if((pathLength-dice[i])>=1){
                countTotalNumberOfPath(pathLength-dice[i],ans+String.valueOf(dice[i]),dice);
            }
        }
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int pathLength=sc.nextInt();
        int[] dice={1,2,3,4,5,6};
        countTotalNumberOfPath(pathLength,"",dice);
    }
}
