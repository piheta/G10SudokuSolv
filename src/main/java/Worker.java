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

    public boolean arrayContainsNumber(int[] array, int number) {
        boolean containsNumber = false;
        for (int currentNumber : array) {
            if (currentNumber == number) {
                containsNumber = true;
            }
        }
        return containsNumber;
    }

    public abstract void doWork();
}
