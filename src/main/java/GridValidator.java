import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GridValidator {

    /*
    * Checks the inputed matrix for duplicates in each 3x3 matrix
    */
    public static void  run(int[][] matrix) throws FileNotFoundException {

        for (int i = 0; i < 9; i++) {
            System.out.println(smallSquareValidator(splitBigMatrix(matrix).get(i)));
        }
    }

    public static String smallSquareValidator(int[][] matrix){
        ArrayList<String> existing = new ArrayList<>();
        String dupe = "Correct!";

        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                if (existing.contains(matrix[i][j] + " ")){
                    int duplicate = matrix[i][j];
                    int column = i + 1;
                    int row = j + 1;
                    dupe = "Duplicate number " + duplicate + " found at row " + row + " column " + column;
                } else {
                    existing.add(matrix[i][j] + " ");
                }
            }
        }
        return dupe;
    }

    public static ArrayList<int[][]> splitBigMatrix(int[][] matrix){
        ArrayList<int[][]> allMatrixes = new ArrayList<>();
        int[][] matrix0 = new int[3][3];
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        int[][] matrix3 = new int[3][3];
        int[][] matrix4 = new int[3][3];
        int[][] matrix5 = new int[3][3];
        int[][] matrix6 = new int[3][3];
        int[][] matrix7 = new int[3][3];
        int[][] matrix8 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix0[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = matrix[i][j+3];
            }
        }

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = matrix[i][j+6];
            }
        }


        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                matrix3[i][j] = matrix[i+3][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix4[i][j] = matrix[i+3][j+3];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix5[i][j] = matrix[i+3][j+6];
            }
        }

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                matrix6[i][j] = matrix[i+6][j];
            }
        }


        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                matrix7[i][j] = matrix[i+6][j+3];
            }
        }


        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                matrix8[i][j] = matrix[i+6][j+6];
            }
        }

        allMatrixes.add(matrix0);
        allMatrixes.add(matrix1);
        allMatrixes.add(matrix2);
        allMatrixes.add(matrix3);
        allMatrixes.add(matrix4);
        allMatrixes.add(matrix5);
        allMatrixes.add(matrix6);
        allMatrixes.add(matrix7);
        allMatrixes.add(matrix8);
        return allMatrixes;
    }
}
