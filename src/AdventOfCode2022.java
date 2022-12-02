public class AdventOfCode2022 {
    private static String[] filename =
            {"input_calories.txt",
            "input_tournament.txt",};

    public static void main(String[] args){
        Answer x = new Answer(2, filename[1]);
        System.out.println(x.getAnswers());
    }

    public static void getAllAnswers(){
        Answer a = new Answer(1, filename[0]);
        Answer b = new Answer(2, filename[1]);
        System.out.println(a.getAnswers() + b.getAnswers());
    }
}
