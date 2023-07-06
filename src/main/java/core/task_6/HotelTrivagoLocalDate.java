package core.task_6;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class HotelTrivagoLocalDate {
    private static class Event {
        private LocalDate date;
        private int change;

        public Event(LocalDate date, int change) {
            this.date = date;
            this.change = change;
        }

        public LocalDate getDate() {
            return date;
        }

        public int getChange() {
            return change;
        }
    }

    public static int maximumGuests(LocalDate[][] bookingDates) {
        int numOfBookings = bookingDates.length;

        Event[] events = new Event[numOfBookings * 2];

        for (int i = 0; i < numOfBookings; i++) {
            events[i * 2] = new Event(bookingDates[i][0], 1);
            events[i * 2 + 1] = new Event(bookingDates[i][1], -1);
        }

        Arrays.sort(events, Comparator.comparing(Event::getDate).thenComparing(Event::getChange));

        int currentGuests = 0;
        int maxGuests = 0;

        for (Event event : events) {
            currentGuests += event.getChange();
            if (currentGuests > maxGuests) {
                maxGuests = currentGuests;
            }
        }

        return maxGuests;
    }

    public static void main(String[] args) {
        LocalDate[][] bookingDates = {
                {LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2)},
                {LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 3)},
                {LocalDate.of(2023, 1, 2), LocalDate.of(2023, 1, 4)},
                {LocalDate.of(2023, 1, 2), LocalDate.of(2023, 1, 3)}
        };

        int maxGuests = maximumGuests(bookingDates);
        System.out.println(maxGuests);
    }
}
