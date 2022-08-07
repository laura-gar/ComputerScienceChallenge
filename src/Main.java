

public class Main {
    public static void main(String[] args) {
        //Read .txt
        ReadFile r = new ReadFile("textFiles/map.txt");
        int[][] field  = r.prepareFile();

        //Find all paths
        FindPath findPath = new FindPath(field);
        findPath.allField();
    }
}