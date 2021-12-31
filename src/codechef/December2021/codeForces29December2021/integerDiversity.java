package codechef.December2021.codeForces29December2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class integerDiversity {

    public static void main(String[] arr){
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t--!=0) {
            int sizeOfArray = sc.nextInt();
            Map<Integer,Integer> inputValueCountMap = new HashMap<Integer,Integer>();
            for (int i=0;i<sizeOfArray;i++){
                int inputValue = sc.nextInt();
                if(inputValue<0){
                    inputValue=inputValue*(-1);
                }
                if(inputValueCountMap.containsKey(inputValue)){
                    int oldValue = inputValueCountMap.get(inputValue);
                    inputValueCountMap.put(inputValue,oldValue+1);
                }else {
                    inputValueCountMap.put(inputValue,1);
                }
            }
            int totalDifferentNumber = 0;
            for (Map.Entry<Integer, Integer> entry : inputValueCountMap.entrySet()) {
                if(entry.getKey()==0){
                    totalDifferentNumber++;
                }else if(entry.getValue()>=2){
                    totalDifferentNumber+=2;
                }else {
                    totalDifferentNumber++;
                }
            }
            System.out.println(totalDifferentNumber);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
