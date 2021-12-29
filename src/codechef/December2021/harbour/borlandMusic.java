package codechef.December2021.harbour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class borlandMusic {
    public static void main(String[] arr){
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int[] indexArray = new int[n];
            int[] resultArray = new int[n];
            for(int i=0;i<n;i++){
                int item=sc.nextInt();
                indexArray[item-1]=i;
            }
            String likeDislikeString = sc.nextLine();
            int totalZeros = 0;
            for(int i=0;i<likeDislikeString.length();i++){
                if(likeDislikeString.charAt(i)=='0') totalZeros++;
            }
            int dislikeStartPoint = 1;
            int likeStartPoint = totalZeros+1;
            for(int i=1;i<=n;i++){
                int index = indexArray[i-1];
                if(likeDislikeString.charAt(index)=='0'){
                    resultArray[index]=dislikeStartPoint;
                    dislikeStartPoint++;
                }else {
                    resultArray[index]=likeStartPoint;
                    likeStartPoint++;
                }
            }
            System.out.println();
            for(int item : resultArray ) System.out.print(item+" ");
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
