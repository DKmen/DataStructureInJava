package interviewBit.Array;

import java.util.ArrayList;

public class mergeIntervals {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
  public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval.end < intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }
        if(intervals.get(0).start>=newInterval.start && intervals.get(intervals.size()-1).end<= newInterval.end){
            ArrayList<Interval> result = new ArrayList<Interval>();
            result.add(newInterval);
            return result;
        }
        int startIndex=0;
        int endIndex=intervals.size();
        int index=0;
        int findIndex=0;
        if(intervals.get(0).start > newInterval.start) intervals.get(0).start=newInterval.start;
        for(Interval item : intervals){
            if(newInterval.start <= item.end && newInterval.start>=item.start){
                startIndex=index;
                findIndex++;
            }else {
                if(index+1<intervals.size()){
                    if(item.end<newInterval.start && intervals.get(index+1).start>newInterval.end){
                        intervals.add(index+1,newInterval);
                        return intervals;
                    }
                    if(item.end<newInterval.start && intervals.get(index+1).start>newInterval.start){
                        startIndex=index+1;
                        intervals.get(index+1).start=newInterval.start;
                    }
                }
            }
            if (newInterval.end >= item.start && newInterval.end <= item.end) {
                endIndex=index;
                findIndex++;
            }else {
                if(index+1<intervals.size()){
                    if(item.end<newInterval.end && intervals.get(index+1).start>newInterval.end){
                        endIndex=index;
                        intervals.get(startIndex).end=newInterval.end;
                        if (endIndex >= startIndex + 1 && endIndex<intervals.size()) {
                            intervals.subList(startIndex + 1, endIndex + 1).clear();
                        }
                        return intervals;
                    }
                }
            }

            if(findIndex==2) break;
            index++;
        }
        if(startIndex!=0 || endIndex!=intervals.size()){
            if(startIndex==0 && endIndex!=0){
                intervals.get(startIndex).end=intervals.get(endIndex).end;
                if(newInterval.start<intervals.get(startIndex).start) intervals.get(startIndex).start=newInterval.start;
            }
            else if(endIndex==intervals.size()){
                intervals.get(startIndex).end=newInterval.end;
                endIndex=intervals.size()-1;
            }
            else if(startIndex==0){
                intervals.get(startIndex).start=newInterval.start;
            }
            else{
                intervals.get(startIndex).end=intervals.get(endIndex).end;
            }
        }
        else{
            intervals.add(newInterval);
            endIndex++;
        }
      if (endIndex >= startIndex + 1 && endIndex<intervals.size()) {
          intervals.subList(startIndex + 1, endIndex + 1).clear();
      }
        return intervals;
    }
    public static void main(String[] arr){
        ArrayList<Interval> intervalItems = new ArrayList<Interval>();
        intervalItems.add(new Interval(1,2));
        intervalItems.add(new Interval(8,10));
        intervalItems = insert(intervalItems,new Interval(3,6));
        for(Interval item : intervalItems) System.out.println("[ "+item.start+" , "+item.end+" ]");
    }

}
