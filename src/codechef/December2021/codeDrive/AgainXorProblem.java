package codechef.December2021.codeDrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AgainXorProblem {
    public static void main(String[] arr){
        FastReader sc = new FastReader();
        int t=sc.nextInt();
        while (t--!=0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            String inputString = sc.nextLine();
            StringBuilder answerString =new StringBuilder() ;
            int[] countOfOnes=new int[n];
            countOfOnes[0]=Integer.parseInt(String.valueOf(inputString.charAt(0)));
            for(int i=1;i<n;i++){
                if(Integer.parseInt(String.valueOf(inputString.charAt(i)))==1) countOfOnes[i] = countOfOnes[i-1]+1;
                else countOfOnes[i]=countOfOnes[i-1];
            }
            for(int i=0;i<k;i++){
                if((countOfOnes[i]-countOfOnes[i+n-k]+Integer.parseInt(String.valueOf(inputString.charAt(i))))%2==0) answerString.append(String.valueOf(0));
                else answerString.append(String.valueOf(1));
            }
            int count=0;
            for(int i=0;i<answerString.length();i++){
                if(answerString.charAt(i)=='1') count++;
            }
            System.out.println(count);
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
