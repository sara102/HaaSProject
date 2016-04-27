package com.haas.client.main;

import java.io.IOException;
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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ServiceGetter extends AnchorPane{

	static URI url;

	@FXML
	Button bGetUserMedicines;
	@FXML
	TextField etUserEmail;
	public ServiceGetter() {
		// TODO Auto-generated constructor stub
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/haas/client/main/Client.fxml"));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();

			Main.primaryStage.setTitle("Get Medicines");
			Main.primaryStage.setWidth(600);
			Main.primaryStage.setHeight(400);
			
			
			bGetUserMedicines.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("you clicked me ");
					String userEmail = etUserEmail.getText().toString();
					getValuesUsingGet(userEmail);
				}
			});
		} catch (IOException ex) {
			Logger.getLogger(ServiceGetter.class.getName()).log(Level.SEVERE, null, ex);
		}

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
