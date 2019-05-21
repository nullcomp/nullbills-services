package hello;



import static spark.Spark.get;
import static spark.Spark.post;


import java.io.UnsupportedEncodingException;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.ObjectSet;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;


public class REST{
	
	private Model model;
	
	
	public REST(Model store){
		this.model = store;
	}
	
	
	// M�todo reescrito do projeto original para o NullBills
	public void setUser(){
			
			post("/User", new Route() {
				@Override
	            public Object handle(final Request request, final Response response){
		        	
		           response.header("Access-Control-Allow-Origin", "*");

		           Gson gson = new Gson();
		           
		           String json = request.body();
		           
		           
		           
		           User nuser = gson.fromJson(json, User.class);
		           
		           
		           
	         	    
	         	   try {
		            	
		            		boolean status = model.addUser(nuser);
		            		
		            		if(status){
		            			
		            			JSONArray jsonResult = new JSONArray();
			 	         	    JSONObject jsonObj = new JSONObject();
			     
				        		jsonObj.put("status", 1);
				        		
				        		
				             	jsonResult.put(jsonObj);
				             	
				             	
				             	
				             	return jsonResult;
		            		}
		            		
		            		
		            		
		            	
		            	
		            	
		             	
		        		} catch (JSONException e) {
		        				
		        			e.printStackTrace();
		        		}
	         	    
	         	    JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();
	         	   	
	         	    jsonObj.put("status", 0);
	        		
	        		
	             	jsonResult.put(jsonObj);
	             	
	             	return jsonResult;
	         	   
	         	   
		        	
			   }
			});     
		}
		//
	
	// M�todo reescrito do projeto original para o NullBills
	public void getUsers(){
			
			get("/Users", new Route() {
				@Override
	            public Object handle(final Request request, final Response response){
		        	
		        	 
		        	 
		        	response.header("Access-Control-Allow-Origin", "*");
		        	 
		        	//Integer ra = Integer.parseInt(request.params(":ra"));
		            
		            try {
		            	ObjectSet<User> allnUsers = model.listAllusers();
		            	
		            	JSONArray jsonResult = new JSONArray();
		         		  


		         	    
		         	   for(User nuser:allnUsers){
		         		  JSONObject jsonObj = new JSONObject();
		         		  jsonObj.put("Username", nuser.getUserName());
		         		  jsonObj.put("Password", nuser.getPassword());
		         		  jsonObj.put("email", nuser.geteMail());
		         		  jsonResult.put(jsonObj);
		       	    	}
		       	    	
		             	return jsonResult;
		             	
		        		} catch (JSONException e) {
		        				
		        			e.printStackTrace();
		        		}
		         	    	
		
		     	    return null;
		     	     
		         }
		         
		      });
			
			
		}

	
	public void returnOneUser() {
		get("/findUser", new Route( ) {
			@Override
			public Object handle(final Request request, final Response response) {
				
				response.header("Access-Control-Allow-Origin", "*");
				
				try {
	            	ObjectSet<User> allnUsers = model.listAllusers();
	            	
	            	String body = request.body();
	            	
	            	
	            	JSONObject jsonObj = new JSONObject();
	         	   	for(User nuser:allnUsers){
	         		  
	         		   String charlbro = request.body();
	         		   System.out.println(charlbro);
	         		   if (nuser.getUserName() == "Mateus Souza") {

	 	         		  
	 	         		  jsonObj.put("Username", nuser.getUserName());
	 	         		  jsonObj.put("Password", nuser.getPassword());
	 	         		  jsonObj.put("email", nuser.geteMail());
	 	         		    
	 	         		  response.status(200);
	         		   }
	       	    	}
	       	    	
	         	   		return jsonObj;
	         	   	
					} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
	         	    	
	
	     	    return null;
			}
		});
	}
	
	// Métodos para as entradas
	public void setEntrada(){
		
		post("/Entrada", new Route() {
			@Override
            public Object handle(final Request request, final Response response){
	        	
	           response.header("Access-Control-Allow-Origin", "*");

	           Gson gson = new Gson();
	           
	           String json = request.body();
	           
	           
	           
	           Entrada entrada = gson.fromJson(json, Entrada.class);
	           
	           
	           
         	    
         	   try {
	            	
	            		boolean status = model.addEntrada(entrada);
	            		
	            		if(status){
	            			
	            			JSONArray jsonResult = new JSONArray();
		 	         	    JSONObject jsonObj = new JSONObject();
		     
			        		jsonObj.put("status", 1);
			        		
			        		
			             	jsonResult.put(jsonObj);
			             	
			             	
			             	
			             	return jsonResult;
	            		}
	            		
	            		
	            		
	            	
	            	
	            	
	             	
	        		} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
         	    
         	    JSONArray jsonResult = new JSONArray();
         	    JSONObject jsonObj = new JSONObject();
         	   	
         	    jsonObj.put("status", 0);
        		
        		
             	jsonResult.put(jsonObj);
             	
             	return jsonResult;
         	   
         	   
	        	
		   }
		});     
	}

	public void getEntradas(){
		
		get("/Entradas", new Route() {
			@Override
            public Object handle(final Request request, final Response response){
	        	
	        	 
	        	 
	        	response.header("Access-Control-Allow-Origin", "*");
	        	 
	        	//Integer ra = Integer.parseInt(request.params(":ra"));
	            
	            try {
	            	ObjectSet<Entrada> allnEntradas = model.listAllEntradas();
	            	
	            	JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();

	         	    
	         	   for(Entrada entrada:allnEntradas){
	         		  jsonObj.put("dataAgendada", entrada.getDataAgendada());
	         		  jsonObj.put("dataExecucao", entrada.getDataExecucao());
	         		  jsonObj.put("usuario", entrada.getUserOwner());
	         		  jsonObj.put("valorEntrada", entrada.getValorEntrada());
	         		  jsonResult.put(jsonObj);
	       	    	}
	       	    	
	             	return jsonResult;
	             	
	        		} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
	         	    	
	
	     	    return null;
	     	     
	         }
	         
	      });
		
		
	}	
	
	// Métodos para as saidas
	
	public void setSaida(){
		
		post("/Saida", new Route() {
			@Override
            public Object handle(final Request request, final Response response){
	        	
	           response.header("Access-Control-Allow-Origin", "*");

	           Gson gson = new Gson();
	           
	           String json = request.body();
	           
	           
	           
	           Saida saida = gson.fromJson(json, Saida.class);
	           
	           
	           
         	    
         	   try {
	            	
	            		boolean status = model.addSaida(saida);
	            		
	            		if(status){
	            			
	            			JSONArray jsonResult = new JSONArray();
		 	         	    JSONObject jsonObj = new JSONObject();
		     
			        		jsonObj.put("status", 1);
			        		
			        		
			             	jsonResult.put(jsonObj);
			             	
			             	
			             	
			             	return jsonResult;
	            		}
	            		
	            		
	            		
	            	
	            	
	            	
	             	
	        		} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
         	    
         	    JSONArray jsonResult = new JSONArray();
         	    JSONObject jsonObj = new JSONObject();
         	   	
         	    jsonObj.put("status", 0);
        		
        		
             	jsonResult.put(jsonObj);
             	
             	return jsonResult;
         	   
         	   
	        	
		   }
		});     
	}

	public void getSaidas(){
		
		get("/Saidas", new Route() {
			@Override
            public Object handle(final Request request, final Response response){
	        	
	        	 
	        	 
	        	response.header("Access-Control-Allow-Origin", "*");
	        	 
	        	//Integer ra = Integer.parseInt(request.params(":ra"));
	            
	            try {
	            	ObjectSet<Saida> allnSaidas = model.listAllSaidas();
	            	
	            	JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();

	         	    
	         	   for(Saida saida:allnSaidas){
	         		  jsonObj.put("dataAgendada", saida.getDataAgendada());
	         		  jsonObj.put("dataExecucao", saida.getDataExecucao());
	         		  jsonObj.put("usuario", saida.getUserOwner());
	         		  jsonObj.put("valorEntrada", saida.getValorSaida());
	         		  jsonResult.put(jsonObj);
	       	    	}
	       	    	
	             	return jsonResult;
	             	
	        		} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
	         	    	
	
	     	    return null;
	     	     
	         }
	         
	      });
		
	}
}
	
	
