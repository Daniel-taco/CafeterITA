package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Login extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Obtén las referencias de los EditTexts
        editTextEmail = findViewById(R.id.editText_Email);
        editTextPassword = findViewById(R.id.editText_Pass);

        // Configura un botón (puedes usar un botón o cualquier otro evento)
        Button buttonLogin = findViewById(R.id.btn_inicio);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        Button buttonRegister = findViewById(R.id.btn_registro);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }


    private void loginUser() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "El usuario ha iniciado sesión con éxito", Toast.LENGTH_SHORT).show();
                            // El usuario ha iniciado sesión con éxito.
                            // Puedes redirigirlo a la siguiente actividad o realizar otras acciones.
                        } else {
                            Toast.makeText(Login.this, "El inicio de sesión ha fallado. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            // El inicio de sesión ha fallado. Puedes obtener más información con task.getException().
                        }
                    }
                });
    }
    private void registerUser() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "El usuario se ha registrado con éxito", Toast.LENGTH_SHORT).show();
                            // El usuario se ha registrado con éxito.
                            // Puedes redirigirlo a la siguiente actividad o realizar otras acciones.
                        } else {
                            Toast.makeText(Login.this, "El registro ha fallado. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            // El registro ha fallado. Puedes obtener más información con task.getException().
                        }
                    }
                });
    }
}