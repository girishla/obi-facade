package com.bigmantra.obi.proxy.v6;

//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------



import org.ksoap2.serialization.*;
import java.util.Vector;
import java.util.Hashtable;


public class getGroupsResult extends Vector< Account> implements KvmSerializable
{
    
    public getGroupsResult(){}
    
    public getGroupsResult(java.lang.Object inObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (inObj == null)
            return;
        SoapObject soapObject=(SoapObject)inObj;
        int size = soapObject.getPropertyCount();
        for (int i0=0;i0< size;i0++)
        {
            java.lang.Object obj = soapObject.getProperty(i0);
            if (obj!=null && obj instanceof AttributeContainer)
            {
                AttributeContainer j =(AttributeContainer) soapObject.getProperty(i0);
                Account j1= (Account)__envelope.get(j,Account.class,false);
                add(j1);
            }
        }
}
    
    @Override
    public java.lang.Object getProperty(int arg0) {
        return this.get(arg0)!=null?this.get(arg0):SoapPrimitive.NullNilElement;
    }
    
    @Override
    public int getPropertyCount() {
        return this.size();
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "account";
        info.type = Account.class;
    	info.namespace= "urn://oracle.bi.webservices/v6";
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }

    
}