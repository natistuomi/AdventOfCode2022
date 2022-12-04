public class Answer {
    private final String[] name =
            {"Calories",
            "Tournament",
            "Rucksack",
            "Cleanup",
            "?"};
    private final String[] firstLabel =
            {"Largest amount of calories",
            "Incorrect total score",
            "Priorities for all rucksacks",
            "Completely overlapping pairs",
            "?"};
    private final String[] secondLabel =
            {"Total calories of the top three elves",
            "Correct total score",
            "Priorities for badges",
            "Overlapping pairs",
            "?"};
    private final int[] stars = {2,2,2,2,0};
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
        else if(x == 2){
            Rucksack a = new Rucksack(filename);
            results[0] = String.valueOf(a.getSumOfPriorities());
            results[1] = String.valueOf(a.getBadgePriorities());}
        else if(x == 3){
            Cleanup a = new Cleanup(filename);
            results[0] = String.valueOf(a.getAmountOfOverlappingSections());
            results[1] = String.valueOf(a.getAmountOfOverlappingPairs());
        }
        else if(x == 4){}
    }

    public String getAnswers() {
        String s = "DAY " + currentDay + " - " + name[x] + "\n";
        s += firstLabel[x] + ": " + results[0] + "\n";
        s += secondLabel[x] + ": " + results[1] + "\n";
        s += stars[x] + " STARS\n\n";
        return s;
    }
}