package com.herokuapp.lrjq;

import spark.Spark;

public class App {

	public static void main(String[] args) {
		
		Spark.port(Integer.valueOf(System.getenv("PORT")));
		Spark.staticFileLocation("/public");
		
		Spark.get("/ping", (request, response) -> "pong");
		
		Spark.before((request,response)->{
    		response.header("Access-Control-Allow-Origin", "*");
    	});

		NavegacaoController.initRoutes();
		UserController.initRoutes();
	}
}
