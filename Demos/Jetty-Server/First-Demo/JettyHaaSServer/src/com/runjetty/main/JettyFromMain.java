package com.runjetty.main;

import java.awt.EventQueue;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import com.runjetty.context.AppContextBuilder;
import com.runjetty.server.JettyServer;
import com.runjetty.ui.ServerRunner;

public class JettyFromMain {

	public static void main(String[] args) {
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		
		contexts.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext()});
		
		final JettyServer jettyServer = new JettyServer();
		jettyServer.setHandler(contexts);
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				new ServerRunner(jettyServer);
			}
		};
		EventQueue.invokeLater(runner);
	}
}
