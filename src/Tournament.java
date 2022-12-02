import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tournament{
    private Scanner tgb;
    private final String filename;
    private double[] totalScore = {0,0};
    private final double amountOfLines;
    private final int incorrect = 0;
    private final int correct = 1;
    private String[] letterInSpot = {"", ""};
    private int[] shapePlayed = {0, 0, 0};

    public Tournament(String filename, double amountOfLines) {
        this.filename = filename;
        this.amountOfLines = amountOfLines;
        calculateTournament();
    }

    public void calculateTournament(){
        initializeScanner();
        for(int i = 0; i < amountOfLines; i++){
            calculateRound();
        }
    }

    public void calculateRound(){
        getNextLine();
        nameShapeValues();
        calculateGamePoints();
    }

    public void calculateGamePoints(){
        incorrectGame();
        correctGame();
    }

    public void incorrectGame(){
        if(shapePlayed[0] == shapePlayed[1]){
            totalScore[incorrect] += 3;
        }
        else if(shapePlayed[1]-shapePlayed[0] == 1 || shapePlayed[1]-shapePlayed[0] == -2){
            totalScore[incorrect] += 6;
        }
        totalScore[incorrect] += shapePlayed[1];
    }

    public void correctGame(){
        totalScore[correct] += ((shapePlayed[1]-1)*3);
        totalScore[correct] += shapePlayed[2];
    }

    public void nameShapeValues() {
        if(letterInSpot[0].equals("A")){
            shapePlayed[0] = 1;
        }
        else if(letterInSpot[0].equals("B")){
            shapePlayed[0] = 2;
        }
        else{
            shapePlayed[0] = 3;
        }
        if(letterInSpot[1].equals("X")){
            shapePlayed[1] = 1;
            shapePlayed[2] = (shapePlayed[0]-1)%3;
        }
        else if(letterInSpot[1].equals("Y")){
            shapePlayed[1] = 2;
            shapePlayed[2] = shapePlayed[0];
        }
        else{
            shapePlayed[1] = 3;
            shapePlayed[2] = (shapePlayed[0]+1)%3;
        }
        if(shapePlayed[2] == 0){
            shapePlayed[2] = 3;
        }
    }

    public void getNextLine(){
        for(int i = 0; i < 2; i++){
            letterInSpot[i] = "";
        }
        String currentLine = tgb.nextLine();
        letterInSpot[0] += currentLine.charAt(0);
        letterInSpot[1] += currentLine.charAt(2);
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getTotalScore() {
        return totalScore[incorrect];
    }

    public double getCorrectTotalScore(){
        return totalScore[correct];
    }
}