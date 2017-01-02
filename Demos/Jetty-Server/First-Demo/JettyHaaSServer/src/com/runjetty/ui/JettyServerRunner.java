package com.runjetty.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.haas.server.main.Main;
import com.runjetty.server.JettyServer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

public class JettyServerRunner extends AnchorPane {

	@FXML
	Button bMainToggleServer;

	JettyServer jettyServer;

	public JettyServerRunner(final JettyServer jettyServer) {
		// TODO Auto-generated constructor stub

		this.jettyServer = jettyServer;
		// ----------------------Loading FXML File
		// ------------------------------
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/haas/server/cfg/server_runner.fxml"));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();

			// ChatServer.primaryStage.setResizable(false);
			Main.primaryStage.setTitle("Toggle Server Status");
			Main.primaryStage.setWidth(200);
			Main.primaryStage.setHeight(670);
		} catch (IOException ex) {
			Logger.getLogger(JettyServerRunner.class.getName()).log(Level.SEVERE, null, ex);
		}

		// --------------------Toggle Button Action
		// --------------------------------------------
		bMainToggleServer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (jettyServer.isStarted()) {
					try {
						jettyServer.stop();
						bMainToggleServer.setText("Stopped");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (jettyServer.isStopped()) {
					try {
						jettyServer.start();
						bMainToggleServer.setText("Started");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				if (jettyServer.isStarted()) {
					try {
						jettyServer.stop();
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		}, "Stop Jetty Hook"));

		Main.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override public void handle(WindowEvent t) {
		        System.out.println("CLOSING");
		        try {
					jettyServer.stop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
	}

	public Button getbMainToggleServer() {
		return bMainToggleServer;
	}

	public void setbMainToggleServer(Button bMainToggleServer) {
		this.bMainToggleServer = bMainToggleServer;
	}

	
}
