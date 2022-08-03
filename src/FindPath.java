import java.sql.SQLOutput;
import java.util.*;

public class FindPath {
    int[][] field;
    int row;
    int column;
//    String longestPath;

    public FindPath(int[][] field) {
        this.field = field;
        this.row = field.length;
        this.column = field[0].length;
//        this.longestPath = "";
    }

    public Pair searchPath(int[][] matrix, int x, int y, String path, ArrayList finaList, int[][] visited) {
        int currentPosition = matrix[x][y];

//        System.out.println(currentPosition);

        //Search Left
        if (y - 1 >= 0 && currentPosition < matrix[x][y - 1]) {
            String newPath = path + "-" + String.valueOf(matrix[x][y - 1]);
//            System.out.println("Current Path: " + newPath);
            visited[x][y] = 1;
            searchPath(matrix, x, y - 1, newPath, finaList, visited);
        }

        //Search Right
        if (y + 1 < column && currentPosition < matrix[x][y + 1]) {
            String newPath = path + "-" + String.valueOf(matrix[x][y + 1]);
//            System.out.println("Current Path: " + newPath);
            visited[x][y] = 1;
            searchPath(matrix, x, y + 1, newPath, finaList, visited);
        }

        //Search Up
        if (x - 1 >= 0 && currentPosition < matrix[x - 1][y]) {
            String newPath = path + "-" + String.valueOf(matrix[x - 1][y]);
            visited[x][y] = 1;
            searchPath(matrix, x - 1, y, newPath, finaList, visited);
        }

        if (visited[x][y] == 0) {
//            System.out.println("Final path: " + path);
            finaList.add(path);
        }


        Pair myPair = new Pair(visited, finaList);

        return myPair;
    }

    public ArrayList<String> allField() {
        int[][] visited = createVisited();
        ArrayList<String> finalList = new ArrayList<String>();
        Pair myPair = new Pair(visited, finalList);

//        System.out.println("AllField");
//        System.out.println("Visited: ");
//        System.out.println(Arrays.deepToString(visited));
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (field[i][j] > 0 && visited[i][j] == 0) {
//                    System.out.println("ReadyToSearch");
                    myPair = searchPath(field, i, j, String.valueOf(field[i][j]), myPair.getFinalList(), myPair.getVisited());
                }
            }
        }

        String longestPath = findLPath(myPair.getFinalList());

        System.out.println("Steepest path length:" + longestPath);

//        prettyPrint(myPair.getFinalList());


        return myPair.getFinalList();

    }


    private String findLongest(String myPath, String newPath){
//        System.out.println("Compare two: " + myPath + " " +  newPath);
        if(newPath.length() > myPath.length()){
            return newPath;

        }else if(myPath.length() == newPath.length()){
            int difMyPath = Integer.parseInt(myPath.substring(myPath.length()-1));
            int difNewPath = Integer.parseInt(newPath.substring(newPath.length()-1));
            if(difNewPath > difMyPath){ return newPath; }
        }

        return myPath;

    }

    private String findLPath(ArrayList<String> myList){
        String longPath = "";
        for(int i = 0; i < myList.size(); i++){
            longPath = findLongest(longPath, myList.get(i));
        }
        return longPath;
    }

    private void prettyPrint(ArrayList<String> myList){
        System.out.println("List of paths: ");
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }
    }


    private int[][] createVisited() {
        int[][] visted = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visted[i][j] = 0;
            }
        }
        return visted;

    }


}