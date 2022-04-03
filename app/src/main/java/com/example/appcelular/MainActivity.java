package com.example.appcelular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button nUm, nDois, nTres, nQuatro, nCinco, nSeis, nSete, nOito, nNove, nZero, opMais, opMenos, opMulti, opDiv, opIgual, ponto, limparTudo, limparDisplay;

    private TextView txtExpressao, txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IniciarComponentes();
        getSupportActionBar().hide();

        nZero.setOnClickListener(this);
        nUm.setOnClickListener(this);
        nDois.setOnClickListener(this);
        nTres.setOnClickListener(this);
        nQuatro.setOnClickListener(this);
        nCinco.setOnClickListener(this);
        nSeis.setOnClickListener(this);
        nSete.setOnClickListener(this);
        nOito.setOnClickListener(this);
        nNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        opMais.setOnClickListener(this);
        opMenos.setOnClickListener(this);
        opMulti.setOnClickListener(this);
        opDiv.setOnClickListener(this);

        limparTudo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        limparDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()) {

                    byte varZero = 0;
                    int varUm = string.length()-1;
                    String txtExpressao = string.substring(varZero,varUm);
                    expressao.setText(txtExpressao);
                }

                txtResultado.setText("");
            }
        });

        opIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                } catch (Exception e) {

                }

            }
        });

    }

    private void IniciarComponentes() {
        nZero = findViewById(R.id.num_zero);
        nUm = findViewById(R.id.num_um);
        nDois = findViewById(R.id.num_dois);
        nTres = findViewById(R.id.num_tres);
        nQuatro = findViewById(R.id.num_quatro);
        nCinco = findViewById(R.id.num_cinco);
        nSeis = findViewById(R.id.num_seis);
        nSete = findViewById(R.id.num_sete);
        nOito = findViewById(R.id.num_oito);
        nNove = findViewById(R.id.num_nove);
        nZero = findViewById(R.id.num_zero);
        opMais = findViewById(R.id.bt_soma);
        opMenos = findViewById(R.id.bt_menos);
        opMulti = findViewById(R.id.bt_multi);
        opDiv = findViewById(R.id.bt_divisao);
        opIgual = findViewById(R.id.bt_igual);
        ponto = findViewById(R.id.num_ponto);
        limparTudo = findViewById(R.id.bt_limpar);
        limparDisplay = findViewById(R.id.bt_limparDisplay);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_Resultado);

    }

    public void AcrescentarExpressao (String string, boolean limpar_dados) {
        if (txtResultado.getText().equals("")) {
            txtExpressao.getText();
        }

        if (limpar_dados == true) {
            txtResultado.setText("");
            txtExpressao.append(string);
        }
        else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.num_zero:
                AcrescentarExpressao("0",true);
                break;
            case R.id.num_um:
                AcrescentarExpressao("1",true);
                break;
            case R.id.num_dois:
                AcrescentarExpressao("2",true);
                break;
            case R.id.num_tres:
                AcrescentarExpressao("3",true);
                break;
            case R.id.num_quatro:
                AcrescentarExpressao("4",true);
                break;
            case R.id.num_cinco:
                AcrescentarExpressao("5",true);
                break;
            case R.id.num_seis:
                AcrescentarExpressao("6",true);
                break;
            case R.id.num_sete:
                AcrescentarExpressao("7",true);
                break;
            case R.id.num_oito:
                AcrescentarExpressao("8",true);
                break;
            case R.id.num_nove:
                AcrescentarExpressao("9",true);
                break;
            case R.id.num_ponto:
                AcrescentarExpressao(".",true);
                break;
            case R.id.bt_divisao:
                AcrescentarExpressao("/",false);
                break;
            case R.id.bt_igual:
                AcrescentarExpressao("=",true);
                break;
            case R.id.bt_menos:
                AcrescentarExpressao("-",false);
                break;
            case R.id.bt_multi:
                AcrescentarExpressao("*",false);
                break;
            case R.id.bt_soma:
                AcrescentarExpressao("+",false);
                break;
        }
    }
}