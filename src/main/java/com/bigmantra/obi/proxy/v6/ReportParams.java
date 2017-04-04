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

public class ReportParams extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< String> filterExpressions =new ArrayList<String >();
    
    public ArrayList< Variable> variables =new ArrayList<Variable >();
    
    public ArrayList< NameValuePair> nameValues =new ArrayList<NameValuePair >();
    
    public ArrayList< TemplateInfo> templateInfos =new ArrayList<TemplateInfo >();
    
    public String viewName;

    public ReportParams ()
    {
    }

    public ReportParams (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("filterExpressions"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.filterExpressions==null)
                        {
                            this.filterExpressions = new ArrayList< String>();
                        }
                        java.lang.Object j =obj;
                        String j1= j.toString();
                        this.filterExpressions.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("variables"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.variables==null)
                        {
                            this.variables = new ArrayList< Variable>();
                        }
                        java.lang.Object j =obj;
                        Variable j1= (Variable)__envelope.get(j,Variable.class,false);
                        this.variables.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("nameValues"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.nameValues==null)
                        {
                            this.nameValues = new ArrayList< NameValuePair>();
                        }
                        java.lang.Object j =obj;
                        NameValuePair j1= (NameValuePair)__envelope.get(j,NameValuePair.class,false);
                        this.nameValues.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("templateInfos"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.templateInfos==null)
                        {
                            this.templateInfos = new ArrayList< TemplateInfo>();
                        }
                        java.lang.Object j =obj;
                        TemplateInfo j1= (TemplateInfo)__envelope.get(j,TemplateInfo.class,false);
                        this.templateInfos.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("viewName"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.viewName = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.viewName = (String)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.filterExpressions.size())
        {
            return this.filterExpressions.get(propertyIndex-(0));
        }
        if(propertyIndex>=0+this.filterExpressions.size() && propertyIndex < 0+this.filterExpressions.size()+this.variables.size())
        {
            return this.variables.get(propertyIndex-(0+this.filterExpressions.size()));
        }
        if(propertyIndex>=0+this.filterExpressions.size()+this.variables.size() && propertyIndex < 0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size())
        {
            return this.nameValues.get(propertyIndex-(0+this.filterExpressions.size()+this.variables.size()));
        }
        if(propertyIndex>=0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size() && propertyIndex < 0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size()+this.templateInfos.size())
        {
            return this.templateInfos.get(propertyIndex-(0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size()));
        }
        if(propertyIndex==0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size()+this.templateInfos.size())
        {
            return this.viewName!=null?this.viewName:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+filterExpressions.size()+variables.size()+nameValues.size()+templateInfos.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.filterExpressions.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "filterExpressions";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.filterExpressions.size() && propertyIndex < 0+this.filterExpressions.size()+this.variables.size())
        {
            info.type = Variable.class;
            info.name = "variables";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.filterExpressions.size()+this.variables.size() && propertyIndex < 0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size())
        {
            info.type = NameValuePair.class;
            info.name = "nameValues";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size() && propertyIndex < 0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size()+this.templateInfos.size())
        {
            info.type = TemplateInfo.class;
            info.name = "templateInfos";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==0+this.filterExpressions.size()+this.variables.size()+this.nameValues.size()+this.templateInfos.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "viewName";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

