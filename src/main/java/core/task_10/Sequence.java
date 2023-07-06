package core.task_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {
    public static List<String> getNumberRanges(int[] arr) {
        List<String> ranges = new ArrayList<>();

        if (arr.length == 0) {
            return ranges;
        }

        Arrays.sort(arr);

        int start = arr[0], end = arr[0];

        for (int num : arr) {
            if (num == end + 1 || num == end) {
                end = num;
            } else {
                ranges.add(getRangeString(start, end));
                start = num;
                end = num;
            }
        }

        ranges.add(getRangeString(start, end));

        return ranges;
    }

    private static String getRangeString(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        } else {
            return start + "-" + end;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 8, 4, 9};

        List<String> ranges = getNumberRanges(arr);

        for (String range : ranges) {
            System.out.print(range + " ");
        }
        System.out.println();
    }
}
