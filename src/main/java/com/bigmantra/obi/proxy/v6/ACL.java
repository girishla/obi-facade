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

public class ACL extends AttributeContainer implements KvmSerializable
{

    
    public String dummy;
    
    public ArrayList< AccessControlToken> accessControlTokens =new ArrayList<AccessControlToken >();

    public ACL ()
    {
    }

    public ACL (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("accessControlTokens"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.accessControlTokens==null)
                        {
                            this.accessControlTokens = new ArrayList< AccessControlToken>();
                        }
                        java.lang.Object j =obj;
                        AccessControlToken j1= (AccessControlToken)__envelope.get(j,AccessControlToken.class,false);
                        this.accessControlTokens.add(j1);
                   
        
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
            return this.dummy!=null?this.dummy:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.accessControlTokens.size())
        {
            return this.accessControlTokens.get(propertyIndex-(1));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+accessControlTokens.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dummy";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.accessControlTokens.size())
        {
            info.type = AccessControlToken.class;
            info.name = "accessControlTokens";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

