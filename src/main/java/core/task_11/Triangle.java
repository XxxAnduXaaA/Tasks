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

        return floorNumber * floorNumber * floorNumber;
    }
}
