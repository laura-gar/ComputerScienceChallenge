import java.io.*;
import java.util.*;

/**
 * ReadFile open, read and close a file
 * @author Laura Garcia
 */
public class ReadFile {
    private Scanner x;
    private String file;

    /**
     * Class constructor
     * @param file name
     */
    public ReadFile(String file){
        this.file = file;
    }

    /**
     * Open, read and close a file
     * @return, matrix with the file read
     */
    public int[][] prepareFile(){
        int [][] map;
        openFile(this.file);
        map =  readFile();
        closeFile();
        return map;
    }

    /**
     * Open a file
     * @param file name
     */
    private void openFile(String file){
        try{
            x = new Scanner(new File(file));
        }catch(Exception e){
            System.out.println("No file :(");
        }
    }

    /**
     * Save the file data in a matrix
     * @return matrix with file data
     */
    private int[][] readFile(){
        //Field size
        int a = Integer.parseInt(x.next());
        int b = Integer.parseInt(x.next());

        //Create field
        int[][] field = new int [a][b];

        //Save the data in the field "matrix"
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                field[i][j] = Integer.parseInt(x.next());
            }
        }

        return field;
    }

    private void closeFile(){
        x.close();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

