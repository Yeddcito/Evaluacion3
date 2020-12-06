package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class menu extends AppCompatActivity {
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        video = (VideoView)findViewById(R.id.vid);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);


        MediaController media = new MediaController(this);
        video.setMediaController(media);

    }
    public void promocion (View v){
        Intent a= new Intent(getBaseContext(), Promociones.class);
        startActivity(a);
    }
    public void gestion (View v){
        Intent e= new Intent(getBaseContext(),firebase.class);
        startActivity(e);
    }

}
