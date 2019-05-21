package hello;

import static spark.Spark.*;
import java.util.Date;

public class MainServer {

	final static Model model = new Model();

    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        port(port);

		
        
        initializeModel();
		
        
		
		staticFileLocation("/static");
		
		REST controller = new REST(model); 
		
		// rests do NullBills inicializados
		controller.setUser();
		controller.getUsers();
		controller.returnOneUser();
		
		
		controller.setEntrada();
		controller.getEntradas();
		
		controller.setSaida();
		controller.getSaidas();

    }
	
    public static void initializeModel(){
    	
		model.addUser(new User("Mateus Souza", "senha", "mateus@fatec.sp.gov.br"));
		
    	//model.addEntrada(new Entrada(1200, new Date(), new Date(), model.findUserByName("Mateus Souza") ) );
    	//model.addEntrada(new Entrada(1500, new Date(), new Date(), model.findUserByName("Mateus Souza") ) );
    	
    	//model.addSaida(new Saida(1500, new Date(), new Date(), model.findUserByName("Mateus Souza")));
    	//model.addSaida(new Saida(1800, new Date(), new Date(), model.findUserByName("Mateus Souza")));

    	
	}
	
}
