package ch.dodora.ultraquizz.quizz;

import java.util.ArrayList;

/**
 * Created by rdomi on 10/10/2016.
 */

public class Question {

    public final static int QUESTIONS_TO_DISPLAY = 20;
    public static boolean isReady = false;
    public static ArrayList<Question> questions = new ArrayList(QUESTIONS_TO_DISPLAY);
    private final String theme;
    private final String proposition;
    private final String answerxRight;
    private final ArrayList<String> answerFalses;

    public Question(String theme, String proposition, String answerRight, ArrayList<String> answerFalses) {
        this.theme = theme;
        this.proposition = proposition;
        this.answerxRight = answerRight;
        this.answerFalses = answerFalses;

        questions.add(this);
        if (questions.size() == QUESTIONS_TO_DISPLAY) isReady = true;
    }
}