package hello;
import java.util.Date;
 
abstract class nMovimento {
	
	private Date dataAgendada;
	private Date dataExecucao;
	private nUser userOwner;
	
	// get e set
	public Date getDataAgendada() {
		return dataAgendada;
	}
	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}
	public Date getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	public nUser getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(nUser userOwner) {
		this.userOwner = userOwner;
	}
	
	
}
