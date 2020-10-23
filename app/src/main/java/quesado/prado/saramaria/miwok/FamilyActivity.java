package quesado.prado.saramaria.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import quesado.prado.saramaria.miwok.adapter.WordAdapter;

public class FamilyActivity extends AppCompatActivity {
    final ArrayList<Word> family= new ArrayList<>();
    WordAdapter adapter;
    MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener audioListener= new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT|| focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);

            }else if(focusChange== AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();

            }else if( focusChange== AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        family.add(new Word("Father","әpә",R.drawable.family_father,R.raw.family_father));
        family.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        family.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        family.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        adapter = new WordAdapter(this, family,R.color.category_family);

        ListView listView= (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result=audioManager.requestAudioFocus(audioListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer=MediaPlayer.create(view.getContext(),family.get(position).getAudio_palabra());
                    mediaPlayer.start();
                }
            }
        });
    }
    private void releaseMediaPlayer(){
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
        audioManager.abandonAudioFocus(audioListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}