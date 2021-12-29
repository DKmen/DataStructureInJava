package codechef.December2021.lunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sleepTechnique {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public  static class second implements Comparator<Interval> {
        public int compare(Interval a, Interval b)
        {
            return a.end - b.end;
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new second());
        while (true) {
            boolean operationIsDoneOrNot = false;
            int index=1;
            while (index < intervals.size()) {
                if (intervals.get(index - 1).end >= intervals.get(index).start && intervals.get(index - 1).end <= intervals.get(index).end) {
                    intervals.get(index - 1).end = Math.max(intervals.get(index).end, intervals.get(index - 1).end);
                    intervals.get(index - 1).start = Math.min(intervals.get(index).start, intervals.get(index - 1).start);
                    operationIsDoneOrNot = true;
                    intervals.remove(index);
                } else if (intervals.get(index - 1).end > intervals.get(index).end) {
                    intervals.remove(index);
                } else {
                    index++;
                }
            }
            if(!operationIsDoneOrNot) break;
        }
        return intervals;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
            FastReader sc = new FastReader();
            int t = sc.nextInt();
            while(t--!=0){
                int numberOfIntervals = sc.nextInt();
                int A=sc.nextInt();
                int B=sc.nextInt();
                int endArrayIndex = B*(B+1)/2;
                int startArrayIndex = A*(A+1)/2;
                int[] joyArray = new int[endArrayIndex+1];
                for(int i=0;i<numberOfIntervals;i++){
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    for (int j=start;j<=end && j<joyArray.length;j++) joyArray[j]++;
                };
                int[] resultArray = new int[endArrayIndex-startArrayIndex+1];
                if (endArrayIndex + 1 - startArrayIndex >= 0)
                    System.arraycopy(joyArray, startArrayIndex, resultArray, 0, endArrayIndex + 1 - startArrayIndex);
                Arrays.sort(resultArray);
                System.out.println(resultArray[resultArray.length-1]);
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
