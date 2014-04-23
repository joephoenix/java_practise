package phoenix.message;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class Sender {
	// main function for use and send
	public void send() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			// prompt for JNDI names
			System.out.println("Enter ConnectionFactory name:");
			String factoryName = reader.readLine();
			System.out.println("Enter Destination name:");
			String destinationName = reader.readLine();
			// Look up administered objects
			InitialContext initContext = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) initContext
					.lookup(factoryName);
			Destination destination = (Destination) initContext
					.lookup(destinationName);
			initContext.close();
			// create JMS object
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer sender = session.createProducer(destination);
			// send Message
			String messageText = null;
			while (true) {
				System.out.println("Enter message to send or 'quit'");
				messageText = reader.readLine();
				if (messageText.equalsIgnoreCase("quit")) {
					break;
				}
				TextMessage message = session.createTextMessage(messageText);
				sender.send(message);
			}
			// Exit
			System.out.println("Exiting...");
			reader.close();
			connection.close();
			System.out.println("Good Bye!");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// main function for execute!
	public static void main(String[] args) {
		new Sender().send();
	}
}
