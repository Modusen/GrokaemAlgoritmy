package QuickSortApp_Chapter4;

public class MyArray {
    private final int[] myArray;
    private int elementIndex;

    public MyArray(int max) {
        myArray = new int[max];
        elementIndex = 0;
    }

    public void insert(int value) {
        myArray[elementIndex] = value;
        elementIndex++;
    }

    public void printArray() {
        System.out.println("Array: ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println("");
    }

    public void quickSort() {
        recursiveQuickSort(0, elementIndex-1);
    }

    private void recursiveQuickSort(int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) {
            return;
        }
        int pivot = myArray[rightIndex];

        int partitionIndex = getPartitionIndexAndSplitArrays(leftIndex, rightIndex, pivot);
        recursiveQuickSort(leftIndex, partitionIndex - 1);
        recursiveQuickSort(rightIndex, partitionIndex + 1);
    }

    private int getPartitionIndexAndSplitArrays(int leftIndex, int rightIndex, int pivot) {
        int leftPart = leftIndex - 1;
        int rightPart = rightIndex;
        while (true) {
            while (myArray[++leftPart] < pivot) {
            }
            while (rightPart>0 && myArray[--rightPart] > pivot) {
            }

            if (leftPart >= rightPart) {
                break;
            } else {
                swap(leftPart, rightPart);
            }
        }
        swap(leftPart, rightIndex);
        return leftPart;

    }

    public void swap(int index1, int index2) {
        int tmp = myArray[index1];
        myArray[index1] = myArray[index2];
        myArray[index2] = tmp;
    }
}
