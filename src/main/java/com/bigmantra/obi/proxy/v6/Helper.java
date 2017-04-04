package com.bigmantra.obi.proxy.v6;

//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.DateTimeParser;
import java.util.*;
import org.ksoap2.serialization.*;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;


public class Helper
{
    public static < T, E> T getKeyByValue(java.util.Map< T, E> map, E value) {
        for (java.util.Map.Entry< T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static java.lang.Object getAttribute(AttributeContainer obj,java.lang.String name,java.lang.String namespace)
    {
        for (int i=0;i < obj.getAttributeCount();i++){
            AttributeInfo info = new AttributeInfo();
            obj.getAttributeInfo(i,info);
            if(info.name.equals(name) && info.namespace.equals(namespace))
            {
                return info.getValue();
            }
       }
       return null;
    }
    public static byte[] getBinary(java.lang.Object obj,boolean isSwaRef)
    {
        if (obj != null && obj.getClass().equals(SoapPrimitive.class))
        {
            SoapPrimitive j =(SoapPrimitive) obj;
            if(j.toString()!=null)
            {
                return org.kobjects.base64.Base64.decode(j.toString());
            }
        }
        else if (obj != null && obj.getClass().equals(String.class))
        {
            java.lang.String j =(java.lang.String) obj;
            if(j.toString()!=null)
            {
                return org.kobjects.base64.Base64.decode(j.toString());
            }
        }
        else if (obj!= null && obj instanceof byte[]){
            return (byte[])obj;
        }
        else if (obj != null && obj.getClass().equals(SoapObject.class))
        {
            SoapObject j = (SoapObject)obj;
            if (j.getPropertyCount() > 0)
            {
                return getBinary(j.getProperty(0), isSwaRef);
            }
        }
        return null;
    }    

    public static Element convertToHeader(java.lang.Object obj,java.lang.String namespace,java.lang.String name)
    {
        org.kxml2.kdom.Element parentElement = new org.kxml2.kdom.Element().createElement(namespace,name);
		if(obj==null)
        {
            return parentElement;
        }
        if(obj instanceof  KvmSerializable)
        {
            KvmSerializable soapObject =(KvmSerializable)obj;
            for(int i = 0; i < soapObject.getPropertyCount();i++){
                PropertyInfo info = new PropertyInfo();
                soapObject.getPropertyInfo(i,new Hashtable(),info);
                java.lang.Object value=soapObject.getProperty(i);
                if(value!=null && value!=SoapPrimitive.NullSkip && value!=SoapPrimitive.NullNilElement)
                {
                    info.setValue(value);
                    Element el1= convertToHeader( info.getValue(),info.getNamespace(),info.getName());
                    parentElement.addChild(Node.ELEMENT, el1);
                }
            }
        }
        else if(obj!=null && obj!=SoapPrimitive.NullSkip && obj!=SoapPrimitive.NullNilElement)
        {
            java.lang.String value=obj.toString();
            parentElement.addChild(org.kxml2.kdom.Node.TEXT,value);
        }
        return parentElement;
    }

    public static Element findOutHeader(java.lang.String name,SoapSerializationEnvelope envelope)
    {
        if(envelope.headerIn==null)
        {
            return null;
        }
        for(int i=0;i< envelope.headerIn.length;i++) {
            Element elem=envelope.headerIn[i];
            if(elem.getName().equals(name) && (elem.getChildCount()>0||elem.getAttributeCount()>0))
                return elem;
        }
        return null;
    }

    public static java.lang.Object convertToSoapObject(Element element)
    {
		if(element.getChildCount()==0 || (element.getChildCount()==1 && !(element.getChild(0) instanceof  Element)))
		{
		    SoapPrimitive primitive = new SoapPrimitive(element.getNamespace(),element.getName(),element.getChildCount()==1? element.getText(0):null);
		    return primitive;
		}
		else
		{
            SoapObject obj = new SoapObject(element.getNamespace(),element.getName());
            for (int i=0;i < element.getChildCount();i++)
            {
                Element childElement=element.getElement(i);
                java.lang.Object childObject=convertToSoapObject(childElement);
                if(childObject instanceof SoapObject)
                {
                    SoapObject soapObj= (SoapObject) childObject;
                    obj.addProperty(soapObj.getName(),childObject);
                }
                else
                {
                    SoapPrimitive primitive= (SoapPrimitive) childObject;
                    obj.addProperty(primitive.getName(),primitive);
                }
            }
		    return obj;
		}
	}

	public static org.joda.time.DateTime ConvertFromWebService(java.lang.String strDate)
	{
		DateTimeFormatter parser1 = ISODateTimeFormat.dateTimeParser();
        parser1=parser1.withZoneUTC();
		return parser1.parseDateTime(strDate);
    }

    public static org.joda.time.LocalTime ConvertFromWebServiceTime(java.lang.String strTime)
    {
        DateTimeFormatter parser1 = ISODateTimeFormat.time();
        return parser1.parseLocalTime(strTime);
    }

    public static org.joda.time.LocalDate ConvertFromWebServiceDate(java.lang.String strTime)
    {
        try {
            DateTimeFormatter parser1 = ISODateTimeFormat.date();
            return parser1.parseLocalDate(strTime);
        }
        catch (java.lang.Exception ex)
        {
            DateTimeFormatter parser1 = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-ddZ");
            return parser1.parseLocalDate(strTime);
        }
    }

    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    public static ArrayList< PropertyInfo> getProperties(SoapObject soapObject,String name)
    {
        ArrayList< PropertyInfo> list = new ArrayList< PropertyInfo>();
        int size = soapObject.getPropertyCount();
        for (int i0=0;i0< size;i0++)
        {
            PropertyInfo info=new PropertyInfo();
            soapObject.getPropertyInfo(i0, info);
            java.lang.Object obj = info.getValue();
            if ( info.name.equals(name))
            {
                list.add(info);
            }
        }
        return list;
    }
    
    public static UUID emptyGuid()
    {
        return new UUID(0,0);
    }
}