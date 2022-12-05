import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Crates {
    private Scanner tgb;
    private final String filename;
    private String currentLine;
    private char[][] crate = new char[9][56];
    private int[] instruction = new int[3];
    private int[] amountOfCrates = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private String incorrectMessage = "";
    private String correctMessage = "";

    public Crates(String filename) {
        this.filename = filename;
    }

    public void calculateCrates(int n){
        initializeScanner();
        originalCrates();
        while(tgb.hasNextLine()){
            getNextLine();
            moveCrates(n);
        }
        writeMessage(n);
    }

    public void writeMessage(int n){
        for(int i = 0; i < 9; i++){
            if(n == 0){
                incorrectMessage += crate[ i ][ amountOfCrates[i] ];
            }
            else{
                correctMessage += crate[ i ][ amountOfCrates[i] ];
            }
        }
    }

    public void moveCrates(int n){
        separateInstructions();
        followInstructions(n);
    }

    public void followInstructions(int n){
        int amountToMove = instruction[0];
        int stack = amountToMove;
        int from = instruction[1]-1;
        int to = instruction[2]-1;
        for(int i = 0; i < amountToMove; i++){
            if(n == 0){
                crate[ to ][ amountOfCrates[to]+1 ] = crate[ from ][ amountOfCrates[from] ];
                crate[ from ][ amountOfCrates[from] ] = ' ';
                amountOfCrates[ from ] -= 1;
            }
            else{
                crate[ to ][ amountOfCrates[to]+1 ] = crate[ from ][ amountOfCrates[from]-stack+1 ];
                crate[ from ][ amountOfCrates[from]-stack+1 ] = ' ';
                stack -= 1;
                if(i == amountToMove-1){
                    amountOfCrates[from] -= amountToMove;
                }
            }
            amountOfCrates[to] += 1;
        }
    }

    public void separateInstructions(){
        int a = currentLine.length();
        int[] spot = {5,a-12,a-6,a-5,a-1};
        instruction[0] = Integer.parseInt(currentLine.substring(spot[0], spot[1]));
        instruction[1] = Integer.parseInt(currentLine.substring(spot[2], spot[3]));
        instruction[2] = Integer.parseInt(currentLine.substring(spot[4]));
    }

    public void originalCrates(){
        for(int i = 7; i > -1; i--){
            getNextLine();
            for(int x = 0; x < 9; x++){
                crate[x][i] = setCrate(1+(x*4));
                if(crate[x][i] != ' '){
                    amountOfCrates[x] += 1;
                }
            }
        }
        getNextLine();
        getNextLine();
    }

    public char setCrate(int x){
        if(currentLine.charAt(x) != ' '){
            return currentLine.charAt(x);
        }
        return ' ';
    }

    public void getNextLine(){currentLine = tgb.nextLine();}

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public String getIncorrectMessage() {
        calculateCrates(0);
        return incorrectMessage;
    }

    public String getCorrectMessage() {
        calculateCrates(1);
        return correctMessage;
    }
}
