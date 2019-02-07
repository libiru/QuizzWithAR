package com.hack.innovationstar.augmentedimages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class QuestionScreenActivity extends Activity {

    private String questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);


        Intent intent = this.getIntent();
        //-------------op1
        //questionText=intent.getStringExtra("question");
        //-------------op2

        Bundle bundle = intent.getBundleExtra("Bundle");
        questionText = bundle.getString("question");
        String option1 = bundle.getString("option1");
        String option2 = bundle.getString("option2");
        String option3 = bundle.getString("option3");
        String option4 = bundle.getString("option4");

//op3
        //questionText = "fake";

        Log.d("Entrou", "---------------> QuestionScreenActivity()<---------------------------");
        Log.v("rahul", questionText);

        TextView questionTextView = findViewById(R.id.questionid);
        questionTextView.setText(questionText);
            //op2
        TextView option1View = findViewById(R.id.option1id);
        option1View.setText(option1);

        TextView option2View = findViewById(R.id.option2id);
        option2View.setText(option2);

        TextView option3View = findViewById(R.id.option3id);
        option3View.setText(option3);

        TextView option4View = findViewById(R.id.option4id);
        option4View.setText(option4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("Entrou", "---------------> QuestionScreenActivity()<---------------------------");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

