package interviewProblems.My_Calendar_II;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> bookings = new ArrayList<>();
    private List<int[]> overlaps = new ArrayList<>();

    public MyCalendarTwo() {}

    public boolean book(int start, int end) {
        // Check if overlap with any other overlapping section
        for (int[] overlap : this.overlaps) {
            if (start < overlap[1] && overlap[0] < end) return false;
        }
        // Add any overlaps
        for (int[] book : this.bookings) {
            if (start < book[1] && book[0] < end) {
                this.overlaps.add(new int[]{Math.max(start, book[0]), Math.min(end, book[1])});
            }
        }
        // Add to the bookings
        this.bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */