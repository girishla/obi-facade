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


public class SAWSessionService
{
    interface IWcfMethod
    {
        ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    String url="http://pelobidev2.projected.ltd.uk:9704/analytics/saw.dll?SoapImpl=nQSessionService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public SAWSessionService(){}

    public SAWSessionService(String url)
    {
        this.url = url;
    }

    public SAWSessionService(String url,int timeOut)
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

        
    public String logon(final String name,final String password ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (String)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "logon");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="name";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(name!=null?name:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="password";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(password!=null?password:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("sessionID");
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
        },"#logon",__profile);
    }
    
    public AuthResult logonex(final String name,final String password,final SAWSessionParameters sessionparams ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (AuthResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","sessionparams",new SAWSessionParameters().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "logonex");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="name";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(name!=null?name:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="password";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(password!=null?password:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionparams";
                __info.type=SAWSessionParameters.class;
                __info.setValue(sessionparams!=null?sessionparams:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (AuthResult)getResult(AuthResult.class,__result,"return",__envelope);
            }
        },"#logonex",__profile);
    }
    
    public void logoff(final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "logoff");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
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
        },"#logoff",__profile);
    }
    
    public void keepAlive(final keepAlive keepAlive ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","keepAlive",new keepAlive().getClass());
                __envelope.setOutputSoapObject(keepAlive);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"#keepAlive",__profile);
    }
    
    public String getCurUser(final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (String)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getCurUser");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
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
        },"#getCurUser",__profile);
    }
    
    public SessionEnvironment getSessionEnvironment(final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (SessionEnvironment)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getSessionEnvironment");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
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
                return (SessionEnvironment)getResult(SessionEnvironment.class,__result,"return",__envelope);
            }
        },"#getSessionEnvironment",__profile);
    }
    
    public getSessionVariablesResult getSessionVariables(final getSessionVariables getSessionVariables ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getSessionVariablesResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","getSessionVariables",new getSessionVariables().getClass());
                __envelope.setOutputSoapObject(getSessionVariables);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (getSessionVariablesResult)getResult(getSessionVariablesResult.class,__result,"getSessionVariablesResult",__envelope);
            }
        },"#getSessionVariables",__profile);
    }
    
    public String impersonate(final String name,final String password,final String impersonateID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (String)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "impersonate");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="name";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(name!=null?name:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="password";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(password!=null?password:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="impersonateID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(impersonateID!=null?impersonateID:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("sessionID");
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
        },"#impersonate",__profile);
    }
    
    public AuthResult impersonateex(final String name,final String password,final String impersonateID,final SAWSessionParameters sessionparams ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (AuthResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","sessionparams",new SAWSessionParameters().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "impersonateex");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="name";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(name);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="password";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(password);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="impersonateID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(impersonateID);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="sessionparams";
                __info.type=SAWSessionParameters.class;
                __info.setValue(sessionparams!=null?sessionparams:SoapPrimitive.NullNilElement);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (AuthResult)getResult(AuthResult.class,__result,"return",__envelope);
            }
        },"#impersonateex",__profile);
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


