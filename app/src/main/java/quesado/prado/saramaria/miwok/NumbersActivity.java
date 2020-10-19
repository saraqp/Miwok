package quesado.prado.saramaria.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import quesado.prado.saramaria.miwok.adapter.WordAdapter;

public class NumbersActivity extends AppCompatActivity {
    ArrayList<Word> words= new ArrayList<>();
    WordAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        words.add(new Word("One","Lutti",R.drawable.number_one));
        words.add(new Word("Two","Otiiko",R.drawable.number_two));
        words.add(new Word("Three","Tolookosu",R.drawable.number_three));
        words.add(new Word("Four","Oyyisa",R.drawable.number_four));
        words.add(new Word("Five","Massokka",R.drawable.number_five));
        words.add(new Word("Six","Temmokka",R.drawable.number_six));
        words.add(new Word("Seven","Kenekaku",R.drawable.number_seven));
        words.add(new Word("Eight","Kawinta",R.drawable.number_eight));
        words.add(new Word("Nine","Wo'e",R.drawable.number_nine));
        words.add(new Word("Ten","Na'aacha",R.drawable.number_ten));

        adapter = new WordAdapter(this, words);
        ListView listView= (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);

    }
}
class NumbersClickListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(v.getContext(),NumbersActivity.class);
        v.getContext().startActivity(intent);

    }
}