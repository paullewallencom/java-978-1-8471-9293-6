package samples;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class OrderSystem implements Runnable {
	protected Thread worker;
	private ServerContext serverContext;
	private String scriptId = null;
	private String name;
	private String address;
	private String creditCardNumber;
	private String expiryDate;

	public OrderSystem(String name, String address, String creditCardNumber,
			String expiryDate) {
		this.name = name;
		this.address = address;
		this.creditCardNumber = creditCardNumber;
		this.expiryDate = expiryDate;
		WebContext webContext = WebContextFactory.get();
		ServletContext servletContext = webContext.getServletContext();

		serverContext = ServerContextFactory.get(servletContext);

		// A bit nasty: the call to serverContext.getScriptSessionsByPage()
		// below could fail because the system might need to read web.xml which
		// means it needs a ServletContext, which is only available using
		// WebContext, which in turn requires a DWR thread. We can cache the
		// results simply by calling this in a DWR thread, as we are now.
		webContext.getScriptSessionsByPage("");

		scriptId = webContext.getScriptSession().getId();
		worker = new Thread(this, "OrderSystem");
		worker.start();
	}

	public void run() {
		String returnFromOrderSystem = "";
		try {
			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
			props.setProperty("queue.DWROrderQueue", "DWROrderQueue");
			props.setProperty("queue.DWROrderConfirmationQueue",
					"DWROrderConfirmationQueue");
			javax.naming.Context ctx = new InitialContext(props);
			ConnectionFactory connectionFactory = (ConnectionFactory) ctx
					.lookup("ConnectionFactory");
			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Destination destination = (Destination) ctx.lookup("DWROrderQueue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			String orderMessage = "Order from: " + name + "," + address + ","
					+ creditCardNumber + "," + expiryDate
					+ ". Please return order ID.";
			String receiverQName = "DWROrderConfirmationQueue";
			orderMessage = "ReceiverQueue: " + receiverQName + "||  "
					+ orderMessage;
			TextMessage message = session.createTextMessage(orderMessage);
			producer.send(message);
			Destination receiveDestination = (Destination) ctx
					.lookup(receiverQName);
			MessageConsumer consumer = session
					.createConsumer(receiveDestination);
			TextMessage returnMessage = (TextMessage) consumer.receive(60000);
			if (returnMessage == null) {
				returnFromOrderSystem = "<p><font color=\"red\">Order confirmation not received. Please contact administrator.</font></p>";
			} else {
				returnFromOrderSystem = "<p><font color=\"green\">Order confirmation received. Order ID: "
						+ returnMessage.getText() + ".</font></p>";
			}
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collection<ScriptSession> sessions = serverContext
				.getAllScriptSessions();
		for (Iterator<ScriptSession> iterator = sessions.iterator(); iterator
				.hasNext();) {
			ScriptSession scriptSession = iterator.next();
			if (scriptSession.getId().equals(scriptId)) {
				ScriptBuffer script = new ScriptBuffer("orderProcessed('"
						+ returnFromOrderSystem + "')");
				scriptSession.addScript(script);
			}
		}
	}
}
