package codechef.December2021.codeForces28December2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class robotCleaner {
    public static void main(String[] arr){
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t--!=0){
            int totalRows = sc.nextInt();
            int totalColumn = sc.nextInt();
            int initialPositionRowValue = sc.nextInt();
            int initialPositionColumnValue = sc.nextInt();
            int dirtyCellPositionRowValue = sc.nextInt();
            int dirtyCellPositionColumnValue = sc.nextInt();
            int richToRow = 0;
            int richToColumn = 0;
            if(initialPositionRowValue <= dirtyCellPositionRowValue){
                richToRow = dirtyCellPositionRowValue - initialPositionRowValue;
            }else {
                richToRow = (totalRows - initialPositionRowValue)*2 +initialPositionRowValue - dirtyCellPositionRowValue ;
            }
            if(initialPositionColumnValue <= dirtyCellPositionColumnValue ){
                richToColumn = dirtyCellPositionColumnValue - initialPositionColumnValue;
            }else {
                richToColumn = (totalColumn - initialPositionColumnValue)*2 +initialPositionColumnValue - dirtyCellPositionColumnValue ;
            }
            System.out.println(Math.min(richToColumn,richToRow));
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
