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

public class GetSubItemsFilter extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< NameValuePair> itemInfoFilters =new ArrayList<NameValuePair >();
    
    public String dummy;

    public GetSubItemsFilter ()
    {
    }

    public GetSubItemsFilter (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("itemInfoFilters"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.itemInfoFilters==null)
                        {
                            this.itemInfoFilters = new ArrayList< NameValuePair>();
                        }
                        java.lang.Object j =obj;
                        NameValuePair j1= (NameValuePair)__envelope.get(j,NameValuePair.class,false);
                        this.itemInfoFilters.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("dummy"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.dummy = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.dummy = (String)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.itemInfoFilters.size())
        {
            return this.itemInfoFilters.get(propertyIndex-(0));
        }
        if(propertyIndex==0+this.itemInfoFilters.size())
        {
            return this.dummy!=null?this.dummy:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+itemInfoFilters.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.itemInfoFilters.size())
        {
            info.type = NameValuePair.class;
            info.name = "itemInfoFilters";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.itemInfoFilters.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dummy";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

