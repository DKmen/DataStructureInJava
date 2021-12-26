package DataStructure.Problems;

import java.util.Stack;

public class largestRectangleInHistogram {

    public static int calculateMaximumArea(int[] elementArray){
        Stack<Integer> st=new Stack<Integer>();

        st.push(elementArray[0]);
        int area=0;
        for (int i=1;i<elementArray.length;i++){
            int length=1;
            while (!st.isEmpty() && elementArray[i]<st.peek()){
                int height=st.pop();
                area=Math.max(area,height*length);
                length++;
            }
            st.push(elementArray[i]);
        }

        int length=1;
        while (!st.isEmpty()){
            int height=st.pop();
            area=Math.max(area,height*length);
            length++;
        }

        return area;
    }

    public static void main(String[] arr){
        int[] elementArray={2,1,5,6,2,3};
        int maxArea=calculateMaximumArea(elementArray);
        System.out.println(maxArea);
    }
}
