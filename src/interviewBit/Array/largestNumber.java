package interviewBit.Array;

import java.util.*;

public class largestNumber {

    public static String largestNumber(final List<Integer> A) {
        ArrayList<String> modifiedArrayList = new ArrayList<String>();
        int maxNumber = 0 ;
        for(Integer item : A){
            modifiedArrayList.add(item.toString());
            if(maxNumber<item) maxNumber=item;
        }

        int[] finalAllSum = new int[A.size()];
        Map<Integer,String> answerResult  = new HashMap<Integer,String>();
        boolean notZeroValueFind = false ;
        for(int i=0 ; i<finalAllSum.length ; i++){
            for(int j = 0; j< Integer.toString(maxNumber).length(); j++){
                if(Integer.decode(modifiedArrayList.get(i))!=0) notZeroValueFind = true;
                if(j>=modifiedArrayList.get(i).length()) finalAllSum[i]+=(Integer.decode(modifiedArrayList.get(i).substring(modifiedArrayList.get(i).length()-1))*(Integer.toString(maxNumber).length()-j));
                else finalAllSum[i]+=Integer.decode(modifiedArrayList.get(i).substring(j,j+1))*(Integer.toString(maxNumber).length()-j);
            }
            if(answerResult.containsKey(finalAllSum[i])){
                finalAllSum[i]+=Integer.decode(modifiedArrayList.get(i));
                answerResult.put(finalAllSum[i],modifiedArrayList.get(i));
            }else {
                answerResult.put(finalAllSum[i],modifiedArrayList.get(i));
            }
        }
        if(!notZeroValueFind) return "0";
        Arrays.sort(finalAllSum);
        String result="";
        for(int i=finalAllSum.length-1;i>=0;i--) result+=answerResult.get(finalAllSum[i]);
        return result;
    }

    public static void main(String[] arr){
        List<Integer> data = new ArrayList<Integer>();
        data.add(9);
        data.add(99);
        data.add(999);
        data.add(9999);
        data.add(9998);
        System.out.println(largestNumber(data));
    }

}
