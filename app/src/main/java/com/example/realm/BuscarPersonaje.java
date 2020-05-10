package com.example.realm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;

public class BuscarPersonaje extends AppCompatActivity {

    Button queryJoel, queryEllie;
    ImageView imageJoel, imageEllie;
    TextView infoJoel, infoEllie;
    Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        queryJoel = findViewById(R.id.queryJoel);
        imageJoel = findViewById(R.id.joelImage);
        queryEllie = findViewById(R.id.queryEllie);
        imageEllie = findViewById(R.id.ellieImage);
        infoJoel = findViewById(R.id.infoJoel);
        infoEllie = findViewById(R.id.infoEllie);


        queryJoel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageJoel.setImageResource(R.drawable.joel);
                infoJoel.setText(String.format("%s", realm.where(Personaje.class).equalTo("name", "Joel").findAll()));
            }
        });

        queryEllie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageEllie.setImageResource(R.drawable.ellie);
                infoEllie.setText(String.format("%s", realm.where(Personaje.class).equalTo("name", "Ellie").findAll()));
            }
        });
    }
}
