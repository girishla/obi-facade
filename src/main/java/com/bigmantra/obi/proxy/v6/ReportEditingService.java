package com.bigmantra.obi.proxy.v6;




//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------




import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.kxml2.kdom.Element;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReportEditingService
{
    interface IWcfMethod
    {
        ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    String url="http://pelobidev2.projected.ltd.uk:9704/analytics/saw.dll?SoapImpl=reportService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public ReportEditingService(){}

    public ReportEditingService(String url)
    {
        this.url = url;
    }

    public ReportEditingService(String url,int timeOut)
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

        
    public java.lang.Object applyReportParams(final ReportRef reportRef,final ReportParams reportParams,final Boolean encodeInString,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (java.lang.Object)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","reportRef",new ReportRef().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","reportParams",new ReportParams().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "applyReportParams");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="reportRef";
                __info.type=ReportRef.class;
                __info.setValue(reportRef);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="reportParams";
                __info.type=ReportParams.class;
                __info.setValue(reportParams);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="encodeInString";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(encodeInString);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return __envelope.getSpecificType(j);
                }
                else if (obj!= null && obj instanceof java.lang.Object){
                    return (java.lang.Object)obj;
                }
                return null;
            }
        },"#applyReportParams",__profile);
    }
    
    public String generateReportSQL(final ReportRef reportRef,final ReportParams reportParams,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (String)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","reportRef",new ReportRef().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","reportParams",new ReportParams().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "generateReportSQL");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="reportRef";
                __info.type=ReportRef.class;
                __info.setValue(reportRef);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="reportParams";
                __info.type=ReportParams.class;
                __info.setValue(reportParams!=null?reportParams:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return j.toString();
                }
                else if (obj!= null && obj instanceof String){
                    return (String)obj;
                }
                return null;
            }
        },"#generateReportSQL",__profile);
    }
    
    public String applyReportDefaults(final ReportRef reportRefs,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (String)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","reportRefs",new ReportRef().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "applyReportDefaults");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="reportRefs";
                __info.type=ReportRef.class;
                __info.setValue(reportRefs);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(sessionID!=null?sessionID:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("reportXml");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return j.toString();
                }
                else if (obj!= null && obj instanceof String){
                    return (String)obj;
                }
                return null;
            }
        },"#applyReportDefaults",__profile);
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


