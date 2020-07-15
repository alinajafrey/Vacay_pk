package com.example.vacay_pk;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registeration extends AppCompatActivity {
    Button Reg,Login;
    FirebaseAuth firebaseAuth;
    String User;
    FirebaseDatabase database;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        Reg=findViewById(R.id.registerBtn);
        Login=findViewById(R.id.sbutton);
        firebaseAuth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        mDatabase = database.getReference().child("Users");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent i = new Intent(getApplicationContext(), Loginn.class);
                startActivity(i);

            }
        });
        Reg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final EditText user = findViewById(R.id.Reg_name);
                EditText mail = findViewById(R.id.Reg_email);
                EditText pass = findViewById(R.id.Reg_password);
                User= user.getText().toString();
                String Email= mail.getText().toString();
                String Pass = pass.getText().toString();
                if (User.isEmpty() && Email.isEmpty() && Pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "All Fields Empty",Toast.LENGTH_SHORT).show();
                }
                else if(User.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Name Field Empty",Toast.LENGTH_SHORT).show();
                }
                else if(Email.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Email Field Empty",Toast.LENGTH_SHORT).show();
                }
                else if (Pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Password Field Empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    firebaseAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(Registeration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Registeration.this.getApplicationContext(), "SignUp unsuccessful: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
// ...

                                Log.d("uidf",firebaseAuth.getUid());
                                writeNewUser( firebaseAuth.getUid(),User);

                            }
                        }
                    });

                }
            }

        });
    }

    private void writeNewUser(String userId, String name) {
        // Users user = new Users(name);
        mDatabase.child(userId).setValue(name);
        Intent i = new Intent(getApplicationContext(), Loginn.class);
        startActivity(i);
    }

}

