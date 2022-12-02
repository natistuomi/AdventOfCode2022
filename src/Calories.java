import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories {
    private final String filename;
    private Scanner tgb;
    private double totalTopThreeCalories = 0;
    private double mostCalories = 0;
    private double secondMostCalories = 0;
    private double thirdMostCalories = 0;
    private double currentCalories = 0;
    private String currentLine;

    public Calories(String filename) {
        this.filename = filename;
        calculateMostCalories();
    }

    public void calculateMostCalories(){
        initializeScanner();
        calculateElfsCalories();
        calculateTotalTopThreeCalories();
    }

    public void calculateElfsCalories(){
        while(tgb.hasNextLine()) {
            getNextLine();
            if (lineIsEmpty()) {
                compareCalories();
                currentCalories = 0;
            } else {
                currentCalories += Double.parseDouble(currentLine);
            }
        }
    }

    public void getNextLine(){
        currentLine = tgb.nextLine();
    }

    public boolean lineIsEmpty(){
        return currentLine.equals("");
    }

    public void compareCalories(){
        if(currentCalories > mostCalories){
            thirdMostCalories = secondMostCalories;
            secondMostCalories = mostCalories;
            mostCalories = currentCalories;
        }
        else if(currentCalories > secondMostCalories){
            thirdMostCalories = secondMostCalories;
            secondMostCalories = currentCalories;
        }
        else if(currentCalories > thirdMostCalories){
            thirdMostCalories = currentCalories;
        }
    }

    public void calculateTotalTopThreeCalories() {
        totalTopThreeCalories = mostCalories + secondMostCalories + thirdMostCalories;
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getMostCalories() {
        return mostCalories;
    }

    public double getTotalTopThreeCalories() {
        return totalTopThreeCalories;
    }
}