package helper;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class UtilityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityService.class);

    public static String soapMessageToString(SOAPMessage message) throws SOAPException, IOException {
        String result = null;

        if (message != null)
        {
            ByteArrayOutputStream baos = null;
            try
            {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos);
                result = baos.toString();
            }finally {
                if (baos != null)
                {
                    baos.close();
                }
            }
        }
        return result;
    }

    public static String decodeBase64(String request) {
        byte[] decodedBytes = Base64.decodeBase64(request.getBytes());
        LOGGER.info("Decode Request Message : " + new String(decodedBytes));
        return new String(decodedBytes).trim().replaceFirst("^([\\W]+)<", "<");
    }

    public static String encodeBase64(String response) {
        byte[] encodedBytes = Base64.encodeBase64(response.getBytes());
        // System.out.println("---------- Encode Request Message ---------");
        // System.out.println("encodedBytes " + new String(encodedBytes));
        return new String(encodedBytes);
    }

    /**
     * Marshalling supplied object to XML document by JAXB annotations and serializing it to String
     * @param obj object to be marshalled
     * @return serialized XML document
     * @throws MarshalException
     */
    public static String marshal(Object obj) throws MarshalException {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext jc = JAXBContext.newInstance(obj.getClass());
            Marshaller m = jc.createMarshaller();
            //m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(obj, sw);
            return sw.toString();
        } catch( JAXBException jbe ){
            throw new MarshalException("Error when marshalling " +obj.getClass().getCanonicalName(),jbe);
        }
    }

    /**
     * Unmarshalling itself from XML document by JAXB annotations
     * @param xml xml document serialized as String
     * @param clazz Class to which shoud be object unmarshalled
     * @return serialized XML document
     * @throws JAXBException
     */
    public static Object unmarshal(String xml,Class clazz) throws JAXBException{
        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller u = jc.createUnmarshaller();
        return u.unmarshal(new StringReader(xml));
    }

    public static long generateEightDigtNumber() {
        long timeSeed = System.nanoTime(); // to get the current date time value
        double randSeed = Math.random() * 1000; // random number generation
        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and
        String s = midSeed + "";
        String subStr = s.substring(0, 9);
        int finalSeed = Integer.parseInt(subStr);    // integer value

        return finalSeed;
    }
}
