package hello;
import java.util.Date;
 
abstract class Movimento {
	
	private Date dataAgendada;
	private Date dataExecucao;
	private User userOwner;
	
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
	public User getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}
	
	
}
