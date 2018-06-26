package RameshTest.brokerExamples.pubnwait;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-05-22 02:20:02 IST
// -----( ON-HOST: 9.126.238.176

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.lang.*;
import java.util.*;
import com.wm.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class sub

{
	// ---( internal utility methods )---

	final static sub _instance = new sub();

	static sub _newInstance() { return new sub(); }

	static sub _cast(Object o) { return (sub)o; }

	// ---( server methods )---




	public static final void writeFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required fileName
		// [i] field:0:required userData
		// [i] object:0:required bytes
		// [o] field:0:required returnCode
		// [o] field:0:required returnMsg
		IDataHashCursor idcPipeline = pipeline.getHashCursor();
		
		String fileName = "";
		String inStr = "";
		byte[] bytes = null; 
		
		if (idcPipeline.first("fileName")) 
		{
			fileName = (String)idcPipeline.getValue();
		}
		if (idcPipeline.first("userData"))
		{
			inStr = (String)idcPipeline.getValue();
		} 
		if (idcPipeline.first("bytes"))
		{
			bytes = (byte[])idcPipeline.getValue();
		}
		
		try {
			FileOutputStream fos = new FileOutputStream( new File(fileName));
			if (inStr != null && !inStr.equals(""))
			{
				fos.write(inStr.getBytes(), 0, inStr.length());
				idcPipeline.insertAfter("returnCode", Integer.toString(0));
				idcPipeline.insertAfter("returnMsg", "Successfully write file "+fileName);
			}
			if (bytes != null )
			{
				fos.write(bytes, 0, bytes.length);
				idcPipeline.insertAfter("returnCode", Integer.toString(0));
				idcPipeline.insertAfter("returnMsg", "Successfully write file "+fileName);
			}
			
			fos.close();
		}
		catch (Exception e)
		{
			//throw new ServiceException(e);
			idcPipeline.insertAfter("returnCode", Integer.toString(-1));
			idcPipeline.insertAfter("returnMsg", "Failed to write file "+fileName +" - "+e.toString());
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	protected static synchronized void writeString(String filename, String message) throws ServiceException {
	/*
		try{
			RandomAccessFile rf=new RandomAccessFile(filename,"rw");
			rf.seek(rf.length());
			rf.writeBytes(message);
			rf.writeBytes("\n");
			rf.close();
		}catch(Exception e){
			throw new ServiceException(e);
		}
	*/
		writeData(filename, null, message);
	}
	protected static synchronized void writeBytes(String filename, byte[] messageInBytes) throws ServiceException {
	/*
		try{
			RandomAccessFile rf=new RandomAccessFile(filename,"rw");
			rf.seek(rf.length());
			rf.write(messageInBytes);
			rf.writeBytes("\n");
			rf.close();
		}catch(Exception e){
			throw new ServiceException(e);
		}
	*/
		writeData(filename, messageInBytes, null);
		
	}
	
	protected static synchronized void writeData(
							String filename, 
							byte[] messageInBytes,
							String message) 
		throws ServiceException 
	{
		// abort
		if (message == null && messageInBytes == null) return;
	
		try
		{
			RandomAccessFile rf=new RandomAccessFile(filename,"rw");
			rf.seek(rf.length());
			if (message != null) 
			{
				rf.writeBytes(message);
			}
			if(messageInBytes != null)
			{
				rf.write(messageInBytes);
			}
			rf.writeBytes("\n");
			rf.close();
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
	}
	// --- <<IS-END-SHARED>> ---
}

