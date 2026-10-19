import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String correct;
    protected String student;
    protected int points;
    Question(String correct, String student, int points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }
    abstract double score();
    abstract String getType();
}

class McqQuestion extends Question {
    McqQuestion(String c, String s, int p) { super(c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
    String getType() { return "MCQ"; }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String c, String s, int p) { super(c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
    String getType() { return "TF"; }
}

class EssayQuestion extends Question {
    EssayQuestion(String c, String s, int p) { super(c, s, p); }
    double score() {
        int count = 0;
        String answer = student.toLowerCase();
        for (String k : correct.split(",")) {
            String key = k.trim().toLowerCase();
            if (!key.isEmpty() && answer.contains(key)) count++;
        }
        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.5;
        return 0;
    }
    String getType() { return "ESSAY"; }
}

class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            Matcher m = pattern.matcher(line);
            m.find();
            m.find();
            String correct = m.group(1);
            m.find();
            String student = m.group(1);
            int points = Integer.parseInt(line.substring(line.lastIndexOf('"') + 1).trim());
            if (type.equals("MCQ")) questions.add(new McqQuestion(correct, student, points));
            else if (type.equals("TF")) questions.add(new TrueFalseQuestion(correct, student, points));
            else questions.add(new EssayQuestion(correct, student, points));
        }
        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            total += s;
            System.out.println(q.getType() + ": " + String.format("%.2f", s));
        }
        System.out.println("Total Score: " + String.format("%.2f", total));
    }
}