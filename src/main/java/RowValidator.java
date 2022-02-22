import java.util.Arrays;

public class RowValidator extends Worker {

    public int[] arrayToValidate;

    protected RowValidator(int row, int col) {
        super(row, col);
    }

    @Override
    public void doWork() {
        if (column != 0 || row > 8) {
            System.out.println("Invalid row or column for row subsection");
            return;
        }

        int i;
        int j;
        arrayToValidate = new int[9];


        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                arrayToValidate[j] = SudokuValidator.sudoku[i][j];
                validateArray(arrayToValidate);
            }
            System.out.println("Array to validate: " + Arrays.toString(arrayToValidate) + " Validity array: " + Arrays.toString(valid));
            }
        }


    private void validateArray(int[] array) {
        int i;
        valid = new int[9];

        for (i = 1; i < 10; i++) {
            if (arrayContainsNumber(array, i)) {
                valid[i - 1] = 1;
            } else {
                valid[i - 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        RowValidator validator = new RowValidator(0, 0);
        validator.doWork();
    }
}
