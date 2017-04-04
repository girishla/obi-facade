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
import java.math.BigInteger;

public class ImportError extends AttributeContainer implements KvmSerializable
{

    
    public String item;
    
    public String operation;
    
    public String file;
    
    public BigInteger line=BigInteger.ZERO;
    
    public String catalogError;

    public ImportError ()
    {
    }

    public ImportError (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("item"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.item = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.item = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("operation"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.operation = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.operation = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("file"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.file = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.file = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("line"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.line = new BigInteger(j.toString());
                            }
                        }
                        else if (obj instanceof BigInteger){
                            this.line = (BigInteger)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("catalogError"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.catalogError = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.catalogError = (String)obj;
                        }
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
            return item;
        }
        if(propertyIndex==1)
        {
            return operation;
        }
        if(propertyIndex==2)
        {
            return file;
        }
        if(propertyIndex==3)
        {
            return this.line!=null?this.line.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return catalogError;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "item";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "operation";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "file";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "line";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "catalogError";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

