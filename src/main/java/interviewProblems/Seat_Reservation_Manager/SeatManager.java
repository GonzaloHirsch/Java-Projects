package interviewProblems.Seat_Reservation_Manager;

import java.util.PriorityQueue;
import java.util.Queue;

class SeatManager {
    private Queue<Integer> freeSeats = new PriorityQueue<>();
    private int maxReserved;

    // No need to store n, given the conditions
    public SeatManager(int n) {}

    public int reserve() {
        // Take the first of the unreserved seats or the current max
        return this.freeSeats.isEmpty() ? ++this.maxReserved : this.freeSeats.poll();
    }

    // Only needs to add the number to the pq
    public void unreserve(int seatNumber) {
        this.freeSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */