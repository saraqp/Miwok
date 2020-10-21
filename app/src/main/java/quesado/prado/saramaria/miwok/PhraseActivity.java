package quesado.prado.saramaria.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import quesado.prado.saramaria.miwok.adapter.WordAdapter;

public class PhraseActivity extends AppCompatActivity {
    ArrayList<Word> phrases=new ArrayList<>();
    WordAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        phrases.add(new Word("Where are you going?","minto wuksus"));
        phrases.add(new Word("What is your name?","tinnә oyaase'nә"));
        phrases.add(new Word("My name is...","oyaaset..."));
        phrases.add(new Word("How are you feeling?","michәksәs?"));
        phrases.add(new Word("I’m feeling good.","kuchi achit"));
        phrases.add(new Word("Are you coming?","әәnәs'aa?"));
        phrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        phrases.add(new Word("I’m coming.","әәnәm"));
        phrases.add(new Word("Let’s go.","yoowutis"));
        phrases.add(new Word("Come here.","әnni'nem"));

        adapter = new WordAdapter(this, phrases,R.color.category_phrases);
        ListView listView= (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }
}