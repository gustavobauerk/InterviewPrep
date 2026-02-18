package EmployeeFreeTime;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

class EmployeeInterval {
    Interval interval; // interval representing employee's working hours
    int employeeIndex; // index of the list containing working hours of this employee
    int intervalIndex; // index of the interval in the employee list

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }

    @Override
    public String toString() {
        return "EmployeeInterval{" +
                "interval=" + interval +
                ", employeeIndex=" + employeeIndex +
                ", intervalIndex=" + intervalIndex +
                '}';
    }
}

class Solution {
    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> queue = new PriorityQueue<>(Comparator.comparing(e -> e.interval.start));
        for (int i = 0; i < schedule.size(); i++) {
            EmployeeInterval employeeInterval = new EmployeeInterval(schedule.get(i).get(0), i, 0);
            queue.add(employeeInterval);
        }
        while (!queue.isEmpty()) {
            EmployeeInterval employeeInterval = queue.poll();
            System.out.println(employeeInterval);
            if (!queue.isEmpty()) {
                EmployeeInterval nextEmployeeInterval = queue.peek();
                if (nextEmployeeInterval.interval.start > employeeInterval.interval.end) {
                    result.add(new Interval(employeeInterval.interval.end, nextEmployeeInterval.interval.start));
                }
                List<Interval> intervals = schedule.get(employeeInterval.employeeIndex);
                if (intervals.size() > employeeInterval.intervalIndex + 1) {
                    EmployeeInterval newInterval = new EmployeeInterval(intervals.get(employeeInterval.intervalIndex + 1), employeeInterval.employeeIndex, employeeInterval.intervalIndex+1);
                    queue.add(newInterval);
                }
            }
        }
        // TODO: Write your code here
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(6, 8)));
        schedule.add(Arrays.asList(new Interval(2, 4)));
        schedule.add(Arrays.asList(new Interval(1, 3), new Interval(9, 12)));
        System.out.println(solution.findEmployeeFreeTime(schedule));
    }
}
