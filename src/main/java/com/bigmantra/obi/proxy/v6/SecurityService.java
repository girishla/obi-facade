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


public class SecurityService
{
    interface IWcfMethod
    {
        ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    String url="http://pelobidev2.projected.ltd.uk:9704/analytics/saw.dll?SoapImpl=securityService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public SecurityService(){}

    public SecurityService(String url)
    {
        this.url = url;
    }

    public SecurityService(String url,int timeOut)
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

        
    public getGlobalPrivilegesResult getGlobalPrivileges(final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getGlobalPrivilegesResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getGlobalPrivileges");
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
                return (getGlobalPrivilegesResult)getResult(getGlobalPrivilegesResult.class,__result,"getGlobalPrivilegesResult",__envelope);
            }
        },"#getGlobalPrivileges",__profile);
    }
    
    public ACL getGlobalPrivilegeACL(final String privilegeName,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (ACL)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "getGlobalPrivilegeACL");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="privilegeName";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(privilegeName);
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
                return (ACL)getResult(ACL.class,__result,"acl",__envelope);
            }
        },"#getGlobalPrivilegeACL",__profile);
    }
    
    public void updateGlobalPrivilegeACL(final String privilegeName,final ACL acl,final UpdateACLParams updateACLParams,final String sessionID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","acl",new ACL().getClass());
                __envelope.addMapping("urn://oracle.bi.webservices/v6","updateACLParams",new UpdateACLParams().getClass());
                SoapObject __soapReq = new SoapObject("urn://oracle.bi.webservices/v6", "updateGlobalPrivilegeACL");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="privilegeName";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(privilegeName);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="acl";
                __info.type=ACL.class;
                __info.setValue(acl);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="urn://oracle.bi.webservices/v6";
                __info.name="updateACLParams";
                __info.type=UpdateACLParams.class;
                __info.setValue(updateACLParams!=null?updateACLParams:SoapPrimitive.NullNilElement);
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
        },"#updateGlobalPrivilegeACL",__profile);
    }
    
    public void forgetAccounts(final forgetAccounts forgetAccounts ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","forgetAccounts",new forgetAccounts().getClass());
                __envelope.setOutputSoapObject(forgetAccounts);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"#forgetAccounts",__profile);
    }
    
    public void renameAccounts(final renameAccounts renameAccounts ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","renameAccounts",new renameAccounts().getClass());
                __envelope.setOutputSoapObject(renameAccounts);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"#renameAccounts",__profile);
    }
    
    public void joinGroups(final joinGroups joinGroups ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","joinGroups",new joinGroups().getClass());
                __envelope.setOutputSoapObject(joinGroups);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"#joinGroups",__profile);
    }
    
    public void leaveGroups(final leaveGroups leaveGroups ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","leaveGroups",new leaveGroups().getClass());
                __envelope.setOutputSoapObject(leaveGroups);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"#leaveGroups",__profile);
    }
    
    public getGroupsResult getGroups(final getGroups getGroups ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getGroupsResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","getGroups",new getGroups().getClass());
                __envelope.setOutputSoapObject(getGroups);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (getGroupsResult)getResult(getGroupsResult.class,__result,"getGroupsResult",__envelope);
            }
        },"#getGroups",__profile);
    }
    
    public getMembersResult getMembers(final getMembers getMembers ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getMembersResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","getMembers",new getMembers().getClass());
                __envelope.setOutputSoapObject(getMembers);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (getMembersResult)getResult(getMembersResult.class,__result,"getMembersResult",__envelope);
            }
        },"#getMembers",__profile);
    }
    
    public Boolean isMember(final isMember isMember ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (Boolean)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","isMember",new isMember().getClass());
                __envelope.setOutputSoapObject(isMember);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                SoapObject __soap=(SoapObject)__result;
                java.lang.Object obj = __soap.getProperty("result");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return new Boolean(j.toString());
                }
                else if (obj!= null && obj instanceof Boolean){
                    return (Boolean)obj;
                }
                return null;
            }
        },"#isMember",__profile);
    }
    
    public getPermissionsResult getPermissions(final getPermissions getPermissions ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getPermissionsResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","getPermissions",new getPermissions().getClass());
                __envelope.setOutputSoapObject(getPermissions);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (getPermissionsResult)getResult(getPermissionsResult.class,__result,"getPermissionsResult",__envelope);
            }
        },"#getPermissions",__profile);
    }
    
    public getPrivilegesStatusResult getPrivilegesStatus(final getPrivilegesStatus getPrivilegesStatus ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getPrivilegesStatusResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","getPrivilegesStatus",new getPrivilegesStatus().getClass());
                __envelope.setOutputSoapObject(getPrivilegesStatus);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (getPrivilegesStatusResult)getResult(getPrivilegesStatusResult.class,__result,"getPrivilegesStatusResult",__envelope);
            }
        },"#getPrivilegesStatus",__profile);
    }
    
    public getAccountsResult getAccounts(final getAccounts getAccounts ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (getAccountsResult)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("urn://oracle.bi.webservices/v6","getAccounts",new getAccounts().getClass());
                __envelope.setOutputSoapObject(getAccounts);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (getAccountsResult)getResult(getAccountsResult.class,__result,"getAccountsResult",__envelope);
            }
        },"#getAccounts",__profile);
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


