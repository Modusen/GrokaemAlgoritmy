public class Recursion_Chapters3And4 {

    public static void main(String[] args) {
        countdown(10);
        System.out.println(factorial(15));
//        infinityRecursion(15);
        int[] myArray = {5, 26, 214, 43, 21};
        System.out.println(sum(myArray));
        System.out.println(getMaxValue(myArray));
    }

    /**
     * �������� � ������� �������
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
     * ���������� ���������� ����������� �������
     */
    public static long factorial(int value) {
        if (value <= 1) {
            return 1;
        } else {
            return value * factorial(value - 1);
        }
    }

    /**
     * ����������� �������� + StackOverflowError
     */
    public static void infinityRecursion(int value) {
        System.out.println(value);
        value--;
        infinityRecursion(value);
    }

    /**
     * ���������� 4.1
     * �������� ����������� ������� ��� �������� ����� ���� ��������� � ������.
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
     * ���������� 4.3
     * �������� ����������� ������� ��� ���������� ����������� ����� � ������.
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
