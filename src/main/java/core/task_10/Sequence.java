package core.task_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sequence {

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<String> getNumberRanges(int[] arr) {
        List<String> ranges = new ArrayList<>();

        if (arr.length == 0) {
            return ranges;
        }

        int start = arr[0];
        int end = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == end + 1) {

                end = arr[i];
            } else {

                ranges.add(getRangeString(start, end));
                start = arr[i];
                end = start;
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
        quicksort(arr, 0, arr.length - 1);

        List<String> ranges = getNumberRanges(arr);

        for (String range : ranges) {
            System.out.print(range + " ");
        }
        System.out.println();
    }
}
