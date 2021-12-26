package interviewBit.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mergeOverlappingIntervals {
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
    public static void main(String[] arr){
        ArrayList<Interval> intervalItems = new ArrayList<Interval>();
        intervalItems.add(new Interval(54,75));
        intervalItems.add(new Interval(56,60));
        intervalItems.add(new Interval(61,86));
        intervalItems.add(new Interval(22,43));
        intervalItems.add(new Interval(56,87));
        intervalItems.add(new Interval(32,53));
        intervalItems.add(new Interval(14,81));
        intervalItems.add(new Interval(64,65));
        intervalItems.add(new Interval(9,42));
        intervalItems.add(new Interval(12,33));
        intervalItems.add(new Interval(22,58));
        intervalItems.add(new Interval(84,90));
        intervalItems.add(new Interval(27,59));
        intervalItems.add(new Interval(41,48));
        intervalItems.add(new Interval(43,47));
        intervalItems.add(new Interval(22,29));
        intervalItems.add(new Interval(16,23));
        intervalItems.add(new Interval(41,72));
        intervalItems.add(new Interval(15,87));
        intervalItems.add(new Interval(20,59));
        intervalItems.add(new Interval(45,84));
        intervalItems.add(new Interval(14,77));
        intervalItems.add(new Interval(72,93));
        intervalItems.add(new Interval(20,58));
        intervalItems.add(new Interval(47,53));
        intervalItems.add(new Interval(25,88));
        intervalItems.add(new Interval(5,89));
        intervalItems.add(new Interval(34,97));
        intervalItems.add(new Interval(14,47));
        intervalItems = merge(intervalItems);
//        (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)
//        ( 54, 75), (56, 60), (61, 86), (22, 43), (56, 87), (32, 53), (14, 81), (64, 65), (9, 42), (12, 33), (22, 58), (84, 90), (27, 59), (41, 48), (43, 47), (22, 29), (16, 23), (41, 72), (15, 87), (20, 59), (45, 84), (14, 77), (72, 93), (20, 58), (47, 53), (25, 88), (5, 89), (34, 97), (14, 47)
        for(Interval item : intervalItems) System.out.print("[ "+item.start+" , "+item.end+" ]  ");

    }
}
