package core.task_4;

import java.util.*;

public class crossing {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 2, 0};
        int[] array2 = {5, 1, 2, 7, 3, 2};

        int[] intersection = findIntersection(array1, array2);

        System.out.print("Intersection: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }

    private static int[] findIntersection(int[] array1, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intersectList = new ArrayList<>();

        // Создаем отображение элементов первого массива и их количества
        for (int num : array1) {
            map.merge(num, 1, Integer::sum);
        }

        // Проверяем каждый элемент второго массива
        // Если элемент есть в отображении, добавляем его в список пересечения и уменьшаем количество в отображении
        for (int num : array2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersectList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Преобразуем список пересечения в массив
        int[] intersection = new int[intersectList.size()];
        for (int i = 0; i < intersectList.size(); i++) {
            intersection[i] = intersectList.get(i);
        }

        return intersection;
    }

}
