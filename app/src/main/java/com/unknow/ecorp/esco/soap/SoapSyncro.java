package com.unknow.ecorp.esco.soap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SoapSyncro  {

    private static String NAMESPACE = "http://tempuri.org/";
    private static String URL="http://192.168.0.12:8080/webservicetest/Service1.asmx";

    private static String METHOD_NAME_SUMA = "suma";
    private static String SOAP_ACTION_SUMA = "http://tempuri.org/suma";
    private static String METHOD_NAME_CLIMA = "clima";
    private static String SOAP_ACTION_CLIMA = "http://tempuri.org/clima";
    private static String METHOD_NAME_GETLISTADOPELICULAS = "getListadoPeliculas";
    private static String SOAP_ACTION_GETLISTADOPELICULAS = "http://tempuri.org/getListadoPeliculas";

    private static String lastError;

    public static String getLastError()
    {
        return lastError;
    }

    public static void setLastError(String lastError)
    {
        SoapSyncro.lastError = lastError;
    }

    public static float suma(Float sumando1, Float sumando2)
    {
        float result = 0.0F;

        lastError = "";

        SoapObject request = new SoapObject(SoapSyncro.NAMESPACE, SoapSyncro.METHOD_NAME_SUMA);

        request.addProperty("sumando1", sumando1.toString());
        request.addProperty("sumando2", sumando2.toString());

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);

        HttpTransportSE transporte = new HttpTransportSE(URL);

        try
        {
            transporte.call(SOAP_ACTION_SUMA, envelope);
            SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
            result = Float.parseFloat(resultado_xml.toString());
        }
        catch (Exception e)
        {
            lastError = e.getMessage();
        }

        return result;
    }

    public static float clima(String abrev)
    {
        float result = 0.0F;

        lastError = "";

        SoapObject request = new SoapObject(SoapSyncro.NAMESPACE, SoapSyncro.METHOD_NAME_CLIMA);

        request.addProperty("localidad", abrev);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);

        HttpTransportSE transporte = new HttpTransportSE(URL);

        try
        {
            transporte.call(SOAP_ACTION_CLIMA, envelope);
            SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
            result = Float.parseFloat(resultado_xml.toString());
        }
        catch (Exception e)
        {
            lastError = e.getMessage();
        }

        return result;
    }

    public static String getListadoPeliculas()
    {
        String result = "";

        lastError = "";

        SoapObject request = new SoapObject(SoapSyncro.NAMESPACE, SoapSyncro.METHOD_NAME_GETLISTADOPELICULAS);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);

        HttpTransportSE transporte = new HttpTransportSE(URL);

        try
        {
            transporte.call(SOAP_ACTION_GETLISTADOPELICULAS, envelope);
            SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
            result = resultado_xml.toString();
        }
        catch (Exception e)
        {
            lastError = e.getMessage();
        }

        return result;
    }
}
