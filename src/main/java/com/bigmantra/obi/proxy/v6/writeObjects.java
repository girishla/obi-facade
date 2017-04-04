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

public class writeObjects extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< CatalogObject> catalogObjects =new ArrayList<CatalogObject >();
    
    public Boolean allowOverwrite=false;
    
    public Boolean createIntermediateDirs=false;
    
    public Enums.ErrorDetailsLevel errorMode=Enums.ErrorDetailsLevel.ErrorCode;
    
    public String sessionID;

    public writeObjects ()
    {
    }

    public writeObjects (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("catalogObjects"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.catalogObjects==null)
                        {
                            this.catalogObjects = new ArrayList< CatalogObject>();
                        }
                        java.lang.Object j =obj;
                        CatalogObject j1= (CatalogObject)__envelope.get(j,CatalogObject.class,false);
                        this.catalogObjects.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("allowOverwrite"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.allowOverwrite = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.allowOverwrite = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("createIntermediateDirs"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.createIntermediateDirs = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.createIntermediateDirs = (Boolean)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.catalogObjects.size())
        {
            return this.catalogObjects.get(propertyIndex-(0));
        }
        if(propertyIndex==0+this.catalogObjects.size())
        {
            return allowOverwrite;
        }
        if(propertyIndex==1+this.catalogObjects.size())
        {
            return createIntermediateDirs;
        }
        if(propertyIndex==2+this.catalogObjects.size())
        {
            return this.errorMode!=null?this.errorMode.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3+this.catalogObjects.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4+catalogObjects.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.catalogObjects.size())
        {
            info.type = CatalogObject.class;
            info.name = "catalogObjects";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.catalogObjects.size())
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "allowOverwrite";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.catalogObjects.size())
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "createIntermediateDirs";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2+this.catalogObjects.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "errorMode";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3+this.catalogObjects.size())
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

