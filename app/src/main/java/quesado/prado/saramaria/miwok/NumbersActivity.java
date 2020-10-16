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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words= new ArrayList<>();
        words.add(new Word("One","Lutti"));
        words.add(new Word("Two","Otiiko"));
        words.add(new Word("Three","Tolookosu"));
        words.add(new Word("Four","Oyyisa"));
        words.add(new Word("Five","Massokka"));
        words.add(new Word("Six","Temmokka"));
        words.add(new Word("Seven","Kenekaku"));
        words.add(new Word("Eight","Kawinta"));
        words.add(new Word("Nine","Wo'e"));
        words.add(new Word("Ten","Na'aacha"));

        WordAdapter adapter = new WordAdapter(this, R.layout.item_list_layout, words);
        ListView listView= (ListView) findViewById(R.id.NumbersListView);
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