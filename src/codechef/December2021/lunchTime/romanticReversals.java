package codechef.December2021.lunchTime;

import java.util.*;
import java.lang.*;
import java.io.*;
/* Name of the class has to be "Main" only if the class is public. */
public class romanticReversals
{
    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t--!=0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String inputString = sc.nextLine();
            StringBuilder resultString = new StringBuilder();
            int startIndex=0;
            int endIndex= K-1;
            boolean choseAlternative = true;
            while (startIndex<=endIndex){
                if(choseAlternative){
                    resultString.append(inputString.charAt(startIndex));
                    startIndex++;
                    choseAlternative=false;
                }else {
                    resultString.append(inputString.charAt(endIndex));
                    endIndex--;
                    choseAlternative=true;
                }
            }
            resultString.reverse();
            resultString.append(inputString.substring(K,N));
            System.out.println(resultString);
//            for (int i = K; i > 1; i--) {
//                System.out.println(i);
//                StringBuilder reverseString = new StringBuilder();
//                reverseString.append(inputString.substring(0,i));
//                reverseString.reverse();
//                String remainingString = "";
//                if ((i) != inputString.length()) remainingString = inputString.substring(i);
//                inputString = reverseString + remainingString;
//            }
//            System.out.println(inputString);
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
