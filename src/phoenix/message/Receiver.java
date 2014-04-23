package phoenix.message;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class Receiver implements MessageListener {
	private boolean stop = false;

	public void receive() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			// prompt for JNDI names
			System.out.println("Enter ConnectionFactory name:");
			String factoryName = reader.readLine();
			System.out.println("Enter Destination name:");
			String destinationName = reader.readLine();
			reader.close();
			// look up administered objects
			InitialContext initContext = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) initContext
					.lookup(factoryName);
			Destination destination = (Destination) initContext
					.lookup(destinationName);
			initContext.close();
			// craten JMS object
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageConsumer receiver = session.createConsumer(destination);
			receiver.setMessageListener(this);
			connection.start();
			// wait for stopping
			while (stop) {
				Thread.sleep(1000);
			}
			// Exit
			System.out.println("Exiting...");
			connection.close();
			System.out.println("Good Bye!");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			String msgText = ((TextMessage) message).getText();
			System.out.println(msgText);
			if ("stop".equals(msgText)) {
				stop = true;
			}
		} catch (JMSException jex) {
			jex.printStackTrace();
			stop = true;
		}
	}

	// main function
	public static void main(String[] args) {
		new Receiver().receive();
	}

}
