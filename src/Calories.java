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
    private String currentline;
    private final double amountOfLines;

    public Calories(String filename, double amountOfLines) {
        this.filename = filename;
        this.amountOfLines = amountOfLines;
        calculateMostCalories();
    }

    public void calculateMostCalories(){
        initializeScanner();
        calculateElfsCalories();
        calculateTotalTopThreeCalories();
    }

    public void calculateTotalTopThreeCalories() {
        totalTopThreeCalories = mostCalories + secondMostCalories + thirdMostCalories;
    }

    public void calculateElfsCalories(){
        for(int i = 1; i <= amountOfLines; i++) {
            getNextLine();
            if (lineIsEmpty()) {
                compareCalories();
                currentCalories = 0;
            } else {
                currentCalories += Double.parseDouble(currentline);
            }
        }
    }

    public void compareCalories(){
        if(currentCalories > thirdMostCalories){
            thirdMostCalories = currentCalories;
            if (currentCalories > secondMostCalories){
                thirdMostCalories = secondMostCalories;
                secondMostCalories = currentCalories;
                if(currentCalories > mostCalories){
                    secondMostCalories = mostCalories;
                    mostCalories = currentCalories;
                }
            }
        }
    }

    public boolean lineIsEmpty(){
        return currentline.equals("");
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public void getNextLine(){
        currentline = tgb.nextLine();
    }

    public double getMostCalories() {
        return mostCalories;
    }

    public double getTotalTopThreeCalories() {
        return totalTopThreeCalories;
    }
}
