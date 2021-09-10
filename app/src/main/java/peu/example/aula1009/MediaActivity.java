package peu.example.aula1009;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediaActivity extends AppCompatActivity {

    EditText txtNota1;
    EditText txtNota2;
    Button btnCalcular;
    TextView lblMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblMedia = findViewById(R.id.lblMedia);

        btnCalcular.setOnClickListener( new EscutadorBotaoCalcular() );
    }

    class EscutadorBotaoCalcular implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // Criando variáveis:
            double nota1, nota2, media;

            // Pegando os valores nas caixas:
            nota1 = Double.parseDouble( txtNota1.getText().toString() );
            nota2 = Double.parseDouble( txtNota2.getText().toString() );

            // Calculando a média:
            media = (nota1+nota2)/2;

            // Colocando a média em lblMedia:
            lblMedia.setText( String.valueOf(media) );
        }
    }
}