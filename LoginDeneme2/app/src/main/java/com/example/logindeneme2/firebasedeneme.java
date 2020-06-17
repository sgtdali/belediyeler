package com.example.logindeneme2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class firebasedeneme extends AppCompatActivity {
        EditText tv1;
        Button btn1;
        Button btn2;
        DatabaseReference databasehabler;
        ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebasedeneme);
        tv1=findViewById(R.id.tv1);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        img1=findViewById(R.id.img1);
        databasehabler= FirebaseDatabase.getInstance().getReference("haberler");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHaber();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databasehabler.child("1").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String haber=dataSnapshot.child("haber").getValue().toString();
                    tv1.setText(haber);
                        Picasso.with(getApplicationContext()).load(haber).into(img1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    public void addHaber(){
        String haber=tv1.getText().toString().trim();
        String id="haberler";
            haberler haberler=new haberler(haber);
            databasehabler.child("1").setValue(haberler);



    }




}
