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
import java.math.BigInteger;

public class JobStats extends AttributeContainer implements KvmSerializable
{

    
    public BigInteger jobID=BigInteger.ZERO;
    
    public String jobType;
    
    public String jobUser;
    
    public Enums.JobStats_jobState jobState=Enums.JobStats_jobState.Running;
    
    public String jobTotalMilliSec;
    
    public org.joda.time.DateTime jobStartedTime;
    
    public org.joda.time.DateTime jobFinishedTime;
    
    public String jobIsCancelling;
    
    public SAWException exception;

    public JobStats ()
    {
    }

    public JobStats (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("jobID"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobID = new BigInteger(j.toString());
                            }
                        }
                        else if (obj instanceof BigInteger){
                            this.jobID = (BigInteger)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobType"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobType = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.jobType = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobUser"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobUser = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.jobUser = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobState"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobState = Enums.JobStats_jobState.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof Enums.JobStats_jobState){
                            this.jobState = (Enums.JobStats_jobState)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobTotalMilliSec"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobTotalMilliSec = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.jobTotalMilliSec = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobStartedTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobStartedTime = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.jobStartedTime = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobFinishedTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobFinishedTime = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof org.joda.time.DateTime){
                            this.jobFinishedTime = (org.joda.time.DateTime)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("jobIsCancelling"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.jobIsCancelling = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.jobIsCancelling = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("exception"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.exception = (SAWException)__envelope.get(j,SAWException.class,false);
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
            return this.jobID!=null?this.jobID.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return jobType;
        }
        if(propertyIndex==2)
        {
            return jobUser;
        }
        if(propertyIndex==3)
        {
            return this.jobState!=null?this.jobState.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return jobTotalMilliSec;
        }
        if(propertyIndex==5)
        {
            return this.jobStartedTime!=null?this.jobStartedTime.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==6)
        {
            return this.jobFinishedTime!=null?this.jobFinishedTime.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==7)
        {
            return jobIsCancelling;
        }
        if(propertyIndex==8)
        {
            return this.exception!=null?this.exception:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 9;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobID";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobType";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobUser";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobState";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobTotalMilliSec";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobStartedTime";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobFinishedTime";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==7)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jobIsCancelling";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
        if(propertyIndex==8)
        {
            info.type = SAWException.class;
            info.name = "exception";
            info.namespace= "urn://oracle.bi.webservices/v6";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}

