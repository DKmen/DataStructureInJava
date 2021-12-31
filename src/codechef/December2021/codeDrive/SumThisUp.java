package codechef.December2021.codeDrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumThisUp {
    public static void main(String[] arr){
        try{
            FastReader sc = new FastReader();
            int t=sc.nextInt();
            while (t--!=0){
                int sizeOfArray=sc.nextInt();
                int ansSum=0;
                for(int i=0;i<sizeOfArray;i++){
                    int inputNumber=sc.nextInt();
                    ansSum+=inputNumber;
                }
                System.out.println(ansSum/sizeOfArray);
            }
        }catch (Exception ignored){

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
