import java.lang.reflect.Array;
import java.util.*;

public class IfPersonCanAttendAllMetting {

    public static void main(String[] args) {
        Interval o1 = new Interval(0, 3);
        Interval o2 = new Interval(5, 16);
        Interval o3 = new Interval(15, 20);
        Interval[] intervals = {o1, o2, o3};
        System.out.println( canAttendMeetings(intervals));
        System.out.println( checkHowManyRoomRequired(intervals));
        System.out.println( minMeetingRooms(intervals));
           mergeTimeInterval(Arrays.asList(intervals)).
                 forEach(interval -> System.out.println( interval.start +" "+ interval.end));
    }

    public static  boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }

   public static int checkHowManyRoomRequired(Interval[] intervals){
        if(intervals.length ==0){
            return 0;
        }
        int rooms =1;
       Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval o1, Interval o2) {
              return o1.start - o2.start;
           }
       });
       for (int i = 0; i < intervals.length - 1; i++) {
           if (intervals[i].end > intervals[i + 1].start) {
               rooms++;
           }
       }

    return rooms;
   }

    public static int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> end = new PriorityQueue<Integer>();
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        end.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i].start >= end.peek()) {
                end.poll();
            }
            end.add(intervals[i].end);
        }
        return end.size();
    }



    public static List<Interval> mergeTimeInterval(List<Interval> intervals) {
        if(intervals == null || intervals.size()<=1){
            return intervals;
        }

        intervals.sort(Comparator.comparing((Interval itl) -> itl.start));

        List<Interval> result = new ArrayList<>();
        Interval t = intervals.get(0);

        for(int i=1; i<intervals.size(); i++){
            Interval c = intervals.get(i);
            if(c.start <= t.end){
                t.end = Math.max(t.end, c.end);
            }else{
                result.add(t);
                t = c;
            }
        }

        result.add(t);

        return result;
    }
}
