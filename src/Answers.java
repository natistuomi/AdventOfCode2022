public class Answers {
    public static void main(String [] args){
        System.out.println("DAY 1");
        Calories a = new Calories("input_calories.txt", 2235);
        System.out.println("Largest amount of calories: " + a.getMostCalories());
        System.out.println("Total calories of top three elves: " + a.getTotalTopThreeCalories());
    }

}
