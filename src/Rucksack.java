import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rucksack {
    private Scanner tgb;
    private final String filename;
    private String currentLine;
    private String[] compartment = {"", ""};
    private char commonLetter;
    private String groupLetters = "";
    private char groupCommonLetter;
    private String valueOrder = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private double sumOfPriorities = 0;
    private double badgePriorities = 0;

    public Rucksack(String filename) {
        this.filename = filename;
        calculatePriorities();
    }

    public void calculatePriorities(){
        initializeScanner();
        while(tgb.hasNextLine()){
            for(int n = 0; n < 3; n++){
                getNextLine();
                calculateRucksack(n);
            }
        }
    }

    public void calculateRucksack(int n){
        setCompartments();
        findCommonLetter();
        sumOfPriorities += addValue(commonLetter);
        reSetCompartments();
        findGroupLetter(n);
    }

    public void findGroupLetter(int n){
        if(n == 0){
            groupLetters = currentLine;
        }
        else{
            groupLetters = compareLines();
        }
        if(n == 2){
            groupCommonLetter = groupLetters.charAt(0);
            badgePriorities += addValue(groupCommonLetter);
        }
    }

    public String compareLines(){
        String s = "";
        for(int i = 0; i < groupLetters.length(); i++){
            for(int x = 0; x < currentLine.length(); x++){
                if(groupLetters.charAt(i) == currentLine.charAt(x)){
                    s += groupLetters.charAt(i);
                }
            }
        }
        return s;
    }

    public int addValue(char x){
        for(int i = 0; i < valueOrder.length(); i++){
            if(x == valueOrder.charAt(i)){
                return i;
            }
        }
        return 0;
    }

    public void findCommonLetter(){
        for(int i = 0; i < compartment[0].length(); i++){
            for(int x = 0; x < compartment[0].length(); x++){
                if(compartment[0].charAt(i) == compartment[1].charAt(x)){
                    commonLetter = compartment[0].charAt(i);
                }
            }
        }
    }

    public void reSetCompartments(){
        for(int i = 0; i < 2; i++){
            compartment[i] = "";
        }
    }

    public void setCompartments(){
        int x = currentLine.length()/2;
        for(int a = 0; a < 2; a++){
            for(int i = 0; i < x; i++){
                compartment[a] += currentLine.charAt(i+(a*x));
            }
        }
    }

    public void getNextLine(){
        currentLine = tgb.nextLine();
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getSumOfPriorities() {
        return sumOfPriorities;
    }

    public double getBadgePriorities() {
        return badgePriorities;
    }
}
