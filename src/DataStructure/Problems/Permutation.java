package DataStructure.Problems;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutation {

    public static void printAllPermutation(int[] inputArray, ArrayList<Integer> ans){
        if(ans.size()==inputArray.length){
            for(int element=0;element<ans.size();element++) System.out.print(ans.get(element)+" ");
            System.out.println();
        }

        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i]==-1) continue;

            int[] modifyArray=inputArray.clone();
            modifyArray[i]=-1;

            ArrayList<Integer> modifyAns = new ArrayList<Integer>(ans);
            modifyAns.add(inputArray[i]);

            printAllPermutation(modifyArray,modifyAns);
        }
    }

    public static void main(String[] arr){

        Scanner sc=new Scanner(System.in);
        int[] inputArray={1,2,2};
        ArrayList<Integer> ans=new ArrayList<Integer>();
        printAllPermutation(inputArray,ans);

    }
}
