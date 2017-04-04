package com.bigmantra.obi.proxy.v6;




//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------


import java.math.BigInteger;


import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.kxml2.kdom.Element;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JobManagementService
{
    interface IWcfMethod
    {
        ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    String url="http://pelobidev2.projected.ltd.uk:9704/analytics/saw.dll?SoapImpl=jobManagementService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public JobManagementService(){}

    public JobManagementService(String url)
    {
        this.url = url;
    }

    public JobManagementService(String url,int timeOut)
    {
        this.url = url;
        this.timeOut=timeOut;
    }

    protected org.ksoap2.transport.Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }
    
    protected ExtendedSoapSerializationEnvelope createEnvelope()
    {
        ExtendedSoapSerializationEnvelope envelope= new ExtendedSoapSerializationEnvelope(ExtendedSoapSerializationEnvelope.VER11);
        return envelope;
    }
    
    protected java.util.List sendRequest(String methodName,ExtendedSoapSerializationEnvelope envelope,org.ksoap2.transport.Transport transport ,com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile )throws java.lang.Exception
    {
        if(transport instanceof com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE )
        {
            return ((com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE)transport).call(methodName, envelope,httpHeaders,null,profile);
        }
        else
        {
            return ((com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE)transport).call(methodName, envelope,httpHeaders,null,profile);
        }  
    }

    java.lang.Object getResult(java.lang.Class destObj,java.lang.Object source,String resultName,ExtendedSoapSerializationEnvelope __envelope) throws java.lang.Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                java.lang.Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                java.lang.Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                java.lang.Object instance=__envelope.get(j,destObj,false);
                return instance;
            }
            else if( soap.getName().equals(resultName)) {
                java.lang.Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
       }

       return null;
    }

        
    public JobInfo writeListFiles(final ReportRef report,final ReportParams reportParams,final String segmentPath,final TreeNodePath treeNodePath,final SegmentationOptions segmentationOptions,final String filesystem,final BigInteger timeout,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","report",new ReportRef().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","reportParams",new ReportParams().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","treeNodePath",new TreeNodePath().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","segmentationOptions",new SegmentationOptions().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "writeListFiles");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="report";
                __info.type=ReportRef.class;
                __info.setValue(report!=null?report:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="reportParams";
                __info.type=ReportParams.class;
                __info.setValue(reportParams!=null?reportParams:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="treeNodePath";
                __info.type=TreeNodePath.class;
                __info.setValue(treeNodePath!=null?treeNodePath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentationOptions";
                __info.type=SegmentationOptions.class;
                __info.setValue(segmentationOptions!=null?segmentationOptions:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="filesystem";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(filesystem);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="timeout";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(timeout!=null?timeout.toString():SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#writeListFiles",__profile);
    }
    
    public JobInfo getJobInfo(final BigInteger jobID,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getJobInfo");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="jobID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(jobID!=null?jobID.toString():SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#getJobInfo",__profile);
    }
    
    public JobInfo cancelJob(final BigInteger jobID,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "cancelJob");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="jobID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(jobID!=null?jobID.toString():SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#cancelJob",__profile);
    }
    
    public JobInfo getCounts(final String segmentPath,final String treePath,final SegmentationOptions segmentationOptions,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","segmentationOptions",new SegmentationOptions().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getCounts");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="treePath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(treePath!=null?treePath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentationOptions";
                __info.type=SegmentationOptions.class;
                __info.setValue(segmentationOptions!=null?segmentationOptions:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#getCounts",__profile);
    }
    
    public PromptedColumnInfo getPromptedColumns(final String segmentPath,final String treePath,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (PromptedColumnInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getPromptedColumns");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="treePath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(treePath!=null?treePath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (PromptedColumnInfo)getResult(PromptedColumnInfo.class,__result,"ColumnInfo",__envelope);
            }
        },"#getPromptedColumns",__profile);
    }
    
    public JobInfo purgeCache(final String segmentPath,final String treePath,final Boolean ignoreCacheRef,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "purgeCache");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="treePath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(treePath!=null?treePath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="ignoreCacheRef";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(ignoreCacheRef!=null?ignoreCacheRef:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#purgeCache",__profile);
    }
    
    public JobInfo prepareCache(final String segmentPath,final String treePath,final Boolean refresh,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "prepareCache");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="treePath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(treePath!=null?treePath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="refresh";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(refresh!=null?refresh:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#prepareCache",__profile);
    }
    
    public JobInfo saveResultSet(final String segmentPath,final TreeNodePath treeNodePath,final String savedSegmentPath,final SegmentationOptions segmentationOptions,final String SRCustomLabel,final Boolean appendStaticSegment,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","treeNodePath",new TreeNodePath().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","segmentationOptions",new SegmentationOptions().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "saveResultSet");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="treeNodePath";
                __info.type=TreeNodePath.class;
                __info.setValue(treeNodePath!=null?treeNodePath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="savedSegmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(savedSegmentPath!=null?savedSegmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentationOptions";
                __info.type=SegmentationOptions.class;
                __info.setValue(segmentationOptions!=null?segmentationOptions:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="SRCustomLabel";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(SRCustomLabel!=null?SRCustomLabel:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="appendStaticSegment";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(appendStaticSegment!=null?appendStaticSegment:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#saveResultSet",__profile);
    }
    
    public JobInfo deleteResultSet(final String targetLevel,final arrayOfGUIDs GUIDs,final String segmentPath,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (JobInfo)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","GUIDs",new arrayOfGUIDs().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "deleteResultSet");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="targetLevel";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(targetLevel);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="GUIDs";
                __info.type=PropertyInfo.VECTOR_CLASS;
                __info.setValue(GUIDs);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="segmentPath";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(segmentPath!=null?segmentPath:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (JobInfo)getResult(JobInfo.class,__result,"jobInfo",__envelope);
            }
        },"#deleteResultSet",__profile);
    }

    
    protected java.lang.Object execute(IWcfMethod wcfMethod,String methodName,com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile) throws java.lang.Exception
    {
        org.ksoap2.transport.Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        ExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport,profile);
            
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    System.out.println("requestDump: "+__httpTransport.requestDump);
                    
                }
                if (__httpTransport.responseDump != null) {
                    System.out.println("responseDump: "+__httpTransport.responseDump);
                }
            }
        }
        java.lang.Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }
    
        
    java.lang.Exception convertToException(org.ksoap2.SoapFault fault,ExtendedSoapSerializationEnvelope envelope)
    {

        return new java.lang.Exception(fault.faultstring);
    }
}


