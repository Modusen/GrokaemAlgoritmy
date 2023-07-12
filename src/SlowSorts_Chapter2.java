import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SlowSorts_Chapter2 {
    public static void main(String[] args) {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        shuffleArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println("\n-------------------------------------------------AFTER SORTING-----------------------------------------\n");
//        selectionSort(array);
//        bubbleSort(array);
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shuffleArray(int[] targetArray) {
        Random random = ThreadLocalRandom.current();
        for (int i = targetArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            int a = targetArray[index];
            targetArray[index] = targetArray[i];
            targetArray[i] = a;
        }
    }

    public static void bubbleSort(int[] array) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int leftPositionIndex = 0; leftPositionIndex < array.length; leftPositionIndex++) {
            int minValueIndex = leftPositionIndex;
            for (int i = leftPositionIndex + 1; i < array.length; i++) {
                if (array[i] < array[minValueIndex]) {
                    minValueIndex = i;
                }
            }
            swap(array, leftPositionIndex, minValueIndex);
        }
    }

    public static void insertionSort(int[] array) {
        int k = 1;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && current < array[j - 1] ) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;
        }
    }


    public static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}

