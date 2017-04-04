package com.bigmantra.obi.proxy.v6;

//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class SAWException extends AttributeContainer implements KvmSerializable
{

    
    public String message;
    
    public ArrayList< SAWException> exception =new ArrayList<SAWException >();

    public SAWException ()
    {
    }

    public SAWException (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                //if you have compilation error here, please use a ksoap2.jar and ExKsoap2.jar from libs folder (in the generated zip file)
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                java.lang.Object obj = info.getValue(); 
                if (info.name.equals("message"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.message = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.message = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("exception"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.exception==null)
                        {
                            this.exception = new ArrayList< SAWException>();
                        }
                        java.lang.Object j =obj;
                        SAWException j1= (SAWException)__envelope.get(j,SAWException.class,false);
                        this.exception.add(j1);
                   
        
                    }
                    continue;
                }

            }

        }



    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return message;
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.exception.size())
        {
            return this.exception.get(propertyIndex-(1));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+exception.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "message";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.exception.size())
        {
            info.type = SAWException.class;
            info.name = "exception";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

