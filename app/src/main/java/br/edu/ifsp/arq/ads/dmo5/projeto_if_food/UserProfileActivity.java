package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class UserProfileActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    private TextInputEditText txtNome;
    private TextInputEditText txtSobrenome;
    private TextInputEditText txtEmail;
    private Spinner spnFuncao;
    private TextInputEditText txtTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        setToolBar();
        setComponentes();
    }



    public void setComponentes(){
        txtNome = findViewById(R.id.txt_inp_pro_nome);
        txtSobrenome =findViewById(R.id.txt_inp_pro_sobrenome);
        txtEmail = findViewById(R.id.txt_inp_pro_email);
        spnFuncao = findViewById(R.id.sp_funcao);
        txtTelefone = findViewById(R.id.txt_inp_pro_phone);
    }

    private boolean validaDados() {
        boolean isValid = true;
        if(txtNome.getText().toString().trim().isEmpty()){
            txtNome.setError("Preencha o nome");
            isValid = false;
        }else{
            txtNome.setError(null);
        }
        if(txtSobrenome.getText().toString().trim().isEmpty()){
            txtSobrenome.setError("Preencha o sobrenome");
            isValid = false;
        }else{
            txtSobrenome.setError(null);
        }
        if(txtEmail.getText().toString().trim().isEmpty()){
            txtEmail.setError("Preencha o e-mail");
            isValid = false;
        }else{
            txtEmail.setError(null);
        }
        if(txtTelefone.getText().toString().trim().isEmpty()){
            txtTelefone.setError("Preencha o telefone");
            isValid = false;
        }else{
            txtTelefone.setError(null);
        }
        return isValid;
    }
    private void setToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTitle = findViewById(R.id.toolbar_title);
        txtTitle.setText(getString(R.string.perfil_titulo));
    }

}