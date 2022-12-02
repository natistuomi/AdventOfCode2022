public class Answer {
    private final String[] name =
            {"Calories",
            "Tournament"};
    private final String[] firstLabel =
            {"Largest amount of calories: ",
            "Incorrect total score: "};
    private final String[] secondLabel =
            {"Total calories of the top three elves: ",
            "Correct total score: ",};
    private final int[] stars = {2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private String[] results = {"", ""};
    private int currentDay;
    private String filename;
    private int x;

    public Answer(int currentDay, String filename) {
        this.currentDay = currentDay;
        this.filename = filename;
        this.x = currentDay - 1;
        calculateAnswers();
    }

    public void calculateAnswers(){
        if(x == 0){
            Calories a = new Calories(filename);
            results[0] = String.valueOf(a.getMostCalories());
            results[1] = String.valueOf(a.getTotalTopThreeCalories());}
        else if(x == 1){
            Tournament a = new Tournament(filename);
            results[0] = String.valueOf(a.getIncorrectTotalScore());
            results[1] = String.valueOf(a.getCorrectTotalScore());}
        else if(x == 2){}
        else if(x == 3){}
        else if(x == 4){}
        else if(x == 5){}
        else if(x == 6){}
        else if(x == 7){}
        else if(x == 8){}
        else if(x == 9){}
        else if(x == 10){}
        else if(x == 11){}
        else if(x == 12){}
        else if(x == 13){}
        else if(x == 14){}
        else if(x == 15){}
        else if(x == 16){}
        else if(x == 17){}
        else if(x == 18){}
        else if(x == 19){}
        else if(x == 20){}
        else if(x == 21){}
        else if(x == 22){}
        else if(x == 23){}
        else{}
    }

    public String getAnswers() {
        String s = "DAY " + currentDay + " - " + name[x] + "\n";
        s += firstLabel[x] + results[0] + "\n";
        s += secondLabel[x] + results[1] + "\n";
        s += stars[x] + " STARS\n\n";
        return s;
    }
}