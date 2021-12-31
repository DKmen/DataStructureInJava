package codechef.December2021.codeForces29December2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class representativeEdges {
    public static void main(String[] arr){
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t--!=0) {
            int sizeOfArray = sc.nextInt();
            int[] inputArray =new int[sizeOfArray];
            int totalUnOrderCount =Integer.MAX_VALUE;
            for(int i=0;i<inputArray.length;i++){
                inputArray[i]= sc.nextInt();
            }
            if(sizeOfArray==1 || sizeOfArray==2){
                System.out.println("0");
                continue;
            }
            for(int i=0;i<sizeOfArray;i++){
                for (int j=i+1;j<sizeOfArray;j++){
                    int d = (inputArray[i]-inputArray[j])/(j-i);
                    int startingTerm = inputArray[i] - d*i;
                    int tempCount=0;
                    for(int k=0;k<sizeOfArray;k++){
                        if(inputArray[k]!=(startingTerm+d*k)) tempCount++;
                    }
                    totalUnOrderCount = Math.min(tempCount,totalUnOrderCount);
                }
            }
            System.out.println(totalUnOrderCount);
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
