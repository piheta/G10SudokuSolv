import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvImporter {

    private CsvImporter() {

    }

    public static int[][] run() throws FileNotFoundException {
        File file = null;
        Scanner myObj = new Scanner(System.in);

        try {
            System.out.println("Input file path >");
            file = new File(myObj.nextLine()); //Input dir
            System.out.println("Loading file... " + file);  // Output user input

        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }

        return getMatrixFromArray(getArrayFromString(getFileString(file)));
    }

    public static String getFileString(File path) throws FileNotFoundException {
        //No need for a try-cache since it checks for it above
        Scanner myReader = new Scanner(path);
        String data = myReader.nextLine();

        return data;
    }

    public static ArrayList<Integer> getArrayFromString(String data){
        ArrayList<Integer> testArray = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            if (Character.isDigit(data.charAt(i))){
                testArray.add(Integer.parseInt(String.valueOf(data.charAt(i))));
            }
        }

        return testArray;
    }

    public static int[][] getMatrixFromArray(ArrayList<Integer> data){
        int[][] matrix = new int[9][9];

        for (int i = 0; i < 9; i++) {
            matrix[0][i] = data.get(i);
            matrix[1][i] = data.get(9 + i);
            matrix[2][i] = data.get(18 + i);
            matrix[3][i] = data.get(27 + i);
            matrix[4][i] = data.get(36 + i);
            matrix[5][i] = data.get(45 + i);
            matrix[6][i] = data.get(54 + i);
            matrix[7][i] = data.get(63 + i);
            matrix[8][i] = data.get(72 + i);
        }

        return matrix;
    }
}
