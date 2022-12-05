import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cleanup {
    private Scanner tgb;
    private final String filename;
    private String currentLine = "";
    private String[] elfNr = {"", ""};
    private int[] section = {0,0,0,0};
    private double amountOfOverlappingSections = 0;
    private double amountOfOverlappingPairs = 0;

    public Cleanup(String filename) {
        this.filename = filename;
        calculateSections();
    }

    public void calculateSections(){
        initializeScanner();
        while(tgb.hasNextLine()){
            getNextLine();
            calculateSectionOverlap();
        }
    }

    public void calculateSectionOverlap(){
        separateElves();
        separateValues();
        compareSections();
    }

    public void compareSections(){
        if(section[0] >= section[2] && section[1] <= section[3]){
            amountOfOverlappingSections += 1;
            amountOfOverlappingPairs += 1;
        }
        else if(section[2] >= section[0] && section[3] <= section[1]){
            amountOfOverlappingSections += 1;
            amountOfOverlappingPairs += 1;
        }
        else if(section[2] <= section[1] && section[3] >= section[0]){
            amountOfOverlappingPairs += 1;
        }
    }

    public void separateValues(){
        section[0] = Integer.parseInt(elfNr[0].substring(0,elfNr[0].indexOf('-')));
        section[1] = Integer.parseInt(elfNr[0].substring(elfNr[0].indexOf('-')+1));
        section[2] = Integer.parseInt(elfNr[1].substring(0,elfNr[1].indexOf('-')));
        section[3] = Integer.parseInt(elfNr[1].substring(elfNr[1].indexOf('-')+1));
    }

    public void separateElves(){
        elfNr[0] = currentLine.substring(0,currentLine.indexOf(','));
        elfNr[1] = currentLine.substring(currentLine.indexOf(',')+1);
    }

    public void getNextLine(){currentLine = tgb.nextLine();}

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getAmountOfOverlappingSections() {
        return amountOfOverlappingSections;
    }

    public double getAmountOfOverlappingPairs() {
        return amountOfOverlappingPairs;
    }
}