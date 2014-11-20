
package com.jakegosskuehn.jihadbomber;

import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;




public class MainActivity extends Activity {

    
    private SoundPool soundPool;
    private SoundPool soundPool2;
    boolean loaded = false;
    boolean songloaded = false;
    private int _hey_over_here;
    private int _jihad_explosion;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                    int status) {
                loaded = true;
//                Toast.makeText(MainActivity.this,
//                        "FULLY LOADED TO HONK!!!", Toast.LENGTH_SHORT).show();
            }
        });
        
        _hey_over_here = soundPool.load(this, R.raw.hey_over_here, 1);
        _jihad_explosion = soundPool.load(this, R.raw.jihad_explosion, 1);
        
        
        Toast.makeText(MainActivity.this,
                "Beep Beep Beep", Toast.LENGTH_SHORT).show();
        
        
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final ImageView button3 = (ImageView) findViewById(R.id.button3);
        
        button1.setOnClickListener(new OnClickListener(){
            
            
            public void onClick(View view) {
            
            pesterAudio();
            }
        }
        );
        
        button2.setOnClickListener(new OnClickListener(){
            
            
            public void onClick(View view) {
            
            jihadAudio();
            }
        }
    );
        
        button3.setOnClickListener(new OnClickListener(){
            
            
            public void onClick(View view) {
            
            beepToast();
            }
        }
);
    }
    
    public void pesterAudio()
    {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        
        boolean uno = (loaded);

        //plays if it is loaded
        if(uno)
        {
            soundPool.play(_hey_over_here, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played overhere");
        }  
    }

    public void jihadAudio()
    {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        
        boolean uno = (loaded);

        //plays if it is loaded
        if(uno)
        {
            soundPool.play(_jihad_explosion, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played jihad");
        }  
    }
    
    public void beepToast()
    {
        Toast.makeText(MainActivity.this,
                "Beep", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
