import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");

        //Read .txt
        ReadFile r = new ReadFile("textFiles/miniMap2.txt");
        int[][] field  = r.prepareFile();

        //Find all paths
        FindPath findPath = new FindPath(field);
        findPath.allField();

    }

//    private static int[][] readField(){
//        ReadFile r = new ReadFile();
//        r.openFile();
//        int [][] field = r.readFile();
//        r.closeFile();
//
////        System.out.println("Map: ");
////        System.out.println(Arrays.deepToString(field));
//
//        return field;
//    }


}