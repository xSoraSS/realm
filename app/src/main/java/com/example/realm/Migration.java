package com.example.realm;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {

    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        /*******************************************************************************************
                                       // Version 1 \\

         class Campamento                   // añadir una nueva clase

         @Required
         String nombre;

         @Required
         String localizacion;

         int cantidadPersonas;

         ******************************************************************************************/

        // Migramos de la version 0 a la 1
        if (oldVersion == 0){
            // Creamos la nueva clase
            RealmObjectSchema campamentoSchema = schema.create("Campamento")
                    .addField("nombre", String.class, FieldAttribute.REQUIRED)
                    .addField("localizacion", String.class, FieldAttribute.REQUIRED)
                    .addField("cantidadPersonas", Integer.class, FieldAttribute.values());

            oldVersion++;
        }
    }
}
