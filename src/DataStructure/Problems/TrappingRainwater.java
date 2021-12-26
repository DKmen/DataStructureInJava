package DataStructure.Problems;

import java.util.Stack;

public class TrappingRainwater {

    public static int calculateTotalWater(int[] blockSize){
        Stack<Integer> st=new Stack<Integer>();

        int ans=0;
        for (int i=0;i<blockSize.length;i++){
            while (!st.isEmpty() && blockSize[st.peek()]<blockSize[i]){
                int blockIndex=st.pop();
                if(st.isEmpty()) break;
                ans+=((Math.min(blockSize[st.peek()],blockSize[i])-blockSize[blockIndex])*(i-st.peek()-1));
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] arr){
        int[] blockSize={0,1,0,2,1,0,1,3,2,1,2,1};
        int storeWater=calculateTotalWater(blockSize);
        System.out.println(storeWater);
    }
}
