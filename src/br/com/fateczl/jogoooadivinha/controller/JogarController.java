package br.com.fateczl.jogoooadivinha.controller;

import br.com.fateczl.jogoooadivinha.TelaVitoria;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JogarController implements OnClickListener {

	private EditText etNumero;
	private TextView tvTentativas;
	private Context contexto;
	private int numGerado;
	private int tentativas;
	
	public JogarController(int tentativas, int numGerado, Context contexto, EditText etNumero, TextView tvTentativas){
		this.etNumero = etNumero;
		this.tvTentativas = tvTentativas;
		this.contexto = contexto;
		this.numGerado = numGerado;
		this.tentativas = tentativas;
	}
	
	@Override
	public void onClick(View v) {
		jogar();
	}
	
	private void jogar(){
		try {
			int numJogador = Integer.parseInt(etNumero.getText().toString());
			if (numJogador >= 0 && numJogador <= 100){
				tentativas++;
				tvTentativas.setText(tentativas+" Tentativas");
				if (numJogador > numGerado){
					Toast.makeText(contexto, "O número é MENOR !!!", 
							Toast.LENGTH_SHORT).show();
				} else {
					if (numJogador < numGerado){
						Toast.makeText(contexto, "O número é MAIOR !!!", 
								Toast.LENGTH_SHORT).show();
					} else {
						vitoria();
					}
				}
			} else {
				Toast.makeText(contexto, "Digite um número entre 0 e 100", 
						Toast.LENGTH_LONG).show();
			}
		} catch (NumberFormatException e){
			Toast.makeText(contexto, "Digite um número entre 0 e 100", 
					Toast.LENGTH_LONG).show();
		}
	}

	private void vitoria() {
		Bundle parametros = new Bundle();
		parametros.putInt("tentativas", tentativas);
		parametros.putInt("numGerado", numGerado);
		Intent chamaVitoria = new Intent(contexto, TelaVitoria.class);
		chamaVitoria.putExtras(parametros);
		contexto.startActivity(chamaVitoria);
		((Activity)(contexto)).finish();
	}

}
