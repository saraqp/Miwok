package quesado.prado.saramaria.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        setContentView(R.layout.category_layout);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor,new NumbersFragment())
                .commit();

    }

}
class NumbersClickListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(v.getContext(),NumbersActivity.class);
        v.getContext().startActivity(intent);

    }
}