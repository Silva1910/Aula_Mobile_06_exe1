package com.fatec.zl.amos.aula_mobile_06_exe1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private EditText  etHoristaHora;
    private EditText etHoristaValor;
    private EditText etTitularAno;
    private EditText etTitularSalario;

    private TextView tvRes;
    private RadioButton rdHorista;
    private RadioButton  rdTitular;

    private Button btnCalc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etHoristaHora = findViewById(R.id.etHoristaHora);
        etHoristaHora.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etHoristaValor = findViewById(R.id.etHoristaValor);
        etHoristaValor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etTitularAno = findViewById(R.id.etTitularAno);
        etTitularAno.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etTitularSalario = findViewById(R.id.etTitularSalario);
        etTitularSalario.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        rdHorista = findViewById(R.id.rdHorista);

        rdTitular = findViewById(R.id.rdTitular);
        btnCalc = findViewById(R.id.btnCalc);


        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rdHorista) {
                    etHoristaHora.setEnabled(true);
                    etHoristaValor.setEnabled(true);
                    etTitularAno.setEnabled(false);
                    etTitularSalario.setEnabled(false);
                } else if (checkedId == R.id.rdTitular) {
                    etHoristaHora.setEnabled(false);
                    etHoristaValor.setEnabled(false);
                    etTitularAno.setEnabled(true);
                    etTitularSalario.setEnabled(true);
                }
            }
        });

        btnCalc.setOnClickListener(op ->main());
        }


    public void main() {
        String resultado = "";

        if (rdHorista.isChecked()) {
            // Se for selecionado o RadioButton de Horista
            ProfessorHorista pho = new ProfessorHorista();
            pho.setNome("amos");
            pho.setMatricula("3019");
            pho.setIdade(20);

            // Recuperando os valores dos EditTexts para o cálculo do salário do professor horista
            int horaTrabalhada = Integer.parseInt(etHoristaHora.getText().toString());
            double valorHora = Double.parseDouble(etHoristaValor.getText().toString());
            pho.setHorasAula(horaTrabalhada);
            pho.setValorHoraAula(valorHora);

            // Construindo a string com as informações do professor horista
            resultado = "Nome: " + pho.getNome() + "\n" +
                    "Matrícula: " + pho.getMatricula() + "\n" +
                    "Idade: " + pho.getIdade() + "\n" +
                    "Salário: " + pho.calcSalario();
        } else if (rdTitular.isChecked()) {
            // Se for selecionado o RadioButton de Titular
            ProfessorTitular pti = new ProfessorTitular();
            pti.setNome("silva");
            pti.setIdade(16);
            pti.setMatricula("1111");

            // Recuperando os valores dos EditTexts para o cálculo do salário do professor titular
            int anoContratacao = Integer.parseInt(etTitularAno.getText().toString());
            double salarioBase = Double.parseDouble(etTitularSalario.getText().toString());
            pti.setAnoInsituicao(anoContratacao);
            pti.setSalario(salarioBase);

            // Construindo a string com as informações do professor titular
            resultado = "Nome: " + pti.getNome() + "\n" +
                    "Matrícula: " + pti.getMatricula() + "\n" +
                    "Idade: " + pti.getIdade() + "\n" +
                    "Salário: " + pti.calcSalario();
        }

        // Definindo o resultado na TextView
        tvRes.setText(resultado);
    }

}