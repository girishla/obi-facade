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
import java.math.BigDecimal;
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class SegmentationOptions extends AttributeContainer implements KvmSerializable
{

    
    public Boolean removeCacheHits;
    
    public Enums.OverrideType countOverride;
    
    public Enums.OverrideType cacheOverride;
    
    public BigDecimal samplingFactor;
    
    public ArrayList< NameValuePair> govRules =new ArrayList<NameValuePair >();
    
    public ArrayList< NameValuePair> prompts =new ArrayList<NameValuePair >();

    public SegmentationOptions ()
    {
    }

    public SegmentationOptions (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("removeCacheHits"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.removeCacheHits = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.removeCacheHits = (Boolean)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("countOverride"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.countOverride = Enums.OverrideType.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof Enums.OverrideType){
                            this.countOverride = (Enums.OverrideType)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("cacheOverride"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.cacheOverride = Enums.OverrideType.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof Enums.OverrideType){
                            this.cacheOverride = (Enums.OverrideType)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("samplingFactor"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.samplingFactor = new BigDecimal(j.toString());
                            }
                        }
                        else if (obj instanceof BigDecimal){
                            this.samplingFactor = (BigDecimal)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("govRules"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.govRules==null)
                        {
                            this.govRules = new ArrayList< NameValuePair>();
                        }
                        java.lang.Object j =obj;
                        NameValuePair j1= (NameValuePair)__envelope.get(j,NameValuePair.class,false);
                        this.govRules.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("prompts"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.prompts==null)
                        {
                            this.prompts = new ArrayList< NameValuePair>();
                        }
                        java.lang.Object j =obj;
                        NameValuePair j1= (NameValuePair)__envelope.get(j,NameValuePair.class,false);
                        this.prompts.add(j1);
                   
        
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
            return this.removeCacheHits!=null?this.removeCacheHits:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.countOverride!=null?this.countOverride.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.cacheOverride!=null?this.cacheOverride.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.samplingFactor!=null?this.samplingFactor.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=4 && propertyIndex < 4+this.govRules.size())
        {
            return this.govRules.get(propertyIndex-(4));
        }
        if(propertyIndex>=4+this.govRules.size() && propertyIndex < 4+this.govRules.size()+this.prompts.size())
        {
            return this.prompts.get(propertyIndex-(4+this.govRules.size()));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4+govRules.size()+prompts.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "removeCacheHits";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "countOverride";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "cacheOverride";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "samplingFactor";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=4 && propertyIndex < 4+this.govRules.size())
        {
            info.type = NameValuePair.class;
            info.name = "govRules";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=4+this.govRules.size() && propertyIndex < 4+this.govRules.size()+this.prompts.size())
        {
            info.type = NameValuePair.class;
            info.name = "prompts";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

