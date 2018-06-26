package my.evals;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2005-06-02 12:00:12 EDT
// -----( ON-HOST: 10.3.48.23

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.io.*;
import java.text.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void StudToStuds (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(StudToStuds)>> ---
		// @sigtype java 3.5
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			// Student
			IData	Student = IDataUtil.getIData( pipelineCursor, "Student" );
			
		
			// StudentsIn
			IData[]	StudentsIn = IDataUtil.getIDataArray( pipelineCursor, "StudentsIn" );
		
		if ( StudentsIn != null)
			{
		           IData[]	Students_1 = new IData[StudentsIn.length + 1];
				for ( int i = 0; i < StudentsIn.length; i++ )
				{
		                  Students_1[i] = IDataFactory.create();
		                  Students_1[i] = StudentsIn[i];
				
				}
		           Students_1[StudentsIn.length] = IDataFactory.create();
		           Students_1[StudentsIn.length] = Student;
		           IDataUtil.put( pipelineCursor, "StudentsOut", Students_1 );
		
			} else {
		          IData[]	Students_1 = new IData[1]; 
		          Students_1[0] = IDataFactory.create();
		          Students_1[0] = Student;
		          IDataUtil.put( pipelineCursor, "StudentsOut", Students_1 );
		        }	
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void writeEvalFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeEvalFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FileName
		// [i] field:0:required inputString
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FileName = IDataUtil.getString( pipelineCursor, "FileName" );
			String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
		pipelineCursor.destroy();
		
		try
		{
		   String regFileName = FileName;
				
		   StringBuffer strBuffer = new StringBuffer ();
				
		   strBuffer.append (inputString + "\n");
				
		   byte [] bufWrite = strBuffer.toString ().getBytes ();
				
		   FileOutputStream regWrite = new FileOutputStream (regFileName, true);
		   regWrite.write (bufWrite);
		   regWrite.close ();
							
		}
		
		catch (IOException ie) 
		{
		   ie.printStackTrace ();
		}
		catch (Exception e) 
		{
		   e.printStackTrace ();
		}
		
		// --- <<IS-END>> ---

                
	}
}

