package hello;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model{
	
	// Cria��o para o nulbiils
	ObjectContainer users = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/users.db4o");
	ObjectContainer Entrada = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/Entrada.db4o");
	ObjectContainer Saida = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/Saida.db4o");
	//
	

	
	// M�todo do projeto original modificado para ser usado no nullbills
	public boolean addUser(User user){
		
		    
			users.store(user);
			users.commit();
			//System.out.print("Usuario adicionado");
			return true;	
	}
	
	//
	// Classe modificada do projeto original para o projeto nullbuills
	public boolean isUserAvailable(String username){
			Query query = users.query();
			query.constrain(User.class);
		    ObjectSet<User> allusers = query.execute();
		    
		    for(User user:allusers){
		    	if(user.getUserName().equals(username)) return false;
		    }
		    
		    return true;
		}
	
	// M�todo alterado do programa original para o NullBills
	public ObjectSet<User> listAllusers(){
		
		Query query = users.query();
		query.constrain(User.class);
	    ObjectSet<User> allusers = query.execute();
		
	    /*for(Student student:allStudents){
	    	if(student.getRa()==ra){
	    		return student;
	    	}
	    	
	    }*/
	    
	    return allusers;
	}
	
	public User findUserByName(String name) {
		ObjectSet<User> allusers = this.listAllusers();
		for(User user: allusers) {
			if (user.getUserName().equals(name)) return user;
		}
		return null;
	}
	
	public boolean addEntrada(Entrada entrada) {
		Entrada.store(entrada);
		Entrada.commit();
		return true;
	}
	
	public ObjectSet<Entrada> listAllEntradas(){
		Query query = Entrada.query();
		query.constrain(Entrada.class);
		return query.execute();
	}
	

	public boolean addSaida(Saida saida) {
		Saida.store(saida);
		Saida.commit();
		return true;
	}
	
	public ObjectSet<Saida> listAllSaidas(){
		Query query = Saida.query();
		query.constrain(Saida.class);
		return query.execute();
	}
	//
}
	
