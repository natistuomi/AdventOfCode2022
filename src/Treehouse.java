import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Treehouse {
    private Scanner tgb;
    private final String filename;
    private String currentLine;
    private int[][] grid;
    private int lineNr = 0;
    private double visibleTrees = 0;

    public Treehouse(String filename) {
        this.filename = filename;
        initializeScanner();
        calculateTreehouse();
    }

    public void calculateTreehouse(){
        getNextLine();
        grid = new int[currentLine.length()][currentLine.length()];
        lineNr = 0;
        setGrid();
        while(tgb.hasNextLine()){
            getNextLine();
            setGrid();
        }
        for(int i = 0; i <= lineNr; i++){
            checkIfVisible(i);
        }
    }

    public void checkIfVisible(int n){
        for(int i = 0; i < currentLine.length(); i++){
            if(n == 0 || n == lineNr){visibleTrees += 1;}
            else if(i == 0 || i == currentLine.length()-1){visibleTrees += 1;}
            else{
                if(stillVisible(n,i)){visibleTrees += 1;}
            }
        }
    }

    public boolean stillVisible(int n, int x){
        int[] control = {0,0,0,0};
        int height = grid[n][x];
        for(int i  = 0; i < x; i++){
            if(grid[n][i] >= height){
                control[0] = 1;
            }
        }
        for(int i = currentLine.length()-1; i > x; i--){
            if(grid[n][i] >= height){
                control[1] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(grid[i][x] == height){
                control[2] = 1;
            }
        }
        for(int i = lineNr; i > n; i--){
            if(grid[i][x] == height){
                control[3] = 1;
            }
        }
        if(control[0]+control[1]+control[2]+control[3] == 4){return false;}
        return true;
    }

    public void setGrid(){
        for(int i = 0; i < currentLine.length(); i++){
            grid[lineNr][i] = Integer.parseInt( "" + currentLine.charAt(i) );
        }
    }

    public void getNextLine(){
        currentLine = tgb.nextLine();
        lineNr += 1;
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getVisibleTrees() {
        return visibleTrees;
    }
}
