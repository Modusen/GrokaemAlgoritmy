import quickSortApp_Chapter4.MyArray;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public class Recursion_Chapters3And4 {

    public static void main(String[] args) {
//        countdown(10);
//        System.out.println(factorial(15));
//        infinityRecursion(15);
        int[] myArray = {5, 26, 214, 43, 21};
//        System.out.println(sum(myArray));
//        System.out.println(getMaxValue(myArray));
        System.out.println(myArray.length + " " + Arrays.toString(myArray));
        sort(myArray, 0, myArray.length - 1);
        System.out.println(Arrays.toString(myArray));
    }

    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private static void merge(int[] A, int p, int q, int r) {
        int[] leftArray = new int[q - p + 1];
        int[] rightArray = new int[r - q];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = A[p + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = A[q + i + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = p; i < r + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    A[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    A[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                A[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                A[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    /**
     * Рекурсия с базовым случаем
     */
    public static void countdown(int value) {
        System.out.println(value);
        if (value <= 0) {
            return;
        } else {
            countdown(value - 1);
        }
    }

    /**
     * Вычисление факториала рекурсивным методом
     */
    public static long factorial(int value) {
        if (value <= 1) {
            return 1;
        } else {
            return value * factorial(value - 1);
        }
    }

    /**
     * Бесконечная рекурсия + StackOverflowError
     */
    public static void infinityRecursion(int value) {
        System.out.println(value);
        value--;
        infinityRecursion(value);
    }

    /**
     * Упражнение 4.1
     * Напишите рекурсивную функцию для подсчета суммы всех элементов в списке.
     */
    static int counter1 = 0;

    public static int sum(int[] array) {
        if (counter1 < array.length - 1) {
            counter1++;
            return array[counter1 - 1] + sum(array);
        }
        return array[counter1];
    }

    /**
     * Упражнение 4.3
     * Напишите рекурсивную функцию для нахождения наибольшего числа в списке.
     */
    static int counter3 = 0;
    static int maxValue = 0;

    public static int getMaxValue(int[] array) {
        if (counter3 <= array.length - 1) {
            if (array[counter3] > maxValue) {
                maxValue = array[counter3];
            }
            counter3++;
            return getMaxValue(array);
        }
        return maxValue;
    }
}
