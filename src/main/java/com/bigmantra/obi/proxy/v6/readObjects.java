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

public class readObjects extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< String> paths =new ArrayList<String >();
    
    public Boolean resolveLinks=false;
    
    public Enums.ErrorDetailsLevel errorMode=Enums.ErrorDetailsLevel.ErrorCode;
    
    public Enums.ReadObjectsReturnOptions returnOptions=Enums.ReadObjectsReturnOptions.NoObject;
    
    public String sessionID;

    public readObjects ()
    {
    }

    public readObjects (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("paths"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.paths==null)
                        {
                            this.paths = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.paths.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("resolveLinks"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.resolveLinks = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.resolveLinks = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("errorMode"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.errorMode = Enums.ErrorDetailsLevel.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof Enums.ErrorDetailsLevel){
                            this.errorMode = (Enums.ErrorDetailsLevel)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("returnOptions"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.returnOptions = Enums.ReadObjectsReturnOptions.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof Enums.ReadObjectsReturnOptions){
                            this.returnOptions = (Enums.ReadObjectsReturnOptions)obj;
                        }
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

            }

        }



    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex>=0 && propertyIndex < 0+this.paths.size())
        {
            return this.paths.get(propertyIndex-(0));
        }
        if(propertyIndex==0+this.paths.size())
        {
            return resolveLinks;
        }
        if(propertyIndex==1+this.paths.size())
        {
            return this.errorMode!=null?this.errorMode.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2+this.paths.size())
        {
            return this.returnOptions!=null?this.returnOptions.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3+this.paths.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4+paths.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.paths.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "paths";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.paths.size())
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "resolveLinks";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.paths.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "errorMode";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2+this.paths.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "returnOptions";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3+this.paths.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "sessionID";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

