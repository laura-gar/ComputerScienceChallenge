import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        int[][] field;
        ArrayList<String> result;

        field = readField();

        FindPath findPath = new FindPath(field);
        result = findPath.allField();


        System.out.println(result);
    }

    private static int[][] readField(){
        ReadFile r = new ReadFile();
        r.openFile();
        int [][] field = r.readFile();
        r.closeFile();

        System.out.println("Map: ");
        System.out.println(Arrays.deepToString(field));

        return field;
    }


}