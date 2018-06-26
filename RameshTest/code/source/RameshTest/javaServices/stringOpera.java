package RameshTest.javaServices;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-05-29 23:46:54 IST
// -----( ON-HOST: localhost

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.util.*;
import java.lang.*;
// --- <<IS-END-IMPORTS>> ---

public final class stringOpera

{
	// ---( internal utility methods )---

	final static stringOpera _instance = new stringOpera();

	static stringOpera _newInstance() { return new stringOpera(); }

	static stringOpera _cast(Object o) { return (stringOpera)o; }

	// ---( server methods )---




	public static final void concat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(concat)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required value1
		// [i] field:0:required value2
		// [o] field:0:required res
		// pipeline-IN
		
		IDataCursor pipelineCursor =pipeline.getCursor();
		
		String value1 =IDataUtil.getString(pipelineCursor,"value1");
		String value2 =IDataUtil.getString(pipelineCursor,"value2");
		
		pipelineCursor.destroy();
		String temp="";
		try {
		
		temp =value1.concat(value2);
		}catch (Exception e) {
		e.printStackTrace() ;
		}
		IDataCursor pipelineCursor2 =pipeline.getCursor();
		
		IDataUtil.put(pipelineCursor2 ,"res" ,temp);
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void length (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(length)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required length
		// pipeline-IN
		
		IDataCursor pipelineCursor =pipeline.getCursor();
		String inString =IDataUtil.getString(pipelineCursor,"inString");
		int temp;
		String  temp2="";
		try {
		
		temp =inString.length();
		temp2=Integer.toString(temp);
		}catch (Exception e){
		e.printStackTrace();
		}
		//pipeline-Out
		
		IDataCursor pipelineCursor2 =pipeline.getCursor();
		
		IDataUtil.put(pipelineCursor2,"lenght",temp2);
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void lengthString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(lengthString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required input
		// [o] field:0:required res
		// pipeline -in
		
		IDataCursor pipelineCursor =pipeline.getCursor();
		
		String input =IDataUtil.getString(pipelineCursor,"input");
		int temp;
		
		String temp2="";
		try {
		
		temp =input.length();
		 temp2 =Integer.toString(temp);
		}catch (Exception e){
		e.printStackTrace();
		}
		
		
		
		//pipeline-out
		
		IDataCursor pipelineCursor2 =pipeline.getCursor() ;
		
		IDataUtil.put(pipelineCursor2,"res",temp2);
		
		
		
		
		 
		
		
		
		
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void stringConcat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringConcat)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required input1
		// [i] field:0:required input2
		// [o] field:0:required res
		IDataCursor pipelineCursor =pipeline.getCursor();
		
		String input1 =IDataUtil.getString(pipelineCursor ,"input1") ;
		String input2 =IDataUtil.getString(pipelineCursor,"input2");
		String temp="";
		try {
		if(input1!= null&&input2!=null )
		{ 
		 temp =input1.concat(input2);
		}
		}
		
		catch (Exception e) {
				e.printStackTrace();	   
		}
		
		IDataCursor pipelineCursor2 =pipeline.getCursor ();
		IDataUtil.put(pipelineCursor2 ,"result" ,temp);
		
		
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void test (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(test)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required input1
		// [i] field:0:required input2
		// [o] field:0:required result
		IDataCursor pipelineCursor =pipeline.getCursor();
		
		
		String input1="";
		String input2="";
		
		if(pipelineCursor.first("input1") )
		{
		input1=(String)pipelineCursor.getValue();
		}
		else
		{
		throw new ServiceException("User must give input1 value");
		}
		
		
		if(pipelineCursor.first("input2") )
		{
		input2=(String)pipelineCursor.getValue();
		}
		else
		{
		throw new ServiceException("User must give input2 value") ;
		}
		
		String temp =input1.concat(input2);
		IDataCursor pipelineCursor2 =pipeline.getCursor() ;
		
		IDataUtil.put(pipelineCursor2,"res",temp);
		
		
		
		
		// --- <<IS-END>> ---

                
	}
}

