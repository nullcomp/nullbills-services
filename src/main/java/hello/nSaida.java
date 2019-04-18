package hello;

import java.util.Date;

public class nSaida extends nMovimento{
	private double valorSaida;
	
	nSaida( double valorSaida, Date dataAgendada, Date dataExecucao, nUser userOwner){
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
