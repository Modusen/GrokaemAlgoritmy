package QuickSortApp_Chapter4;

import java.util.Arrays;
import java.util.Random;

public class QuickSortApp {
    public static void main(String[] args) {
        int size = 400000000;
        MyArray array = new MyArray(size);

        int[] check = new int[400000000];

        for (int i = 0; i < size; i++) {
            int value = new Random().nextInt();
            check[i] = value;
            array.insert(value);
        }
        long start1 = System.currentTimeMillis();
//        array.printArray();
        array.quickSort();
//        array.printArray();
        long finish1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(check));
        Arrays.sort(check);
//        System.out.println(Arrays.toString(check));
        long finish2 = System.currentTimeMillis();

        System.out.println("Моя сортировка заняла: " + (finish1-start1));
        System.out.println("Вшитая сортировка в Java заняла: " + (finish2-start2));
    }
}
