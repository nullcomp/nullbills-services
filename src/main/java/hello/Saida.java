package hello;

import java.util.Date;

public class Saida extends Movimento{
	private double valorSaida;
	
	Saida( double valorSaida, Date dataAgendada, Date dataExecucao, User userOwner){
		this.valorSaida = valorSaida;
		super.setDataAgendada(dataAgendada);
		super.setDataExecucao(dataExecucao);
		super.setUserOwner(userOwner);
	}

	public double getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(double valorSaida) {
		this.valorSaida = valorSaida;
	}

	
}
