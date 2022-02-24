import java.util.Arrays;

public class RowValidator extends Worker {

    private int[] arrayToValidate;

    protected RowValidator(int row, int col) {
        super(row, col);
    }

    @Override
    public void doWork() {
        if (column != 0 || row > 8) {
            System.out.println("Invalid row or column for row subsection");
            return;
        }

        arrayToValidate = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arrayToValidate[j] = SudokuValidator.sudoku[i][j];
            }
            int[] validityArray = createValidityArray(arrayToValidate);
            if (arrayContainsNumber(validityArray, 0)) {
                i++; //so that row starts with 1 in the print message
                System.out.println("Row " + i + ": Duplicate number found at idnexes: " + Arrays.toString(findIndices(validityArray,0)));
            }
        }
    }

    public static void main(String[] args) {
        RowValidator validator = new RowValidator(0, 0);
        validator.doWork();
    }
}
