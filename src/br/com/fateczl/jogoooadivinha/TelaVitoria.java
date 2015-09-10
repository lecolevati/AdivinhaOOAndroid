package br.com.fateczl.jogoooadivinha;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TelaVitoria extends AppCompatActivity {

	private TextView tvResultadoFinal;
	private Bundle parametros;
	private Intent intent;
	private int numGerado;
	private int tentativas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_vitoria);
		
		tvResultadoFinal = (TextView) findViewById(R.id.tvResultadoFinal);
		resultado();
	}

	private void resultado() {
		intent = getIntent();
		parametros = intent.getExtras();
		if (parametros != null){
			tentativas = parametros.getInt("tentativas");
			numGerado = parametros.getInt("numGerado");
			StringBuffer sb = new StringBuffer();
			sb.append("PARABÉNS !!!\n");
			sb.append("Você acertou o número ");
			sb.append(numGerado);
			sb.append("\ncom ");
			sb.append(tentativas);
			sb.append(" tentativas");
			tvResultadoFinal.setText(sb.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_vitoria, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.menuVitoriaVoltar) {
			Intent chamaPrincipal = new Intent(this, TelaPrincipal.class);
			this.startActivity(chamaPrincipal);
			return true;
		} else {
			if (id == R.id.menuVitoriaSair) {
				TelaVitoria.this.finish();
			}
		}
		return super.onOptionsItemSelected(item);
	}
}
