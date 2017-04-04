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

public class SAWSessionParameters extends AttributeContainer implements KvmSerializable
{

    
    public SAWLocale locale;
    
    public String userAgent;
    
    public Boolean asyncLogon=false;
    
    public ArrayList< LogonParameter> logonParams =new ArrayList<LogonParameter >();
    
    public String sessionID;
    
    public String syndicate;

    public SAWSessionParameters ()
    {
    }

    public SAWSessionParameters (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("locale"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.locale = (SAWLocale)__envelope.get(j,SAWLocale.class,false);
                    }
                    continue;
                }
                if (info.name.equals("userAgent"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.userAgent = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.userAgent = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("asyncLogon"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.asyncLogon = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.asyncLogon = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("logonParams"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.logonParams==null)
                        {
                            this.logonParams = new ArrayList< LogonParameter>();
                        }
                        java.lang.Object j =obj;
                        LogonParameter j1= (LogonParameter)__envelope.get(j,LogonParameter.class,false);
                        this.logonParams.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("sessionID"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.sessionID = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.sessionID = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("syndicate"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.syndicate = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.syndicate = (String)obj;
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
            return this.locale!=null?this.locale:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==1)
        {
            return this.userAgent!=null?this.userAgent:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==2)
        {
            return asyncLogon;
        }
        if(propertyIndex>=3 && propertyIndex < 3+this.logonParams.size())
        {
            return this.logonParams.get(propertyIndex-(3));
        }
        if(propertyIndex==3+this.logonParams.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==4+this.logonParams.size())
        {
            return this.syndicate!=null?this.syndicate:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 5+logonParams.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = SAWLocale.class;
            info.name = "locale";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "userAgent";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "asyncLogon";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=3 && propertyIndex < 3+this.logonParams.size())
        {
            info.type = LogonParameter.class;
            info.name = "logonParams";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3+this.logonParams.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "sessionID";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==4+this.logonParams.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "syndicate";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

