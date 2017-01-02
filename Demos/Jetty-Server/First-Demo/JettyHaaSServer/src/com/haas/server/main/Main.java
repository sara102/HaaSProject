package com.haas.server.main;

import java.awt.EventQueue;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import com.runjetty.context.AppContextBuilder;
import com.runjetty.server.JettyServer;
import com.runjetty.ui.JettyServerRunner;
import com.runjetty.ui.ServerRunner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static Stage primaryStage;
	public static Scene scene;

	
	JettyServerRunner jettyServerRunner;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.scene = scene;
			this.primaryStage = primaryStage;
			//-------------------------------------------------------------------------------------------------
			ContextHandlerCollection contexts = new ContextHandlerCollection();
			
			contexts.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext()});
			
			final JettyServer jettyServer = new JettyServer();
			jettyServer.setHandler(contexts);
			jettyServer.stop();
			jettyServerRunner = new JettyServerRunner(jettyServer);
			
			Runnable runner = new Runnable() {
				@Override
				public void run() {
					jettyServerRunner = new JettyServerRunner(jettyServer);
				}
			};
			EventQueue.invokeLater(runner);
			
			//-------------------------------------------------------------------------------------------------

//			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(jettyServerRunner, 400, 400);
			this.scene= scene;
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			this.primaryStage.setScene(scene);
			this.primaryStage.setWidth(650.0);
	        this.primaryStage.setHeight(650.0);
			this.primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
