package com.example.vacay_pk;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Loginn extends AppCompatActivity
{
    Button Btn;
    Button Btn1;
    FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    String Name;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_loginn);
        Btn=findViewById(R.id.loginBtn);
        Btn1=findViewById(R.id.Reg);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), Registeration.class);
                startActivity(i);

            }
        });
        Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText Username = findViewById(R.id.Login_email);
                EditText Pass     = findViewById(R.id.login_pass);
                String userEmail = Username.getText().toString();
                String userPaswd = Pass.getText().toString();
                if (userEmail.isEmpty()) {
                    Username.setError("Provide your Email first!");
                    Username.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    Pass.setError("Enter Password!");
                    Pass.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(Loginn.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd)
                            .addOnCompleteListener(Loginn.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Loginn.this, "Not successfull", Toast.LENGTH_SHORT).show();
                            } else {
                                mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
                                mDatabase.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        Name = dataSnapshot.child(firebaseAuth.getUid()).getValue(String.class);
                                        Intent i = new Intent(getApplicationContext(), screen4.class);
                                        i.putExtra("username",Name);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        Toast.makeText(Loginn.this, "Error:"+databaseError.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                } else {
                    Toast.makeText(Loginn.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }


}