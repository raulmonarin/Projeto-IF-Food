package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PaymentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;

    private Spinner spnPagamento;
    private TextInputEditText txtNumero;
    private TextInputEditText txtDataValidade;
    private TextInputEditText txtCodigo;
    private Button btnPagamento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setToolBar();
        setComponentes();
        setBtnPagamento();
    }

    private void setComponentes(){
        spnPagamento = findViewById(R.id.sp_pagamento);
        txtNumero =findViewById(R.id.txt_inp_pay_number);
        txtDataValidade = findViewById(R.id.txt_inp_pay_date);
        txtCodigo = findViewById(R.id.txt_inp_pay_cvv);
        btnPagamento = findViewById(R.id.btn_close_order);

    }

    private void setToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTitle = findViewById(R.id.toolbar_title);
        txtTitle.setText(getString(R.string.pagamento_titulo));
    }

    private void setBtnPagamento() {
        btnPagamento = findViewById(R.id.btn_close_order);
        btnPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this,
                        MainActivity.class);
                startActivity(intent);
                Toast.makeText(PaymentActivity.this, "Pedido Realizado!", Toast.LENGTH_SHORT).show();
            }
        });
    }




}