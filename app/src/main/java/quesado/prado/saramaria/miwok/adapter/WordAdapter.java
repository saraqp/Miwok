package quesado.prado.saramaria.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import quesado.prado.saramaria.miwok.R;
import quesado.prado.saramaria.miwok.Word;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(@NonNull Context context, int resource, ArrayList<Word> words) {
        super(context, resource);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView=convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout,parent,false);
        }
        Word word=getItem(position);
    }
}
