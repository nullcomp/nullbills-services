package hello;

public class User {
	private String userName;
	private String password;
	private String eMail;
	private float Montante;
	// Constructor 
	User(String userName, String password, String eMail, float montante){
		if (userName.isEmpty() || password.isEmpty() || eMail.isEmpty()) return;
		this.userName = userName;
		this.password = password;
		this.eMail = eMail;
		this.Montante = montante;
	}
	
	// Getters and Setters

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public void setMontante(float montante) {
		this.Montante = montante;
	}
	
	public float getMontante() {
		return this.Montante;
	}
	
}
