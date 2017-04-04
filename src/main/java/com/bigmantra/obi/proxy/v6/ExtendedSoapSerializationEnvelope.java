package com.bigmantra.obi.proxy.v6;

//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.*;
import org.kxml2.io.KXmlParser;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import java.io.StringReader;
import java.io.StringWriter;

//If you have a compilation error here then you have to add a reference to ExKsoap2.jar to your project (you can find it in Libs folder in the generated zip file)
public class ExtendedSoapSerializationEnvelope extends com.easywsdl.exksoap2.serialization.ExSoapSerializationEnvelope {
    static HashMap< java.lang.String,java.lang.Class> classNames = new HashMap< java.lang.String, java.lang.Class>();
    static {
        classNames.put("urn://oracle.bi.webservices/v6^^SAWLocale",SAWLocale.class);
        classNames.put("urn://oracle.bi.webservices/v6^^LogonParameter",LogonParameter.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SAWSessionParameters",SAWSessionParameters.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ReportRef",ReportRef.class);
        classNames.put("urn://oracle.bi.webservices/v6^^Variable",Variable.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ReportParams",ReportParams.class);
        classNames.put("urn://oracle.bi.webservices/v6^^NameValuePair",NameValuePair.class);
        classNames.put("urn://oracle.bi.webservices/v6^^TemplateInfoInstance",TemplateInfoInstance.class);
        classNames.put("urn://oracle.bi.webservices/v6^^TemplateInfo",TemplateInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^NameValueArrayPair",NameValueArrayPair.class);
        classNames.put("urn://oracle.bi.webservices/v6^^Account",Account.class);
        classNames.put("urn://oracle.bi.webservices/v6^^AccessControlToken",AccessControlToken.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ACL",ACL.class);
        classNames.put("urn://oracle.bi.webservices/v6^^Privilege",Privilege.class);
        classNames.put("urn://oracle.bi.webservices/v6^^UpdateACLParams",UpdateACLParams.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ItemInfo",ItemInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^AuthResult",AuthResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SessionEnvironment",SessionEnvironment.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ErrorInfo",ErrorInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^CatalogObject",CatalogObject.class);
        classNames.put("urn://oracle.bi.webservices/v6^^GetSubItemsFilter",GetSubItemsFilter.class);
        classNames.put("urn://oracle.bi.webservices/v6^^GetSubItemsParams",GetSubItemsParams.class);
        classNames.put("urn://oracle.bi.webservices/v6^^UpdateCatalogItemACLParams",UpdateCatalogItemACLParams.class);
        classNames.put("urn://oracle.bi.webservices/v6^^XMLQueryExecutionOptions",XMLQueryExecutionOptions.class);
        classNames.put("urn://oracle.bi.webservices/v6^^QueryResults",QueryResults.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ReportHTMLOptions",ReportHTMLOptions.class);
        classNames.put("urn://oracle.bi.webservices/v6^^StartPageParams",StartPageParams.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SAWException",SAWException.class);
        classNames.put("urn://oracle.bi.webservices/v6^^JobInfo_detailedInfo",JobInfo_detailedInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^JobInfo",JobInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^JobStats",JobStats.class);
        classNames.put("urn://oracle.bi.webservices/v6^^FileInfo",FileInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SegmentationOptions",SegmentationOptions.class);
        classNames.put("urn://oracle.bi.webservices/v6^^TreeNodePath",TreeNodePath.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SAColumn",SAColumn.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SATable",SATable.class);
        classNames.put("urn://oracle.bi.webservices/v6^^SASubjectArea",SASubjectArea.class);
        classNames.put("urn://oracle.bi.webservices/v6^^ImportError",ImportError.class);
        classNames.put("urn://oracle.bi.webservices/v6^^CatalogItemsFilter",CatalogItemsFilter.class);
        classNames.put("urn://oracle.bi.webservices/v6^^PathMapEntry",PathMapEntry.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getSessionVariables",getSessionVariables.class);
        classNames.put("urn://oracle.bi.webservices/v6^^copyItem2",copyItem2.class);
        classNames.put("urn://oracle.bi.webservices/v6^^readObjects",readObjects.class);
        classNames.put("urn://oracle.bi.webservices/v6^^writeObjects",writeObjects.class);
        classNames.put("urn://oracle.bi.webservices/v6^^updateCatalogItemACL",updateCatalogItemACL.class);
        classNames.put("urn://oracle.bi.webservices/v6^^setOwnership",setOwnership.class);
        classNames.put("urn://oracle.bi.webservices/v6^^setItemAttributes",setItemAttributes.class);
        classNames.put("urn://oracle.bi.webservices/v6^^setItemProperty",setItemProperty.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getPermissions",getPermissions.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getPrivilegesStatus",getPrivilegesStatus.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getAccounts",getAccounts.class);
        classNames.put("urn://oracle.bi.webservices/v6^^forgetAccounts",forgetAccounts.class);
        classNames.put("urn://oracle.bi.webservices/v6^^renameAccounts",renameAccounts.class);
        classNames.put("urn://oracle.bi.webservices/v6^^joinGroups",joinGroups.class);
        classNames.put("urn://oracle.bi.webservices/v6^^leaveGroups",leaveGroups.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getGroups",getGroups.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getMembers",getMembers.class);
        classNames.put("urn://oracle.bi.webservices/v6^^isMember",isMember.class);
        classNames.put("urn://oracle.bi.webservices/v6^^evaluateCondition",evaluateCondition.class);
        classNames.put("urn://oracle.bi.webservices/v6^^evaluateInlineCondition",evaluateInlineCondition.class);
        classNames.put("urn://oracle.bi.webservices/v6^^sendMessage",sendMessage.class);
        classNames.put("urn://oracle.bi.webservices/v6^^purgeLog",purgeLog.class);
        classNames.put("urn://oracle.bi.webservices/v6^^PromptedColumnInfo",PromptedColumnInfo.class);
        classNames.put("urn://oracle.bi.webservices/v6^^arrayOfGUIDs",arrayOfGUIDs.class);
        classNames.put("urn://oracle.bi.webservices/v6^^PathMap",PathMap.class);
        classNames.put("urn://oracle.bi.webservices/v6^^keepAlive",keepAlive.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getSessionVariablesResult",getSessionVariablesResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getSubItemsResult",getSubItemsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^readObjectsResult",readObjectsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^writeObjectsResult",writeObjectsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getPromptedFiltersResult",getPromptedFiltersResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getGlobalPrivilegesResult",getGlobalPrivilegesResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getPermissionsResult",getPermissionsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getPrivilegesStatusResult",getPrivilegesStatusResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getAccountsResult",getAccountsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getGroupsResult",getGroupsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getMembersResult",getMembersResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getConditionCustomizableReportElementsResult",getConditionCustomizableReportElementsResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^getSubjectAreasResult",GetSubjectAreasResult.class);
        classNames.put("urn://oracle.bi.webservices/v6^^importResult",importResult.class);
    }   

    protected static final int QNAME_NAMESPACE = 0;
    private static final String TYPE_LABEL = "type";

    public ExtendedSoapSerializationEnvelope() {
        this(SoapEnvelope.VER11);
    }

    public ExtendedSoapSerializationEnvelope(int soapVersion) {
        super(soapVersion);
        implicitTypes = true;
        setAddAdornments(false);
        new MarshalGuid().register(this);
        new MarshalFloat().register(this);
    }

    

    @Override
    protected void writeProperty(XmlSerializer writer, java.lang.Object obj, PropertyInfo type) throws IOException {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (obj == null || obj== SoapPrimitive.NullNilElement) {
            writer.attribute(xsi, version >= VER12 ? NIL_LABEL : NULL_LABEL, "true");
            return;
        }
        if(writeReferenceObject(writer,obj))
        {
            return;
        }
        java.lang.Object[] qName = getInfo(null, obj);
        if (!type.multiRef && qName[2] == null )
        {

            if (!implicitTypes || (obj.getClass() != type.type && !(obj instanceof Vector ) && type.type!=java.lang.String.class  )) {
                java.lang.String xmlName=Helper.getKeyByValue(classNames,obj.getClass());
                if(xmlName!=null) {
                    java.lang.String[] parts = xmlName.split("\\^\\^");
                    java.lang.String prefix = writer.getPrefix(parts[0], true);
                    writer.attribute(xsi, TYPE_LABEL, prefix + ":" + parts[1]);
                }
                else
                {
                    if(type.type instanceof String) {
                        java.lang.String xsdPrefix = writer.getPrefix(xsd, true);
                        java.lang.String myType = (java.lang.String) type.type;
                        java.lang.String[] parts = myType.split("\\^\\^");
                        if (parts.length == 2) {
                            xsdPrefix = writer.getPrefix(parts[0], true);
                            myType = parts[1];
                        }

                        writer.attribute(xsi, TYPE_LABEL, xsdPrefix + ":" + myType);
                    }
                    else
                    {
                        java.lang.String prefix = writer.getPrefix(type.namespace, true);
                        writer.attribute(xsi, TYPE_LABEL, prefix + ":" + obj.getClass().getSimpleName());
                    }

                }
            }
            //super.writeProperty(writer,obj,type);

            //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
            //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
            writeElement(writer, obj, type, qName[QNAME_MARSHAL]);
        }
        else {
            super.writeProperty(writer, obj, type);
        }
    }
    public SoapObject GetExceptionDetail(Element detailElement,java.lang.String exceptionElementNS,java.lang.String exceptionElementName)
    {
        int index=detailElement.indexOf(exceptionElementNS,exceptionElementName,0);
        if(index>-1)
        {
            Element errorElement=detailElement.getElement(index);
            return GetSoapObject(errorElement);
        }
        return null;
    }

    public SoapObject GetSoapObject(Element detailElement) {
        try{
            XmlSerializer xmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            detailElement.write(xmlSerializer);
            xmlSerializer.flush();

            XmlPullParser xpp = new KXmlParser();
            xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);

            xpp.setInput(new StringReader(writer.toString()));
            xpp.nextTag();
            SoapObject soapObj = new SoapObject(detailElement.getNamespace(),detailElement.getName());
            readSerializable(xpp,soapObj);
            return soapObj;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public java.lang.Object GetHeader(Element detailElement) {
        if(detailElement.getChildCount()>0 && detailElement.getText(0)!=null)
        {
            SoapPrimitive primitive = new SoapPrimitive(detailElement.getNamespace(),detailElement.getName(),detailElement.getText(0));
            return  primitive;
        }
    
        return GetSoapObject(detailElement);
    }
    
    public java.lang.Object get(java.lang.Object soap,java.lang.Class cl,boolean typeFromClass)
    {
        if(soap==null)
        {
            return null;
        }
        try
        {
            if(soap instanceof Vector || typeFromClass)
            {
                Constructor ctor = cl.getConstructor(java.lang.Object.class,ExtendedSoapSerializationEnvelope.class);
                return ctor.newInstance(soap,this);
            }
            java.lang.Object refAttr=getReference(soap);
            if (refAttr != null)
            {
                return refAttr;
            }
            else
            {
                if(soap instanceof SoapObject)
                {
                    if(cl ==SoapObject.class)
                    {
                        return soap;
                    }
                    java.lang.String key=String.format("%s^^%s",((SoapObject)soap).getNamespace(),((SoapObject)soap).getName());
                    if(classNames.containsKey(key))
                    {
                        cl=classNames.get(key);
                    }
                }
                Constructor ctor = cl.getConstructor(java.lang.Object.class,ExtendedSoapSerializationEnvelope.class);
                return ctor.newInstance(soap,this);
            }
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public java.lang.Object getSpecificType(java.lang.Object obj)
    {
        if(obj==null)
        {
            return null;
        }
        if(obj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)obj;
            java.lang.String key=soapObject.getNamespace()+"^^"+soapObject.getName();
            if(classNames.containsKey(key))
            {
                java.lang.Class cl=classNames.get(key);
                try
                {
                    java.lang.reflect.Constructor ctor  = cl.getConstructor(java.lang.Object.class,ExtendedSoapSerializationEnvelope.class);
                    return ctor.newInstance(soapObject,this);
                } 
                catch (java.lang.Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        return obj;
    }

    public static java.lang.Object getXSDType(java.lang.Object param)
    {
        if(param==null)
        {
            return null;
        }
        java.lang.Class obj=param.getClass();
        if(obj.equals(java.lang.String.class))
        {
            return "string";
        }
        if(obj.equals(int.class) || obj.equals(java.lang.Integer.class))
        {
            return "int";
        }
        if(obj.equals(float.class) || obj.equals(java.lang.Float.class))
        {
            return "float";
        }
        if(obj.equals(double.class) || obj.equals(java.lang.Double.class))
        {
            return "double";
        }
        if(obj.equals(java.math.BigDecimal.class))
        {
            return "decimal";
        }
        if(obj.equals(short.class) || obj.equals(java.lang.Short.class))
        {
            return "short";
        }
        if(obj.equals(long.class) || obj.equals(java.lang.Long.class))
        {
            return "long";
        }
        if(obj.equals(boolean.class) || obj.equals(java.lang.Boolean.class))
        {
            return "boolean";
        }
        java.lang.String xmlName=Helper.getKeyByValue(classNames,obj);
        if(xmlName==null)
        {
            return obj;
        }
        return xmlName;
    }
} 

