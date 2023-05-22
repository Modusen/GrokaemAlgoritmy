import java.util.Arrays;

public class BinarySearch_Chapter1 {
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int iterationStep = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("mid = " + mid);
            int guess = array[mid];
            System.out.println("guess = " + guess);
            if (guess == target) {
                System.out.println(guess);
                System.out.println("steps: " + iterationStep);
                return guess;
            } else if (guess > target) {
                high = mid - 1;
                iterationStep++;
                System.out.println("Step " +iterationStep + " low = " + low + " decrease high = " + high);
            } else if (guess < target) {
                low = mid + 1;
                iterationStep++;
                System.out.println("Step " + iterationStep + " low = " + low + " increase high = " + high);
            }
        }
        System.out.println("There is no such element");
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[512];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        binarySearch(array, 1);
    }
}
