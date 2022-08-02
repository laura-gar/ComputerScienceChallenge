public class Main {
    public static void main(String[] args) {
        int[][] field;
        System.out.println("Hello world!");
        ReadFile r = new ReadFile();
        r.openFile();
        field = r.readFile();
        r.closeFile();
    }
}