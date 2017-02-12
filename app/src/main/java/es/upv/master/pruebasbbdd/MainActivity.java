package es.upv.master.pruebasbbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("mensaje");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d("Ejemplo Firebase", "Valor: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("Ejemplo Firebase", "Error al leer.", error.toException());
            }
        });
    }

    public void graba(View v) {

        myRef = database.getReference("mensaje 3");
        myRef.setValue("con modo avión");
    }

    public void graba2(View v) {
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("mensaje 4");
        myRef.setValue("no llego");
    }
}
