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

public class evaluateInlineCondition extends AttributeContainer implements KvmSerializable
{

    
    public String conditionXML;
    
    public ArrayList< String> reportCustomizationParameters =new ArrayList<String >();
    
    public String sessionID;

    public evaluateInlineCondition ()
    {
    }

    public evaluateInlineCondition (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("conditionXML"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.conditionXML = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.conditionXML = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("reportCustomizationParameters"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.reportCustomizationParameters==null)
                        {
                            this.reportCustomizationParameters = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.reportCustomizationParameters.add(j1);
                   
        
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
        if(propertyIndex==0)
        {
            return conditionXML;
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.reportCustomizationParameters.size())
        {
            return this.reportCustomizationParameters.get(propertyIndex-(1));
        }
        if(propertyIndex==1+this.reportCustomizationParameters.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+reportCustomizationParameters.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "conditionXML";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.reportCustomizationParameters.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "reportCustomizationParameters";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.reportCustomizationParameters.size())
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

