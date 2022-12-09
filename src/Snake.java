import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Snake {
    private Scanner tgb;
    private final String filename;
    private char direction;
    private int steps;
    private int hX = 0;
    private int hY = 0;
    private int tX = 0;
    private int tY = 0;
    private ArrayList<String> visited = new ArrayList<String>();
    private double visitedByTail = 0;

    public Snake(String filename) {
        this.filename = filename;
        initializeScanner();
        while(tgb.hasNextLine()){
            getNextLine();
            calculateMovement();
            if(checkPosition()){
                visited.add(tX + ":" + tY);
            };
        }
        visitedByTail = visited.size();
    }

    public boolean checkPosition(){
        for(int i = 0; i < visited.size(); i++){
            if(tX == Integer.parseInt(visited.get(i).substring(0,visited.get(i).indexOf(':'))) && tY == Integer.parseInt(visited.get(i).substring(visited.get(i).indexOf(':')+1))){
                return false;
            }
        }
        return true;
    }

    public void calculateMovement(){
        while(steps != 0){
            moveHead();
            moveTail();
            steps -= 1;
        }
    }

    public void moveTail(){
        int dX = hX - tX;
        int dY = hY - tY;
        if(dX == 0 || dY == 0){
            if(dX < -1){moveLeft();}
            else if(dX > 1){moveRight();}
            else if(dY < -1){moveDown();}
            else if(dY > 1){moveUp();}
        }
        else if(dX < -1 || dX > 1){

        }
        else if(dY < -1 || dY > 1){

        }
    }

    public void moveRight(){tX += 1;}

    public void moveLeft(){tX -= 1;}

    public void moveDown(){tY -= 1;}

    public void moveUp(){tY += 1;}

    public void moveHead(){
        if(direction == 'D'){hY -= steps;}
        else if(direction == 'L'){hX -= steps;}
        else if(direction == 'U'){hY += steps;}
        else{hX += steps;}
    }

    public void getNextLine(){
        String currentLine = tgb.nextLine();
        direction = currentLine.charAt(0);
        steps = Integer.parseInt(currentLine.substring(2));
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
            visited.add("0:0");
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getVisitedByTail() {
        return visitedByTail;
    }
}
