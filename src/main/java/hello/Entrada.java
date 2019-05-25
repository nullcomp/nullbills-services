package hello;

import java.util.Date;

public class Entrada extends Movimento {
	private double valorEntrada;
	
	Entrada( double valorEntrada, Date dataAgendada, Date dataExecucao, User userOwner ){
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

