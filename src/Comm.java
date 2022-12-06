import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Comm{
    private Scanner tgb;
    private final String filename;
    private String line;
    private String comparable = "";
    private int done = 0;
    private int characterAmount = 4;

    public Comm(String filename) {
        this.filename = filename;
        initializeScanner();
        line = tgb.nextLine();
        calculateCharacters();
    }

    public void calculateCharacters(){
        checkFirstFourChars();
        while(done == 0){
            checkNextCharacter();
        }
    }

    public void checkNextCharacter(){
        comparable = "" +  comparable.charAt(1) + comparable.charAt(2) + comparable.charAt(3) + line.charAt(characterAmount);
        checkIfDone();
        characterAmount += 1;
    }

    public void checkFirstFourChars(){
        for(int i = 0; i < 4; i ++){
            comparable += line.charAt(i);
        }
        checkIfDone();
    }

    public void checkIfDone(){
        if (comparable.charAt(0) == comparable.charAt(1)) {
        } else if (comparable.charAt(0) == comparable.charAt(2)) {
        } else if (comparable.charAt(0) == comparable.charAt(3)) {
        } else if (comparable.charAt(1) == comparable.charAt(2)) {
        } else if (comparable.charAt(1) == comparable.charAt(3)) {
        } else if (comparable.charAt(2) == comparable.charAt(3)) {
        } else {done = 1;}
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public int getCharacterAmount() {
        return characterAmount;
    }
}