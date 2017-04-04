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

public class setItemProperty extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< String> path =new ArrayList<String >();
    
    public ArrayList< String> name =new ArrayList<String >();
    
    public ArrayList< String> value =new ArrayList<String >();
    
    public Boolean recursive=false;
    
    public String sessionID;

    public setItemProperty ()
    {
    }

    public setItemProperty (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("path"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.path==null)
                        {
                            this.path = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.path.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("name"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.name==null)
                        {
                            this.name = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.name.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("value"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.value==null)
                        {
                            this.value = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.value.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("recursive"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.recursive = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.recursive = (Boolean)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.path.size())
        {
            return this.path.get(propertyIndex-(0));
        }
        if(propertyIndex>=0+this.path.size() && propertyIndex < 0+this.path.size()+this.name.size())
        {
            return this.name.get(propertyIndex-(0+this.path.size()));
        }
        if(propertyIndex>=0+this.path.size()+this.name.size() && propertyIndex < 0+this.path.size()+this.name.size()+this.value.size())
        {
            return this.value.get(propertyIndex-(0+this.path.size()+this.name.size()));
        }
        if(propertyIndex==0+this.path.size()+this.name.size()+this.value.size())
        {
            return recursive;
        }
        if(propertyIndex==1+this.path.size()+this.name.size()+this.value.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+path.size()+name.size()+value.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.path.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "path";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.path.size() && propertyIndex < 0+this.path.size()+this.name.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "name";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.path.size()+this.name.size() && propertyIndex < 0+this.path.size()+this.name.size()+this.value.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "value";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.path.size()+this.name.size()+this.value.size())
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "recursive";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.path.size()+this.name.size()+this.value.size())
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

