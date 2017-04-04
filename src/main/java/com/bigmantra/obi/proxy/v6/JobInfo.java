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

public class JobInfo extends AttributeContainer implements KvmSerializable
{

    
    public JobStats jobStats;
    
    public ArrayList< FileInfo> fileInfo =new ArrayList<FileInfo >();
    
    public JobInfo_detailedInfo detailedInfo;

    public JobInfo ()
    {
    }

    public JobInfo (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("jobStats"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.jobStats = (JobStats)__envelope.get(j,JobStats.class,false);
                    }
                    continue;
                }
                if (info.name.equals("fileInfo"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.fileInfo==null)
                        {
                            this.fileInfo = new ArrayList< FileInfo>();
                        }
                        java.lang.Object j =obj;
                        FileInfo j1= (FileInfo)__envelope.get(j,FileInfo.class,false);
                        this.fileInfo.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("detailedInfo"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.detailedInfo = (JobInfo_detailedInfo)__envelope.get(j,JobInfo_detailedInfo.class,false);
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
            return jobStats;
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.fileInfo.size())
        {
            return this.fileInfo.get(propertyIndex-(1));
        }
        if(propertyIndex==1+this.fileInfo.size())
        {
            return this.detailedInfo!=null?this.detailedInfo:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+fileInfo.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = JobStats.class;
            info.name = "jobStats";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.fileInfo.size())
        {
            info.type = FileInfo.class;
            info.name = "fileInfo";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1+this.fileInfo.size())
        {
            info.type = JobInfo_detailedInfo.class;
            info.name = "detailedInfo";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

