public class AdventOfCode2022 {
    private static String[] filename =
            {"input_calories.txt",
            "input_tournament.txt",
            "input_rucksack.txt",
            "input_cleanup.txt",
            "input_crates.txt"};

    public static void main(String[] args){
        Answer x = new Answer(5, filename[4]);
        System.out.println("\n\n\n" + x.getAnswers());
    }

    public static void getAllAnswers(){
        Answer a = new Answer(1, filename[0]);
        Answer b = new Answer(2, filename[1]);
        Answer c = new Answer(3, filename[2]);
        Answer d = new Answer(4, filename[3]);
        Answer e = new Answer(5, filename[4]);
        System.out.println(a.getAnswers() + b.getAnswers() + c.getAnswers() + d.getAnswers() + e.getAnswers());
    }
}
