import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionSort_Chapter2 {
    public static void main(String[] args) {
        int[] array = new int[512];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        shuffleArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println("\n-------------------------------------------------AFTER SORTING-----------------------------------------\n");
        selectionSort(array);
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

    public static void selectionSort(int[] arrayToSort) {
        for (int leftPositionIndex = 0; leftPositionIndex < arrayToSort.length; leftPositionIndex++) {
            int minValueIndex = leftPositionIndex;
            for (int i = leftPositionIndex + 1; i < arrayToSort.length; i++) {
                if (arrayToSort[i] < arrayToSort[minValueIndex]) {
                    minValueIndex = i;
                }
            }
            swap(arrayToSort, leftPositionIndex, minValueIndex);
        }
    }

    public static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}

