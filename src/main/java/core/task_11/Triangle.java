package core.task_11;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер этажа треугольника: ");
        int floorNumber = scanner.nextInt();

        int sum = calculateOddTriangleSum(floorNumber);
        System.out.println("Сумма на " + floorNumber + " этаже треугольника: " + sum);
    }

    public static int calculateOddTriangleSum(int floorNumber) {
        int rowNumber = 1;
        int oddNumber = 1;
        int lastSum = 0;
        int lastRowNumber = 1;
        int sum = 0;

        while (rowNumber <= floorNumber) {
            for (int i = 1; i <= rowNumber; i++) {
                if(lastRowNumber < rowNumber){
                    sum -= lastSum;
                }
                sum += oddNumber;
                oddNumber += 2;
                lastRowNumber = rowNumber;
                lastSum = sum;

            }
            rowNumber++;
        }

        return sum;
    }
}
