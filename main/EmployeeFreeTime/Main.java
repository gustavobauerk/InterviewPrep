package EmployeeFreeTime;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
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
}

class Solution {
    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // TODO: Write your code here
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Interval>> schedule = new ArrayList<>();
        System.out.println(solution.findEmployeeFreeTime(schedule));
    }
}
