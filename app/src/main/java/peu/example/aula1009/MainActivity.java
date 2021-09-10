package peu.example.aula1009;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Recupera objeto inflador do menu
        MenuInflater inflater = getMenuInflater();

        //infla o menu
        inflater.inflate(R.menu.menu_meu_activity, menu);

        return true;
    }

    //método que é chamando quando usuario clica em um dos itens do optionsMenu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Precisamos identificar qual item do menu foi clicado.
        // Fazemos isso recuperando o ID do item:
        switch (item.getItemId()) {

            case R.id.mnuMedia:

                // Toast só pra testar...
                //Toast.makeText(getApplicationContext(), "Clicou em Calcular Média",
                //        Toast.LENGTH_SHORT).show();
                //return true;

                // Abrindo a MediaActivity:
                Intent i1 = new Intent(getApplicationContext(), MediaActivity.class);
                startActivity(i1);
                return true;

            // não precisa break porque já estamos retornando daqui.

            case R.id.mnuFechar:

                // Toast só pra testar...
                //Toast.makeText(getApplicationContext(), "Clicou em Fechar App",
                //        Toast.LENGTH_SHORT).show();
                //return true;

                // Construindo uma caixa de diálogo vazia:
                AlertDialog.Builder dialogo = new AlertDialog.Builder( MainActivity.this );

                // Definindo o titulo da caixa de diálogo:
                dialogo.setTitle( "FECHANDO O APP" );

                // Definindo o texto principal:
                dialogo.setMessage( "Deseja mesmo fechar o app ?" );

                // Definindo o botão de ação positiva, e seu objeto escutador:
                dialogo.setPositiveButton( "Fechar o app", new EscutadorDialogoOK() );

                // Definindo o botão de ação negativa, e seu objeto escutador:
                dialogo.setNegativeButton( "Cancelar", new EscutadorDialogoCancela() );

                // Proibindo que o usuário clique fora da caixa de diálogo.
                // O usuário vai ser obrigado a fazer uma escolha!
                dialogo.setCancelable( false );

                // Finalmente criando o objeto visual da caixa de diálogo, e exibindo na tela:
                dialogo.create();
                dialogo.show();


                // não precisa break porque já estamos retornando daqui.
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    // Classe interna do objeto escutador do botão "negativo" (cancela)
    // da caixa de diálogo:
    private class EscutadorDialogoCancela implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
            // Cancelando a caixa de diálogo:
            dialogInterface.cancel();
            // Mostra toast informativo:
            Toast.makeText(MainActivity.this, "Cancelando...", Toast.LENGTH_SHORT).show();
        }
    }

    // Classe interna do objeto escutador do botão "positivo" (sim, feche o app!)
    // da caixa de diálogo:
    private class EscutadorDialogoOK implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
            // Finaliza a activity:
            //finish(); //isso só fecha mas ainda roda
            System.exit(i); //isso fecha o app definitivo

            // Mostra toast informativo:
            Toast.makeText(MainActivity.this, "Saindo...", Toast.LENGTH_SHORT).show();
        }
    }
}