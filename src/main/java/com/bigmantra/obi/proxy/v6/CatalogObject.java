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

public class CatalogObject extends AttributeContainer implements KvmSerializable
{

    
    public String catalogObject;
    
    public byte[] catalogObjectBytes;
    
    public ItemInfo itemInfo;
    
    public ErrorInfo errorInfo;

    public CatalogObject ()
    {
    }

    public CatalogObject (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("catalogObject"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.catalogObject = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.catalogObject = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("catalogObjectBytes"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.catalogObjectBytes = Helper.getBinary(j,false);
                    }
                    continue;
                }
                if (info.name.equals("itemInfo"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.itemInfo = (ItemInfo)__envelope.get(j,ItemInfo.class,false);
                    }
                    continue;
                }
                if (info.name.equals("errorInfo"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.errorInfo = (ErrorInfo)__envelope.get(j,ErrorInfo.class,false);
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
            return this.catalogObject!=null?this.catalogObject:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.catalogObjectBytes!=null?org.kobjects.base64.Base64.encode(this.catalogObjectBytes):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.itemInfo!=null?this.itemInfo:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.errorInfo!=null?this.errorInfo:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "catalogObject";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "catalogObjectBytes";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = ItemInfo.class;
            info.name = "itemInfo";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = ErrorInfo.class;
            info.name = "errorInfo";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

