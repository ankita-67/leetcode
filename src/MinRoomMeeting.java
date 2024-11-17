import java.util.Arrays;
import java.util.*;

public class MinRoomMeeting {
    public static int minMeetingRooms(int[][] meetings) {
    if (meetings.length == 0) {
        return 0;
    }

    // Sort meetings in ascending order by start time
    Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

    // Initialize heap and add the end time of the first meeting
    Queue<Integer> rooms = new LinkedList<>();
    rooms.add(meetings[0][1]);

System.out.println("first element"+rooms);
    for (int i = 1; i < meetings.length; i++) {
        int start = meetings[i][0];
        int end = meetings[i][1];
        System.out.print("i:  "+i);
        System.out.print(" start "+start);
        System.out.print(" end "+end);
        // If the earliest ending meeting ends before the next meeting starts,
        // remove it from the heap
        if (rooms.peek() <= start) {
            System.out.print(" rooms.peek() "+rooms.peek());
            rooms.poll();
        }

        // Add the current meeting's end time to the heap

        rooms.add(end);
        System.out.println();
    }

    // The size of the heap at the end is the minimum rooms required
    return rooms.size();
}

    public static void main(String[] args) {
int[][] meet = {{6,8},{4,6},{3,5},{8,9}};

        System.out.print(minMeetingRooms(meet));
    }
}
