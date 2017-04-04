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

public class TemplateInfo extends AttributeContainer implements KvmSerializable
{

    
    public String templateForEach;
    
    public String templateIterator;
    
    public ArrayList< TemplateInfoInstance> instance =new ArrayList<TemplateInfoInstance >();

    public TemplateInfo ()
    {
    }

    public TemplateInfo (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("templateForEach"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.templateForEach = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.templateForEach = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("templateIterator"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.templateIterator = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.templateIterator = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("instance"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.instance==null)
                        {
                            this.instance = new ArrayList< TemplateInfoInstance>();
                        }
                        java.lang.Object j =obj;
                        TemplateInfoInstance j1= (TemplateInfoInstance)__envelope.get(j,TemplateInfoInstance.class,false);
                        this.instance.add(j1);
                   
        
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
            return templateForEach;
        }
        if(propertyIndex==1)
        {
            return templateIterator;
        }
        if(propertyIndex>=2 && propertyIndex < 2+this.instance.size())
        {
            return this.instance.get(propertyIndex-(2));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+instance.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "templateForEach";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "templateIterator";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=2 && propertyIndex < 2+this.instance.size())
        {
            info.type = TemplateInfoInstance.class;
            info.name = "instance";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

