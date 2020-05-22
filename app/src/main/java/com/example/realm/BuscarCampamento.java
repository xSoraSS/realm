package com.example.realm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class BuscarCampamento extends AppCompatActivity {

    Button queryCamp;
    ImageView campImage;
    TextView infoCamp;
    Realm realm = Realm.getDefaultInstance();
    Campamento campamento = new Campamento(), realmCampamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querycamp);

        queryCamp = findViewById(R.id.queryCamp);
        campImage = findViewById(R.id.campImage);
        infoCamp = findViewById(R.id.infoCamp);

        final Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        campamento.setNombre("JacksonVille");
        campamento.setLocalizacion("Wyoming");
        campamento.setCantidadPersonas(127);
        realmCampamento = realm.copyToRealm(campamento);

        realm.commitTransaction();

        RealmQuery<Campamento> query = realm.where(Campamento.class);
        RealmResults<Campamento> result = query.findAll();

        Log.i("CAMPAMENTO","saved: " + result);


        queryCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campImage.setImageResource(R.drawable.jackson);
                infoCamp.setText(String.format("%s", realm.where(Campamento.class).equalTo("nombre", "JacksonVille").findAll()));
            }
        });

    }
}
