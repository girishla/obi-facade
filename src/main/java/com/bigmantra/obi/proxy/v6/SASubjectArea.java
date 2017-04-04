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

public class SASubjectArea extends AttributeContainer implements KvmSerializable
{

    
    public String name;
    
    public String displayName;
    
    public String description;
    
    public ArrayList< SATable> tables =new ArrayList<SATable >();

    public SASubjectArea ()
    {
    }

    public SASubjectArea (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("name"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.name = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.name = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("displayName"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.displayName = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.displayName = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("description"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.description = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.description = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("tables"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.tables==null)
                        {
                            this.tables = new ArrayList< SATable>();
                        }
                        java.lang.Object j =obj;
                        SATable j1= (SATable)__envelope.get(j,SATable.class,false);
                        this.tables.add(j1);
                   
        
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
            return name;
        }
        if(propertyIndex==1)
        {
            return displayName;
        }
        if(propertyIndex==2)
        {
            return description;
        }
        if(propertyIndex>=3 && propertyIndex < 3+this.tables.size())
        {
            return this.tables.get(propertyIndex-(3));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3+tables.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "name";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "displayName";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "description";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=3 && propertyIndex < 3+this.tables.size())
        {
            info.type = SATable.class;
            info.name = "tables";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

