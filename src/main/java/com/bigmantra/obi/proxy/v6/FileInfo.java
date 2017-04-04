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

public class FileInfo extends AttributeContainer implements KvmSerializable
{

    
    public String filepath;
    
    public org.joda.time.DateTime startTime;
    
    public org.joda.time.DateTime endTime;
    
    public Long filesize=0L;
    
    public ArrayList< NameValueArrayPair> fileAttribs =new ArrayList<NameValueArrayPair >();

    public FileInfo ()
    {
    }

    public FileInfo (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("filepath"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.filepath = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.filepath = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("startTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.startTime = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.startTime = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("endTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.endTime = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.endTime = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("filesize"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.filesize = new Long(j.toString());
                            }
                        }
                        else if (obj instanceof Long){
                            this.filesize = (Long)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("fileAttribs"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.fileAttribs==null)
                        {
                            this.fileAttribs = new ArrayList< NameValueArrayPair>();
                        }
                        java.lang.Object j =obj;
                        NameValueArrayPair j1= (NameValueArrayPair)__envelope.get(j,NameValueArrayPair.class,false);
                        this.fileAttribs.add(j1);
                   
        
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
            return filepath;
        }
        if(propertyIndex==1)
        {
            return this.startTime!=null?this.startTime.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.endTime!=null?this.endTime.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return filesize;
        }
        if(propertyIndex>=4 && propertyIndex < 4+this.fileAttribs.size())
        {
            return this.fileAttribs.get(propertyIndex-(4));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4+fileAttribs.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "filepath";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "startTime";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "endTime";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.LONG_CLASS;
            info.name = "filesize";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=4 && propertyIndex < 4+this.fileAttribs.size())
        {
            info.type = NameValueArrayPair.class;
            info.name = "fileAttribs";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

