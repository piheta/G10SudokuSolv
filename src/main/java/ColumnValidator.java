import java.util.Arrays;

public class ColumnValidator extends Worker {

    private int[] arrayToValidate;

    public ColumnValidator(int row, int col) {
        super(row, col);
    }

    @Override
    public void doWork() {
        if (row != 0 || column > 8) {
            System.out.println("Invalid row or column for column subsection");
        }

        arrayToValidate = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arrayToValidate[j] = SudokuValidator.sudoku[j][i];
            }
            int[] validityArray = createValidityArray(arrayToValidate);
            if (arrayContainsNumber(validityArray, 0)) {
                i++; //so that row starts with 1 in the print message
                System.out.println("Column " + i + ": Duplicate number found at idnexes: " + Arrays.toString(findIndices(validityArray,0)));
            }
        }
    }
}
