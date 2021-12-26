package interviewBit.Array;

import java.util.ArrayList;

public class rotateMatrix {
    public static ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int index = a.size()-1;
        int resultSize = a.get(0).size();
        for(int i=1;i<=resultSize;i++){
            result.add(new ArrayList<Integer>());
        }
        for(int i=index;i>=0;i--){
            int rowIndex=0;
            int colIndex=index-i;
            for(int item : a.get(i)){
                result.get(rowIndex).add(colIndex,item);
                rowIndex++;
            }
        }
        return result;
    }
    public static void main(String[] arr){
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<>());
        input.add(new ArrayList<>());
        input.get(0).add(1);
        input.get(0).add(2);
        input.get(1).add(3);
        input.get(1).add(4);
        input=rotate(input);
        for(ArrayList<Integer> i:input){
            for(int value:i){
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
