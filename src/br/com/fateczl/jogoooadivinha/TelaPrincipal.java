package br.com.fateczl.jogoooadivinha;

import br.com.fateczl.jogoooadivinha.controller.JogarController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

	private EditText etNumero;
	private TextView tvTentativas;
	private Button btnJogar;
	private int tentativas;
	private int numGerado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_principal);
		etNumero = (EditText) findViewById(R.id.etNumero);
		tvTentativas = (TextView) findViewById(R.id.tvTentativas);
		btnJogar = (Button) findViewById(R.id.btnJogar);
		
		tentativas = 0;
		numGerado = (int)((Math.random() * 101));
		View.OnClickListener jogar = new JogarController(tentativas, numGerado, TelaPrincipal.this, etNumero, tvTentativas);
		btnJogar.setOnClickListener(jogar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_principal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.menuPrincipalSair) {
			TelaPrincipal.this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
