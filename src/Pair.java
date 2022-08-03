import java.util.ArrayList;

public class Pair {
    int[][] visited;
    ArrayList<String> finalList;

    public Pair(int[][] visited, ArrayList<String> finaList){
        this.visited = visited;
        this.finalList = finaList;
    }

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
