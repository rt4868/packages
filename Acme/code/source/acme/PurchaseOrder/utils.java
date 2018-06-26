package acme.PurchaseOrder;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-12-10 16:44:42 EST
// -----( ON-HOST: TrainHost.webmethods.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void fastJavaMapper (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fastJavaMapper)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required InSKUList
		// [i] - field:0:required qty
		// [o] record:1:required OutSKUList
		// [o] - field:0:required QUANTITY
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		  // InSKUList
		  IData[] InSKUList = IDataUtil.getIDataArray( pipelineCursor, "InSKUList" );
		  if ( InSKUList != null) {
		    IData[] OutSKUList = new IData[InSKUList.length];
		    for ( int i = 0; i < InSKUList.length; i++ ) {
		      OutSKUList[i] = IDataFactory.create();
		      IDataCursor InSKUListCursor = InSKUList[i].getCursor();
		      String qty = IDataUtil.getString( InSKUListCursor, "qty" );
		      InSKUListCursor.destroy();
		      IDataCursor OutSKUListCursor = OutSKUList[i].getCursor();
		      IDataUtil.put(OutSKUListCursor,"QUANTITY",qty);
		      OutSKUListCursor.destroy(); 
		  }
		  IDataUtil.put(pipelineCursor,"OutSKUList",OutSKUList);
		}
		// --- <<IS-END>> ---

                
	}
}

