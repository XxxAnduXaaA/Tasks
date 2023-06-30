package core.task_4;

public class Crossing {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 2, 0};
        int b[] = {5, 1, 2, 7, 3, 2};
        int c[] = new int[4];

        int k = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    c[k] = a[i];
                    k++;
                    break;
                }
            }
        }

        for (int n : c) {
            System.out.println(n);
        }

    }
}
