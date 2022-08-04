import java.util.*;

/**
 * Search all possible paths within a field and find the longest and steepest one.
 * @author Laura Garcia
 */
public class FindPath {
    private int row;
    private int column;
    private Pair myPair;
    private int[][] field;

    /**
     * Class constructor
     * @param field, matrix to be searched
     */
    public FindPath(int[][] field) {
        this.field = field;
        this.row = field.length;
        this.column = field[0].length;
    }

    /**
     * Find all paths in a field
     * @return list of found paths
     */
    public void allField() {
        //Generate necessary objects
        int[][] visited = createVisited();
        ArrayList<String> finalList = new ArrayList<String>();
        myPair = new Pair(visited, finalList);
        String longestPath = "";

        //Check the whole field
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (field[i][j] > 0 && visited[i][j] == 0) {
                    myPair = searchPath(field, i, j, String.valueOf(field[i][j]), myPair.getFinalList(), myPair.getVisited());
                }
            }
        }

        //Find the longest path
        longestPath = findLPath(myPair.getFinalList());
        System.out.println("Steepest path length:" + longestPath);

        //Print all paths
        prettyPrint(myPair.getFinalList());
        System.out.println("Total paths: " + myPair.getFinalList().size() );
    }

    /**
     * Finds all routes from an initial position
     * @param matrix, field to search for possible paths
     * @param x, vertical position in the field
     * @param y, horizontal position in the field
     * @param path, path that is being built
     * @param finalList, list of the paths found
     * @param visited, matrix with cells that have already been visited
     * @return Object Pair with finalList and visited
     */
    private Pair searchPath(int[][] matrix, int x, int y, String path, ArrayList finalList, int[][] visited) {
        int currentPosition = matrix[x][y];

        //Search Left
        if (y - 1 >= 0 && currentPosition < matrix[x][y - 1]) {
            String newPath = path + "-" + String.valueOf(matrix[x][y - 1]);
            visited[x][y] = 1;
            searchPath(matrix, x, y - 1, newPath, finalList, visited);
        }

        //Search Right
        if (y + 1 < column && currentPosition < matrix[x][y + 1]) {
            String newPath = path + "-" + String.valueOf(matrix[x][y + 1]);
            visited[x][y] = 1;
            searchPath(matrix, x, y + 1, newPath, finalList, visited);
        }

        //Search Up
        if (x - 1 >= 0 && currentPosition < matrix[x - 1][y]) {
            String newPath = path + "-" + String.valueOf(matrix[x - 1][y]);
            visited[x][y] = 1;
            searchPath(matrix, x - 1, y, newPath, finalList, visited);
        }

        //Add to finalList if is not a sub path
        if (visited[x][y] == 0) {
            finalList.add(path);
        }

        //Add to return pair Paths list and visited matrix
        myPair.setFinalList(finalList);
        myPair.setVisited(visited);

        return myPair;
    }

    /**
     * Find the longer path between two options
     * @param myPath, path to compare
     * @param newPath,path to compare
     * @return Longer path
     */
    private String findLongest(String myPath, String newPath){
        if(newPath.length() > myPath.length()){
            return newPath;
        }else if(myPath.length() == newPath.length() &&  newPath.length() > 0 && myPath.length() > 0){
            int difMyPath = Integer.parseInt(myPath.substring(myPath.length()-1));
            int difNewPath = Integer.parseInt(newPath.substring(newPath.length()-1));
            if(difNewPath > difMyPath){ return newPath; }
        }
        return myPath;
    }

    /**
     * Find the longest path among all options
     * @param myList, list of found paths
     * @return Longest path
     */
    private String findLPath(ArrayList<String> myList){
        String longPath = "";
        for(int i = 0; i < myList.size(); i++){
            longPath = findLongest(longPath, myList.get(i));
        }
        return longPath;
    }

    /**
     * Print list of paths
     * @param myList, list of found paths
     */
    private void prettyPrint(ArrayList<String> myList){
        System.out.println("List of paths: ");
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }
    }

    /**
     * Create matrix to save the visited cells
     * @return matrix filled with zeros
     */
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