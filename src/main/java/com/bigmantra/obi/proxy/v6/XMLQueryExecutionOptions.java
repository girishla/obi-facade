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

public class XMLQueryExecutionOptions extends AttributeContainer implements KvmSerializable
{

    
    public Boolean async=false;
    
    public Integer maxRowsPerPage=0;
    
    public Boolean refresh=false;
    
    public Boolean presentationInfo=false;
    
    public String type;

    public XMLQueryExecutionOptions ()
    {
    }

    public XMLQueryExecutionOptions (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("async"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.async = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.async = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("maxRowsPerPage"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.maxRowsPerPage = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.maxRowsPerPage = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("refresh"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.refresh = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.refresh = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("presentationInfo"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.presentationInfo = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.presentationInfo = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("type"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.type = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.type = (String)obj;
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
            return async;
        }
        if(propertyIndex==1)
        {
            return maxRowsPerPage;
        }
        if(propertyIndex==2)
        {
            return refresh;
        }
        if(propertyIndex==3)
        {
            return presentationInfo;
        }
        if(propertyIndex==4)
        {
            return this.type!=null?this.type:SoapPrimitive.NullNilElement;
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
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "async";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "maxRowsPerPage";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "refresh";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "presentationInfo";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "type";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

