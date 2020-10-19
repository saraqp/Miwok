package quesado.prado.saramaria.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import quesado.prado.saramaria.miwok.R;
import quesado.prado.saramaria.miwok.Word;

public class WordAdapter extends ArrayAdapter<Word> {
    ArrayList<Word> words;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context,0, words);
        this.words=words;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView=convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout,parent,false);
        }
        TextView miwok_word= (TextView) listItemView.findViewById(R.id.miwokTextView);
        miwok_word.setText(words.get(position).getWord_miwok());

        TextView ingles_word= (TextView) listItemView.findViewById(R.id.inglesTextView);
        ingles_word.setText(words.get(position).getWord_ingles());

        ImageView imageView= (ImageView) listItemView.findViewById(R.id.imagen);
        imageView.setImageResource(words.get(position).getImagenResourceId());
        return listItemView;
    }
}
