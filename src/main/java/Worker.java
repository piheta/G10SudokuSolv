import java.util.Arrays;
import java.util.HashSet;

public abstract class Worker implements Runnable {

    public int row;
    public int column;
    public int[] valid;
    public SudokuValidator sudokuValidator = new SudokuValidator();

    protected Worker(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void run() {
        doWork();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private int[] increaseArraySize(int[] array) {
        return Arrays.copyOf(array, array.length + 1);
    }

    protected int[] findIndices(int[] array, int number) {
        // if number is in the array:
        // walk through array, and look for number index
        // add all the indices to an array
        // else, return empty array
        int[] indices = new int[0];
        int indicesIndex = 0;
        if (arrayContainsNumber(array, number)) {

            //walk through array 1 for 1
            //if current number == number
            //increase size of indices
            //get index from array and put in indicesArray

            for (int i = 0; i < array.length; i++) {
                if (array[i] == number) {
                    indices = increaseArraySize(indices);
                    indices[indicesIndex] = i;
                    indicesIndex++;
                }
            }
        }
        return indices;
    }

    protected boolean arrayContainsNumber(int[] array, int number) {
        boolean containsNumber = false;
        for (int currentNumber : array) {
            if (currentNumber == number) {
                containsNumber = true;
            }
        }
        return containsNumber;
    }

    protected int[] createValidityArray(int[] array) {
        int[] validityArray = new int[9];
        for (int i = 1; i < 10; i++) {
            if (arrayContainsNumber(array, i)) {
                int[] indices = findIndices(array, i);
                if (indices.length == 1) {
                    validityArray[indices[0]] = 1;
                } else if (indices.length > 1) {
                    for (int j = 0; j < indices.length; j++) {
                        validityArray[indices[j]] = 0;
                    }
                }
            }
        }
        return validityArray;
    }

    public abstract void doWork();
}
