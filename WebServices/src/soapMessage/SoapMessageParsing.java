package soapMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.jar.Attributes.Name;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

public class SoapMessageParsing {
	   private static final String USERNAME_TOKEN_STRING = "UsernameToken";
	    private static final String USERNAME_STRING = "Username";
	    private static final String ARG_0_STRING = "arg0";
	    private static final String PASSWORD_STRING = "Password";
	    private static final String NONCE_STRING = "Nonce";
	    private static final String CREATED_STRING = "Created";

	    private static final Logger LOGGER = LoggerFactory.getLogger(SoapMessageParsing.class);

	    private SOAPMessageContext messageContext;
	    private SOAPMessage message;
	    private SOAPEnvelope envelope;
	    private SOAPHeader header;
	    private SOAPBody body;
	
	    public SoapMessageParsing(SOAPMessageContext messageContext) {
	        this.messageContext = messageContext;
	        this.message = messageContext.getMessage();
	        try {
	            this.envelope = message.getSOAPPart().getEnvelope();
	            this.header = envelope.getHeader();
	            this.body = envelope.getBody();
	        } catch (SOAPException e) {
	            e.printStackTrace();
	        }
	       
	    }

	    private String getSOAPMessageAsString(SOAPMessage msg) {

	        try {
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            msg.writeTo(baos);
	            return baos.toString();

	        } catch (IOException ioe) {
	            System.out.println("Could not extract XML from soap message");
	            return null;
	        } catch (SOAPException se) {
	            System.out.println("Could not extract XML from soap message");
	            return null;
	        }
	    }

	    private SOAPElement extractUserNameInfo(Iterator childElems) {

	        System.out.println("extractUserNameInfo called.");

	        SOAPElement child = null;
	        Name sName;

	        // iterate through child elements
	        while (childElems.hasNext()) {
	            Object elem = childElems.next();

	            if (elem instanceof SOAPElement) {

	                // Get child element and its name
	                child = (SOAPElement) elem;
	                sName = (Name) child.getElementName();

	                // Check whether there is a UserNameToken element
	                if (!USERNAME_TOKEN_STRING.equalsIgnoreCase(((Node) sName).getLocalName())) {

	                    if (child.getChildElements().hasNext()) { // TODO check logic
	                        return extractUserNameInfo(child.getChildElements());
	                    }
	                }
	            }
	        }

	        return child;
	    }
	    
	    private SOAPElement extractTCIInfo(Iterator childElems) {

	        System.out.println("extractTCIInfo called.");

	        SOAPElement child = null;
	        Name sName;

	        // iterate through child elements
	        while (childElems.hasNext()) {
	            Object elem = childElems.next();

	            if (elem instanceof SOAPElement) {

	                // Get child element and its name
	                child = (SOAPElement) elem;
	                sName = (Name) child.getElementName();

	                // Check whether there is a UserNameToken element
	                if (!ARG_0_STRING.equalsIgnoreCase(((Node) sName).getLocalName())) {

	                    if (child.getChildElements().hasNext()) {
	                        return extractTCIInfo(child.getChildElements());
	                    }
	                }
	            }
	        }

	        return child;
	    }

	    
	    

	    
}
