package com.example.realm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    Personaje realmPersonaje;
    Personaje personaje = new Personaje();
    Button insertButton, deleteButton, queryButton, updateButton, campButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("tlourealm.realm")
                .schemaVersion(0)
                .migration(new Migration())
                .deleteRealmIfMigrationNeeded()
                .build();

        realm = Realm.getInstance(config);
//        Realm.setDefaultConfiguration(config);

        insertButton = findViewById(R.id.insert);
        updateButton = findViewById(R.id.update);
        deleteButton = findViewById(R.id.delete);
        queryButton = findViewById(R.id.query);
        campButton = findViewById(R.id.camp);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EliminarPersonaje.class);
                startActivity(intent);
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, BuscarPersonaje.class);
            startActivity(intent);
        }
        });

        campButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuscarCampamento.class);
                startActivity(intent);            }
        });
    }

    private void update() {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.copyToRealmOrUpdate(personaje).setInfo("Ellie nació en algún momento en el tardío 2020, siete años después de la expansión de la epidemia por Cordyceps. Como resultado, creció en una opresiva zona de cuarentena en Boston, Massachusetts, con poco conocimiento del mundo anterior a la infección. ");

        realm.commitTransaction();

        RealmQuery<Personaje> query = realm.where(Personaje.class);
        RealmResults<Personaje> result = query.findAll();

        Log.i("PERSONAJE","saved: " + result);
    }

    public void insert(){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        personaje.setName("Joel");
        personaje.setAge(50);
        personaje.setId(personaje.getName() + personaje.getAge() + (personaje.getAge()*2/3));
        personaje.setInfo("Joel nació el 26 de septiembre, muy probablemente entre 1984 y 1985, y creció en Texas junto a su hermano menor Tommy. Joel crió a Tommy durante su infancia, con lo que la pareja tuvo grandes dificultades.");
        realmPersonaje = realm.copyToRealm(personaje);

        personaje.setName("Ellie");
        personaje.setAge(19);
        personaje.setId(personaje.getName() + personaje.getAge() + (personaje.getAge()*2/3));

        realmPersonaje = realm.copyToRealm(personaje);

        realm.commitTransaction();

        RealmQuery<Personaje> query = realm.where(Personaje.class);
        RealmResults<Personaje> result = query.findAll();

        Log.i("PERSONAJE","saved: " + result);
    }
}
