import java.io.*;
import java.util.*;

public class ReadFile {
    private Scanner x;
    private String file;

    public void openFile(){
        file = "miniMap.txt";
        try{
            x = new Scanner(new File("textFiles/miniMap.txt"));
        }catch(Exception e){
            System.out.println("No file :(");
        }
    }

    public int[][] readFile(){
        int a = Integer.parseInt(x.next());
        int b = Integer.parseInt(x.next());

        int[][] field = new int [a][b];

        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                field[i][j] = Integer.parseInt(x.next());
            }
        }

//        System.out.println(Arrays.deepToString(field));
        return field;
    }

    public void closeFile(){
        x.close();
    }





    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }





}

