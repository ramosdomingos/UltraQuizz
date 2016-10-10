package ch.dodora.ultraquizz;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ch.dodora.ultraquizz.database.DatabaseHelper;
import ch.dodora.ultraquizz.database.TableQuestion;
import ch.dodora.ultraquizz.quizz.Question;
import ch.dodora.ultraquizz.quizz.QuizzActivity;

public class StarterActivity extends AppCompatActivity {
    public static SQLiteDatabase db;
    private static DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
    }

    public void onClick_starter(View v) throws Exception {
        Question.questions.clear();

        if (!(v instanceof Button))
            throw new Exception("This view is not a Button");

        String theme = ((Button) v).getText().toString();

        Intent intent = new Intent(this, QuizzActivity.class);
        intent.putExtra(QuizzActivity.EXTRA_TITLE, theme);
        TableQuestion.SQL_RETRIEVE_QUESTION(theme);
        startActivity(intent);
    }
}
