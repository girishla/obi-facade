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

public class ItemInfo extends AttributeContainer implements KvmSerializable
{

    
    public String path;
    
    public Enums.ItemInfoType type=Enums.ItemInfoType.Folder;
    
    public String caption;
    
    public Integer attributes;
    
    public org.joda.time.DateTime lastModified;
    
    public org.joda.time.DateTime created;
    
    public org.joda.time.DateTime accessed;
    
    public Account creator;
    
    public Account lastModifier;
    
    public String signature;
    
    public String targetPath;
    
    public ACL acl;
    
    public Account owner;
    
    public ArrayList< NameValuePair> itemProperties =new ArrayList<NameValuePair >();

    public ItemInfo ()
    {
    }

    public ItemInfo (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.path = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.path = (String)obj;
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
                                this.type = Enums.ItemInfoType.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof Enums.ItemInfoType){
                            this.type = (Enums.ItemInfoType)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("caption"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.caption = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.caption = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("attributes"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.attributes = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.attributes = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("lastModified"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.lastModified = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.lastModified = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("created"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.created = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.created = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("accessed"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.accessed = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.accessed = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("creator"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.creator = (Account)__envelope.get(j,Account.class,false);
                    }
                    continue;
                }
                if (info.name.equals("lastModifier"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.lastModifier = (Account)__envelope.get(j,Account.class,false);
                    }
                    continue;
                }
                if (info.name.equals("signature"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.signature = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.signature = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("targetPath"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.targetPath = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.targetPath = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("acl"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.acl = (ACL)__envelope.get(j,ACL.class,false);
                    }
                    continue;
                }
                if (info.name.equals("owner"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.owner = (Account)__envelope.get(j,Account.class,false);
                    }
                    continue;
                }
                if (info.name.equals("itemProperties"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.itemProperties==null)
                        {
                            this.itemProperties = new ArrayList< NameValuePair>();
                        }
                        java.lang.Object j =obj;
                        NameValuePair j1= (NameValuePair)__envelope.get(j,NameValuePair.class,false);
                        this.itemProperties.add(j1);
                   
        
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
            return path;
        }
        if(propertyIndex==1)
        {
            return this.type!=null?this.type.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.caption!=null?this.caption:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.attributes!=null?this.attributes:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.lastModified!=null?this.lastModified.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==5)
        {
            return this.created!=null?this.created.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==6)
        {
            return this.accessed!=null?this.accessed.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==7)
        {
            return this.creator!=null?this.creator:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==8)
        {
            return this.lastModifier!=null?this.lastModifier:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==9)
        {
            return this.signature!=null?this.signature:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==10)
        {
            return this.targetPath!=null?this.targetPath:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==11)
        {
            return this.acl!=null?this.acl:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==12)
        {
            return this.owner!=null?this.owner:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=13 && propertyIndex < 13+this.itemProperties.size())
        {
            return this.itemProperties.get(propertyIndex-(13));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 13+itemProperties.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "path";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "type";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "caption";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "attributes";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "lastModified";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "created";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "accessed";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==7)
        {
            info.type = Account.class;
            info.name = "creator";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==8)
        {
            info.type = Account.class;
            info.name = "lastModifier";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==9)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "signature";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==10)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "targetPath";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==11)
        {
            info.type = ACL.class;
            info.name = "acl";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==12)
        {
            info.type = Account.class;
            info.name = "owner";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=13 && propertyIndex < 13+this.itemProperties.size())
        {
            info.type = NameValuePair.class;
            info.name = "itemProperties";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

