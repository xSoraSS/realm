package com.example.realm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmResults;

public class EliminarPersonaje extends AppCompatActivity {

    Button deleteJoel, deleteEllie;
    Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteJoel = findViewById(R.id.deleteJoel);
        deleteEllie = findViewById(R.id.deleteEllie);

        deleteJoel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmResults<Personaje> result = realm.where(Personaje.class).equalTo("name", "Joel").findAll();
                        result.deleteAllFromRealm();
                        RealmResults<Personaje> query = realm.where(Personaje.class).findAll();
                        Log.i("PERSONAJE","saved: " + query);
                    }
                });
            }
        });

        deleteEllie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmResults<Personaje> result = realm.where(Personaje.class).equalTo("name", "Ellie").findAll();
                        result.deleteAllFromRealm();
                        RealmResults<Personaje> query = realm.where(Personaje.class).findAll();
                        Log.i("PERSONAJE","saved: " + query);
                    }
                });
            }
        });
    }
}
