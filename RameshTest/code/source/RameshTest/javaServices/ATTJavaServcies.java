package RameshTest.javaServices;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-05-27 00:28:36 IST
// -----( ON-HOST: IBM-01384F4224D

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.util.Random;
import com.wm.app.b2b.server.*;
// --- <<IS-END-IMPORTS>> ---

public final class ATTJavaServcies

{
	// ---( internal utility methods )---

	final static ATTJavaServcies _instance = new ATTJavaServcies();

	static ATTJavaServcies _newInstance() { return new ATTJavaServcies(); }

	static ATTJavaServcies _cast(Object o) { return (ATTJavaServcies)o; }

	// ---( server methods )---




	public static final void getHostname (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getHostname)>> ---
		// @sigtype java 3.5
		// [o] field:0:required host
		//String os = System.getProperty("os.name");
		ServerAPI s = new ServerAPI();
		String host = s.getServerName();
		//int index = host.indexOf('.');
		//host = host.substring(0,index);
		
		IDataHashCursor pipelineCursor_1 = pipeline.getHashCursor();
		pipelineCursor_1.last();
		pipelineCursor_1.insertAfter( "host", host);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static int pCount =0;
	static public int generateRandomNumberFromRange(Random r, int range)
		{
			return (int)(r.nextDouble()*(range-1.0e-3));
		}
		static public char generateRandomCharFromRange(Random r, char start, char end)
		{
			return (char)(start+generateRandomNumberFromRange(r,end-start+1));
		}
	// --- <<IS-END-SHARED>> ---
}

