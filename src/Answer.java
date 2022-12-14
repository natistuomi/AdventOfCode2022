public class Answer {
    private final String[] name =
            {"Calories",
            "Tournament",
            "Rucksack",
            "Cleanup",
            "Crates",
            "Comm",
            "Filesystem",
            "Treehouse",
            "Snake"};
    private final String[] firstLabel =
            {"Largest amount of calories",
            "Incorrect total score",
            "Priorities for all rucksacks",
            "Completely overlapping pairs",
            "Incorrect top crates",
            "Characters processed before start",
            "Sum of directories under 100000",
            "Visible trees",
            "Positions visited by tail"};
    private final String[] secondLabel =
            {"Total calories of the top three elves",
            "Correct total score",
            "Priorities for badges",
            "Overlapping pairs",
            "Correct top crates",
            "Characters processed before message",
            "",
            "",
            ""};
    private final int[] stars = {2,2,2,2,2,2,0,0,0};
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
        else if(x == 4){
            Crates a = new Crates(filename);
            Crates b = new Crates(filename);
            results[0] = a.getIncorrectMessage();
            results[1] = b.getCorrectMessage();
        }
        else if(x == 5){
            Comm a = new Comm(filename, 4);
            Comm b = new Comm(filename, 14);
            results[0] = String.valueOf(a.getCharacterAmount());
            results[1] = String.valueOf(b.getCharacterAmount());
        }
        else if(x == 6){
            Filesystem2 a = new Filesystem2(filename);
            results[0] = String.valueOf(a.getSizeSum());
            results[1] = "";
        }
        else if(x == 7){
            Treehouse a = new Treehouse(filename);
            results[0] = String.valueOf(a.getVisibleTrees());
            results[1] = "";
        }
        else if(x == 8){
            Snake a = new Snake(filename);
            results[0] = String.valueOf(a.getVisitedByTail());
            results[1] = "";
        }
    }

    public String getAnswers() {
        String s = "DAY " + currentDay + " - " + name[x] + "\n";
        s += firstLabel[x] + ": " + results[0] + "\n";
        s += secondLabel[x] + ": " + results[1] + "\n";
        s += stars[x] + " STARS\n\n";
        return s;
    }
}