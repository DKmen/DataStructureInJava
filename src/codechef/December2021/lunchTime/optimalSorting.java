package codechef.December2021.lunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class optimalSorting {
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
    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            FastReader sc = new FastReader();
            int t = sc.nextInt();
            while(t--!=0){
                ArrayList<Interval> intervalItems = new ArrayList<Interval>();
                int size=sc.nextInt();
                int minPoint = Integer.MAX_VALUE;
                int maxPoint = Integer.MIN_VALUE;
                int result = 0;
                for (int i=1;i<=size ;i++ ){
                    int inputData = sc.nextInt();
                    if(inputData<minPoint) minPoint = inputData;
                    if(inputData>maxPoint){
                        if(maxPoint!=Integer.MIN_VALUE && minPoint!=Integer.MAX_VALUE){
                            intervalItems.add(new Interval(minPoint,maxPoint));
                            minPoint = inputData;
                        }
                        maxPoint = inputData;
                    }
                }
                intervalItems.add(new Interval(minPoint,maxPoint));
                Collections.sort(intervalItems,new second());
                while (true) {
                    boolean operationIsDoneOrNot = false;
                    int index=1;
                    while (index < intervalItems.size()) {
                        if (intervalItems.get(index - 1).end > intervalItems.get(index).start && intervalItems.get(index - 1).end <= intervalItems.get(index).end) {
                            intervalItems.get(index - 1).end = Math.max(intervalItems.get(index).end, intervalItems.get(index - 1).end);
                            intervalItems.get(index - 1).start = Math.min(intervalItems.get(index).start, intervalItems.get(index - 1).start);
                            operationIsDoneOrNot = true;
                            intervalItems.remove(index);
                        } else if (intervalItems.get(index - 1).end > intervalItems.get(index).end) {
                            intervalItems.remove(index);
                        } else {
                            index++;
                        }
                    }
                    if(!operationIsDoneOrNot) break;
                }
                for(Interval item : intervalItems) result+=item.end-item.start;
                System.out.println(result);
            }
        } catch(Exception e) {
            return;
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
