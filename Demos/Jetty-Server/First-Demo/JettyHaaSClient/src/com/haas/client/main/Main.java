package com.haas.client.main;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	static URI url = null;

	public static Stage primaryStage;
	public static Scene scene;

	

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));

			Scene scene = new Scene(new ServiceGetter(), 400, 400);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.scene = scene;
			primaryStage.setScene(scene);
			primaryStage.setWidth(600);
			primaryStage.setHeight(400);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void getValuesUsingGet(String userEmail) {
		try {
			url = new URI("http://localhost:8585/runJetty/service/medicine/getUserMedicines?userEmail=" + userEmail);
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(url);
			String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println(response);

		} catch (URISyntaxException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void getValuesUsingPost() {
		try {
			MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
			map.add("firstName", "El-Said");
			map.add("lastName", "El-Shall");
			Form form = new Form(map);

			url = new URI("http://localhost:8084/RESTFulWebApp/service/service/saluteEmp");
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(url);

			Response response = target.request(MediaType.APPLICATION_XML).post(Entity.form(form));

			System.out.println(response.readEntity(String.class));

		} catch (URISyntaxException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
