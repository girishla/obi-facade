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

public class CatalogItemsFilter extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< String> items =new ArrayList<String >();
    
    public org.joda.time.DateTime from;
    
    public org.joda.time.DateTime to;

    public CatalogItemsFilter ()
    {
    }

    public CatalogItemsFilter (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("items"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.items==null)
                        {
                            this.items = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.items.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("from"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.from = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.from = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("to"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.to = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.to = (org.joda.time.DateTime)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.items.size())
        {
            return this.items.get(propertyIndex-(0));
        }
        if(propertyIndex==0+this.items.size())
        {
            return this.from!=null?this.from.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1+this.items.size())
        {
            return this.to!=null?this.to.toString():SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+items.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.items.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "items";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.items.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "from";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.items.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "to";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

