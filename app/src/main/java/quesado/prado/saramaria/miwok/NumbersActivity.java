package quesado.prado.saramaria.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words= new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");


        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.NumbersLinearLayout);
        for (int i =0;i<words.size();i++) {
            TextView numberView= new TextView(this);
            numberView.setText(words.get(i));
            linearLayout.addView(numberView);
        }
    }
}
class NumbersClickListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(v.getContext(),NumbersActivity.class);
        v.getContext().startActivity(intent);

    }
}