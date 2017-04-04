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


public class ReplicationService
{
    interface IWcfMethod
    {
        ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    String url="http://pelobidev2.projected.ltd.uk:9704/analytics/saw.dll?SoapImpl=replicationService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public ReplicationService(){}

    public ReplicationService(String url)
    {
        this.url = url;
    }

    public ReplicationService(String url,int timeOut)
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

        
    public void export(final String filename,final CatalogItemsFilter filter,final Enums.ExportFlags flag,final Boolean exportSecurity,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","filter",new CatalogItemsFilter().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "export");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="filename";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(filename);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="filter";
                __info.type=CatalogItemsFilter.class;
                __info.setValue(filter);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="flag";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(flag!=null?flag.toString():SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="exportSecurity";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(exportSecurity);
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
                return null;
            }
        },"#export",__profile);
    }
    
    public importResult _import(final String filename,final Enums.ImportFlags flag,final org.joda.time.DateTime lastPurgedLog,final Boolean updateReplicationLog,final Boolean returnErrors,final CatalogItemsFilter filter,final PathMap pathMap,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (importResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","filter",new CatalogItemsFilter().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","pathMap",new PathMap().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "import");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="filename";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(filename);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="flag";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(flag!=null?flag.toString():SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="lastPurgedLog";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(lastPurgedLog!=null?lastPurgedLog.toString():SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="updateReplicationLog";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(updateReplicationLog);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="returnErrors";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(returnErrors);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="filter";
                __info.type=CatalogItemsFilter.class;
                __info.setValue(filter!=null?filter:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="pathMap";
                __info.type=PropertyInfo.VECTOR_CLASS;
                __info.setValue(pathMap!=null?pathMap:SoapPrimitive.NullNilElement);
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
                return (importResult)getResult(importResult.class,__result,"importResult",__envelope);
            }
        },"#import",__profile);
    }
    
    public void markForReplication(final String item,final Boolean replicate,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "markForReplication");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="item";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(item);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="replicate";
                __info.type=PropertyInfo.BOOLEAN_CLASS;
                __info.setValue(replicate);
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
                return null;
            }
        },"#markForReplication",__profile);
    }
    
    public void purgeLog(final purgeLog purgeLog ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","purgeLog",new purgeLog().getClass());
                __envelope.setOutputSoapObject(purgeLog);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"#purgeLog",__profile);
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


