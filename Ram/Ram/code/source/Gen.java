

// -----( IS Java Code Template v1.2
// -----( CREATED: 2002-06-22 12:15:15 GMT+05:30
// -----( ON-HOST: mdsep

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import import com.wm.app.b2b.server.dispatcher.Configurator;
import import com.wm.app.b2b.server.dispatcher.comms.CommsFactory;
import import com.wm.app.b2b.server.dispatcher.comms.BrokerTransportFactory;
// --- <<IS-END-IMPORTS>> ---

public final class Gen

{
	// ---( internal utility methods )---

	final static Gen _instance = new Gen();

	static Gen _newInstance() { return new Gen(); }

	static Gen _cast(Object o) { return (Gen)o; }

	// ---( server methods )---




	public static final void Jdbc (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Jdbc)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		String connectionString = "jdbc:microsoft:sqlserver://localhost:1433;user=wm;password=wm;DatabaseName=DB_WM";
		conn = DriverManager.getConnection(connectionString, user, passwd);
		// --- <<IS-END>> ---

                
	}



	public static final void javaserv (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(javaserv)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		//Get Broker connection parameters from the IS configuration. 
		BrokerTransportFactory transFac = 
		(BrokerTransportFactory)CommsFactory.getFactory( 
		BrokerTransportFactory.FACTORY_TYPE); 
		String brokerHost = transFac.getBrokerHost(); 
		String brokerName = transFac.getBrokerName(); 
		String clientGroup = transFac.getClientGroup(); 
		String clientPrefix = Configurator.getClientPrefix(); 
		
		// --- <<IS-END>> ---

                
	}
}

