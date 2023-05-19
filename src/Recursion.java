public class Recursion {

    public static void main(String[] args) {
        countdown(10);
        System.out.println(factorial(15));
        infinityRecursion(15);
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

}
