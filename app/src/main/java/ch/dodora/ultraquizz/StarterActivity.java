package ch.dodora.ultraquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ch.dodora.ultraquizz.quizz.QuizzActivity;

public class StarterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
    }

    public void onClick_starter(View v) throws Exception {
        if (!(v instanceof Button))
            throw new Exception("This view is not a Button");

        String theme = ((Button) v).getText().toString();

        if (theme != null) {
            Intent intent = new Intent(this, QuizzActivity.class);
            intent.putExtra(QuizzActivity.EXTRA_TITLE, theme);
            startActivity(intent);
        } else throw new Exception("The theme is null");
    }
}
