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

public class sendMessage extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< String> recipient =new ArrayList<String >();
    
    public ArrayList< String> group =new ArrayList<String >();
    
    public String subject;
    
    public String body;
    
    public String priority;
    
    public String sessionID;

    public sendMessage ()
    {
    }

    public sendMessage (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("recipient"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.recipient==null)
                        {
                            this.recipient = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.recipient.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("group"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.group==null)
                        {
                            this.group = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.group.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("subject"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.subject = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.subject = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("body"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.body = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.body = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("priority"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.priority = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.priority = (String)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.recipient.size())
        {
            return this.recipient.get(propertyIndex-(0));
        }
        if(propertyIndex>=0+this.recipient.size() && propertyIndex < 0+this.recipient.size()+this.group.size())
        {
            return this.group.get(propertyIndex-(0+this.recipient.size()));
        }
        if(propertyIndex==0+this.recipient.size()+this.group.size())
        {
            return subject;
        }
        if(propertyIndex==1+this.recipient.size()+this.group.size())
        {
            return body;
        }
        if(propertyIndex==2+this.recipient.size()+this.group.size())
        {
            return priority;
        }
        if(propertyIndex==3+this.recipient.size()+this.group.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4+recipient.size()+group.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.recipient.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "recipient";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.recipient.size() && propertyIndex < 0+this.recipient.size()+this.group.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "group";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.recipient.size()+this.group.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "subject";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.recipient.size()+this.group.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "body";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2+this.recipient.size()+this.group.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "priority";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3+this.recipient.size()+this.group.size())
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

