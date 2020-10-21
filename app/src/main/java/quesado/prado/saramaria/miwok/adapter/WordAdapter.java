package quesado.prado.saramaria.miwok.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

import quesado.prado.saramaria.miwok.R;
import quesado.prado.saramaria.miwok.Word;

public class WordAdapter extends ArrayAdapter<Word> {
    ArrayList<Word> words;
    int backgroundColor;
    //MediaPlayer mediaPlayer;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words,int backgroundColor) {
        super(context,0, words);
        this.words=words;
        this.backgroundColor=backgroundColor;
       // mediaPlayer=MediaPlayer.create(context,R.raw.number_one);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView=convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout,parent,false);
        }

        LinearLayout linearLayout= (LinearLayout) listItemView.findViewById(R.id.layoutWords);
        linearLayout.setBackgroundResource(backgroundColor);

//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.start();
//            }
//        });

        Word word=words.get(position);

        TextView miwok_word= (TextView) listItemView.findViewById(R.id.miwokTextView);
        miwok_word.setText(word.getWord_miwok());

        TextView ingles_word= (TextView) listItemView.findViewById(R.id.inglesTextView);
        ingles_word.setText(word.getWord_ingles());

        ImageView imageView= (ImageView) listItemView.findViewById(R.id.imagen);

        if (word.tieneImagen()) {
            imageView.setImageResource(word.getImagenResourceId());
        }else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
