package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

import Models.Usuario;

public class UserRegisterActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextInputEditText txtNome;
    private TextInputEditText txtSobreome;
    private TextInputEditText txtEmail;
    private TextInputEditText txtSenha;
    private Button btnRegistra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
    }

    private boolean validate() {
        boolean isValid = true;
        if(txtNome.getText().toString().trim().isEmpty()){
            txtNome.setError("Preencha o campo do nome");
            isValid = false;
        }else{
            txtNome.setError(null);
        }
        if(txtEmail.getText().toString().trim().isEmpty()){
            txtEmail.setError("Preencha o campo do e-mail");
            isValid = false;
        }else{
            txtEmail.setError(null);
        }
        if(txtSenha.getText().toString().trim().isEmpty()){
            txtSenha.setError("Preencha o campo da senha");
            isValid = false;
        }else{
            txtSenha.setError(null);
        }
        return isValid;
    }


}