import java.util.ArrayList;

/**
 * Pair object to return two values
 * @author  Laura Garcia
 */
public class Pair {
    private int[][] visited;
    private ArrayList<String> finalList;

    /**
     * Class constructor
     * @param visited, matrix with cells that have already been visited
     * @param finaList, list of the paths found
     */
    public Pair(int[][] visited, ArrayList<String> finaList){
        this.visited = visited;
        this.finalList = finaList;
    }

    //Getters and Setters
    public int[][] getVisited() {
        return visited;
    }

    public void setVisited(int[][] visited) {
        this.visited = visited;
    }

    public ArrayList<String> getFinalList() {
        return finalList;
    }

    public void setFinalList(ArrayList<String> finalList) {
        this.finalList = finalList;
    }

}
