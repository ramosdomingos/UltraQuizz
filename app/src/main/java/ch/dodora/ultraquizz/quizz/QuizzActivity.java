package ch.dodora.ultraquizz.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import ch.dodora.ultraquizz.R;
import ch.dodora.ultraquizz.quizz.action.Action;

public class QuizzActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "QUIZZ_EXTRA_TITLE";
    private static final String THREAD_QUESTION = "THREAD_QUESTION";
    private ProgressBar pb_timeQuestion;
    private TextView tv_theme;
    private Action action;
    private int currentQuestion = 0;
    private ToggleButton tb_joker_time, tb_joker_50, tb_joker_next, tb_joker_ultra;
    private ArrayList<ToggleButton> tb_joker_buttons;
    private Button btn_answer_0, btn_answer_1, btn_answer_2, btn_answer_3;
    private ArrayList<Button> btn_answers;
    private CompoundButton.OnCheckedChangeListener OnCheckedChangeListener_quizz = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton view, boolean isChecked) {
            if (!isChecked) {
                disableView(view);
                action.buttonPressed();
            }
        }
    };
    private Runnable runnableQuestion = new Runnable() {
        @Override
        public void run() {
            //Leave a moment before to display the question
            do {
                try {
                    action.nextQuestion();
                    Thread.sleep(500);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);

            //Thread for the question
            int durationQuestion = 2; //Duration in seconds
            int timePassed = 0;
            int sleepTime = 10;
            pb_timeQuestion.setMax(durationQuestion * 100);
            do {
                pb_timeQuestion.setProgress(timePassed);
                try {
                    pb_timeQuestion.setProgress(timePassed++);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    sleepTime *= 10;
                }
            } while (timePassed <= pb_timeQuestion.getMax());
        }
    };
    private Thread threadQuestion = new Thread(runnableQuestion, THREAD_QUESTION);
    private View.OnClickListener onClick_quizz = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tb_quizz_joker_time:
                    threadQuestion.interrupt();
                    break;
            }
        }
    };

    private void disableView(CompoundButton view) {
        view.setEnabled(false);
        view.setAlpha(.4f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        setTitle(getIntent().getStringExtra(EXTRA_TITLE));

        //Initialization views
        pb_timeQuestion = (ProgressBar) findViewById(R.id.pb_quizz_timeQuestion);
        tv_theme = ((TextView) findViewById(R.id.tv_quizz_theme));
        tb_joker_time = (ToggleButton) findViewById(R.id.tb_quizz_joker_time);
        tb_joker_50 = (ToggleButton) findViewById(R.id.tb_quizz_joker_50);
        tb_joker_next = (ToggleButton) findViewById(R.id.tb_quizz_joker_next);
        tb_joker_ultra = (ToggleButton) findViewById(R.id.tb_quizz_joker_ultra);
        tb_joker_buttons = new ArrayList<>();
        tb_joker_buttons.add(tb_joker_time);
        tb_joker_buttons.add(tb_joker_50);
        tb_joker_buttons.add(tb_joker_next);
        tb_joker_buttons.add(tb_joker_ultra);
        tb_joker_buttons.trimToSize();
        for (ToggleButton tb : tb_joker_buttons) {
            tb.setOnCheckedChangeListener(OnCheckedChangeListener_quizz);
            tb.setOnClickListener(onClick_quizz);
        }
        btn_answer_0 = ((Button) findViewById(R.id.btn_quizz_answer0));
        btn_answer_1 = ((Button) findViewById(R.id.btn_quizz_answer1));
        btn_answer_2 = ((Button) findViewById(R.id.btn_quizz_answer2));
        btn_answer_3 = ((Button) findViewById(R.id.btn_quizz_answer3));
        btn_answers = new ArrayList<>();
        btn_answers.add(btn_answer_0);
        btn_answers.add(btn_answer_1);
        btn_answers.add(btn_answer_2);
        btn_answers.add(btn_answer_3);
        btn_answers.trimToSize();

        tv_theme.setText(getIntent().getStringExtra(EXTRA_TITLE));
        action = new Action(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        threadQuestion.start();
    }

    @Override
    public void onBackPressed() {
        if (threadQuestion.isAlive()) {
            action.invalidOperation();
        } else super.onBackPressed();
    }
}