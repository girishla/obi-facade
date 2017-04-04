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

public class GetSubItemsParams extends AttributeContainer implements KvmSerializable
{

    
    public GetSubItemsFilter filter;
    
    public Boolean includeACL=false;
    
    public Integer withPermission=0;
    
    public Integer withPermissionMask=0;
    
    public Integer withAttributes=0;
    
    public Integer withAttributesMask=0;

    public GetSubItemsParams ()
    {
    }

    public GetSubItemsParams (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("filter"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.filter = (GetSubItemsFilter)__envelope.get(j,GetSubItemsFilter.class,false);
                    }
                    continue;
                }
                if (info.name.equals("includeACL"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.includeACL = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.includeACL = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("withPermission"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.withPermission = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.withPermission = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("withPermissionMask"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.withPermissionMask = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.withPermissionMask = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("withAttributes"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.withAttributes = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.withAttributes = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("withAttributesMask"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.withAttributesMask = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.withAttributesMask = (Integer)obj;
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
            return this.filter!=null?this.filter:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==1)
        {
            return includeACL;
        }
        if(propertyIndex==2)
        {
            return withPermission;
        }
        if(propertyIndex==3)
        {
            return withPermissionMask;
        }
        if(propertyIndex==4)
        {
            return withAttributes;
        }
        if(propertyIndex==5)
        {
            return withAttributesMask;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = GetSubItemsFilter.class;
            info.name = "filter";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "includeACL";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "withPermission";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "withPermissionMask";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "withAttributes";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "withAttributesMask";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

