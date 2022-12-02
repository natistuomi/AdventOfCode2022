public class Answer {
    private final String[] name = {"Calories", "Tournament"};
    private final String[] firstLabel = {"Largest amount of calories: ", "Incorrect total score: "};
    private final String[] secondLabel ={"Total calories of the top three elves: ", "Correct total score: "};
    private final int[] stars = {2, 2};
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
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public String getAnswers() {
        String s = "DAY " + currentDay + " - " + name[x] + "\n";
        s += firstLabel[x] + results[0] + "\n";
        s += secondLabel[x] + results[1] + "\n";
        s += stars[x] + " STARS\n\n";
        return s;
    }
}