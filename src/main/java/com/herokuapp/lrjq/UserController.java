package com.herokuapp.lrjq;

import spark.Spark;



import com.google.gson.Gson;
import com.herokuapp.lrjq.beans.Usuario;import com.herokuapp.lrjq.dao.GenericDAO;
import com.herokuapp.lrjq.dao.UsuarioMockDAOImpl;


public class UserController {
	
	private GenericDAO<Usuario> dao;
	
	public UserController() {
		dao = new UsuarioMockDAOImpl();
	}
	
	public static void initRoutes(){
		UserController controller = new UserController();
		Gson gson = new Gson();
		
		Spark.post("/user",  (request, response) -> {
			Usuario usuario = null;
			try {
				usuario = gson.fromJson(request.body(), Usuario.class);
			} catch (Exception e) {
				response.status(400);
				return "JSON INVALIDO";
			}
			
			if(null==controller.validar(usuario)){
				response.status(403);
				response.body("ACESSO NAO PERMITIDO");
				return "ACESSO NAO PERMITIDO";
			}

			return gson.toJson(usuario);
		});
		
		Spark.post("/incuser",  (request, response) -> {
			Usuario usuario = null;
			try {
				usuario = gson.fromJson(request.body(), Usuario.class);
				usuario = controller.dao.inc(usuario);
			} catch (Exception e) {
				response.status(400);
				return "JSON INVALIDO";
			}

			return gson.toJson(usuario);
		});
	}
	
	private Usuario validar(Usuario usuario){
		if("bangomc@gmail.com".equals(usuario.getEmail()) && "123".equals(usuario.getSenha())){
			usuario.setNome("Cristhiano");
			return usuario;
		}
		return null;
	}
}
