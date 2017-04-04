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

public class renameAccounts extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< Account> from =new ArrayList<Account >();
    
    public ArrayList< Account> to =new ArrayList<Account >();
    
    public String sessionID;

    public renameAccounts ()
    {
    }

    public renameAccounts (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("from"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.from==null)
                        {
                            this.from = new ArrayList< Account>();
                        }
                        java.lang.Object j =obj;
                        Account j1= (Account)__envelope.get(j,Account.class,false);
                        this.from.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("to"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.to==null)
                        {
                            this.to = new ArrayList< Account>();
                        }
                        java.lang.Object j =obj;
                        Account j1= (Account)__envelope.get(j,Account.class,false);
                        this.to.add(j1);
                   
        
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
        if(propertyIndex>=0 && propertyIndex < 0+this.from.size())
        {
            return this.from.get(propertyIndex-(0));
        }
        if(propertyIndex>=0+this.from.size() && propertyIndex < 0+this.from.size()+this.to.size())
        {
            return this.to.get(propertyIndex-(0+this.from.size()));
        }
        if(propertyIndex==0+this.from.size()+this.to.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+from.size()+to.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.from.size())
        {
            info.type = Account.class;
            info.name = "from";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.from.size() && propertyIndex < 0+this.from.size()+this.to.size())
        {
            info.type = Account.class;
            info.name = "to";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.from.size()+this.to.size())
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

