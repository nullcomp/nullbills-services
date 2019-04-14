package hello;

import java.util.Date;

public class nEntrada extends nMovimento {
	private double valorEntrada;
	
	nEntrada( double valorEntrada, Date dataAgendada, Date dataExecucao, nUser userOwner ){
		this.valorEntrada = valorEntrada;
		super.setDataAgendada(dataAgendada);
		super.setDataExecucao(dataExecucao);
		super.setUserOwner(userOwner);
	}

	public double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

}

