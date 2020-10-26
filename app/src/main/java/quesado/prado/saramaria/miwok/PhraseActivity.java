package quesado.prado.saramaria.miwok;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import quesado.prado.saramaria.miwok.adapter.WordAdapter;

public class PhraseActivity extends AppCompatActivity {
    ArrayList<Word> phrases=new ArrayList<>();
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
        setContentView(R.layout.activity_phrase);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        phrases.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        phrases.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        phrases.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        adapter = new WordAdapter(this, phrases,R.color.category_phrases);
        ListView listView= (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result=audioManager.requestAudioFocus(audioListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer=MediaPlayer.create(view.getContext(),phrases.get(position).getAudio_palabra());
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