public class Answers {
    public static void main(String [] args){
        dayOne();
        dayTwo();
    }

    public static void dayOne(){
        System.out.println("DAY 1 - Calories");
        Calories a = new Calories("input_calories.txt", 2235);
        System.out.println("Largest amount of calories: " + a.getMostCalories());
        System.out.println("Total calories of top three elves: " + a.getTotalTopThreeCalories());
        System.out.println("");
    }

    public static void dayTwo() {
        System.out.println("DAY 2 - Tournament");
        Tournament a = new Tournament("input_tournament.txt", 2500);
        System.out.println("Total score in tournament: " + a.getTotalScore());
        System.out.println("Correct total score in tournament: " + a.getCorrectTotalScore());
        System.out.println("");
    }
}
