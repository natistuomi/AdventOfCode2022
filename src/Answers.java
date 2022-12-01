public class Answers {
    public static void main(String [] args){
        Calories a = new Calories("input_calories.txt", 2235);
        System.out.println("Largest amount of calories: " + a.getMostCalories());
        System.out.println("Total calories of top three elves: " + a.getTotalTopThreeCalories());
    }

}
