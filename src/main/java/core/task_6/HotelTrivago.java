package core.task_6;

import java.util.Arrays;
import java.util.Comparator;

public class HotelTrivago {

   static public int maximumGuests(int booking[][]) {
        int[][] event = new int[booking.length * 2][2];

        for (int i = 0; i < booking.length; i++) {
            event[i * 2] = new int[]{booking[i][0], 1};
            event[i * 2 + 1] = new int[]{booking[i][1], -1};
        }

        Arrays.sort(event, Comparator.comparingInt(a -> a[0]));

        int currentGuests = 0;
        int maxGuests = 0;

        for (int el[] : event) {
            currentGuests += el[1];
            if (currentGuests > maxGuests) {
                maxGuests = currentGuests;
            }
        }

        return maxGuests;

    }

    public static void main(String[] args) {

        int[][] booking = {{1, 2}, {1, 3}, {2, 4}, {2, 3}};

        System.out.println(maximumGuests(booking));
    }
}
