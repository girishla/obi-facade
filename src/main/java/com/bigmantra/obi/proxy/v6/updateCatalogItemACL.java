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

public class updateCatalogItemACL extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< String> path =new ArrayList<String >();
    
    public ACL acl;
    
    public UpdateCatalogItemACLParams options;
    
    public String sessionID;

    public updateCatalogItemACL ()
    {
    }

    public updateCatalogItemACL (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
        
                    
                        if(this.path==null)
                        {
                            this.path = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.path.add(j1);
                   
        
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
                if (info.name.equals("options"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.options = (UpdateCatalogItemACLParams)__envelope.get(j,UpdateCatalogItemACLParams.class,false);
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
        if(propertyIndex>=0 && propertyIndex < 0+this.path.size())
        {
            return this.path.get(propertyIndex-(0));
        }
        if(propertyIndex==0+this.path.size())
        {
            return acl;
        }
        if(propertyIndex==1+this.path.size())
        {
            return options;
        }
        if(propertyIndex==2+this.path.size())
        {
            return this.sessionID!=null?this.sessionID:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3+path.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.path.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "path";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.path.size())
        {
            info.type = ACL.class;
            info.name = "acl";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.path.size())
        {
            info.type = UpdateCatalogItemACLParams.class;
            info.name = "options";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2+this.path.size())
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

