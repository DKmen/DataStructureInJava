package codechef.December2021.harbour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class constructRectangle {
    public static void main(String[] arr){
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t--!=0){
            int[] stickLength = new int[3];
            stickLength[0] = sc.nextInt();
            stickLength[1] = sc.nextInt();
            stickLength[2] = sc.nextInt();
            Arrays.sort(stickLength);
            if(stickLength[2]%2==0 && stickLength[0]==stickLength[1]){
                System.out.println("YES");
            }else if(stickLength[0]+stickLength[1]==stickLength[2]){
                System.out.println("YES");
            }else if(stickLength[1]==stickLength[2] && stickLength[0]%2==0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
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
