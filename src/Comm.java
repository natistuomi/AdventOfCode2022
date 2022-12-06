import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Comm{
    private Scanner tgb;
    private final String filename;
    private int n;
    private String line;
    private String comparable = "";
    private int done = 0;
    private int characterAmount;

    public Comm(String filename, int n) {
        this.filename = filename;
        this.n = n;
        characterAmount = n;
        initializeScanner();
        line = tgb.nextLine();
        calculateCharacters();
    }

    public void calculateCharacters(){
        checkFirstChars();
        while(done == 0 && characterAmount < 4000){
            checkNextCharacter();
            checkIfDone();
        }
    }

    public void checkIfDone(){
        String s = "" + comparable.charAt(0);
        for(int i = 1; i < n; i++){
            if(s.indexOf(comparable.charAt(i)) == -1){
                s += comparable.charAt(i);
            }
        }
        if(s.length() == n){
            done = 1;
        }
    }

    public void checkNextCharacter(){
        String s = "";
        for(int i = 1; i < n; i++){
            s += comparable.charAt(i);
        }
        s += line.charAt(characterAmount);
        comparable = s;
        characterAmount += 1;
    }

    public void checkFirstChars(){
        for(int i = 0; i < n; i ++){
            comparable += line.charAt(i);
        }
        checkIfDone();
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