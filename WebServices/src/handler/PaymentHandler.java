package handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import helper.UtilityService;
import soapMessage.SoapMessageParsing;
public class PaymentHandler implements SOAPHandler<SOAPMessageContext>{

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentHandler.class);

	SoapMessageParsing soapMessageParsing;
	long startProcessTime;


	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext smc) {
		// TODO Auto-generated method stub
	

		
		SOAPMessage message = smc.getMessage();
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        try {
            if (!outboundProperty) {
                startProcessTime = System.currentTimeMillis();
                QName opn  = (QName) smc.get(MessageContext.WSDL_OPERATION);
               
                soapMessageParsing = new SoapMessageParsing(smc);
                
            } else {
                LOGGER.info( UtilityService.soapMessageToString(message));
                //soapMessageLog.setReturnCode();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebServiceException e) {
            generateSOAPErrMessage(message, e.getMessage(), e.getMessage());
            e.printStackTrace();
        }finally {
            try {
               LOGGER.info( UtilityService.soapMessageToString(message));
            } catch (SOAPException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
	 private void generateSOAPErrMessage(SOAPMessage message, String returnCode, String returnMessage){
	        try {
	            SOAPFault soapFault = message.getSOAPBody().addFault();
	            soapFault.setFaultCode(returnCode);
	            soapFault.setFaultString(returnMessage);
	            throw new SOAPFaultException(soapFault);
	        }catch(SOAPException e) { }
	    }
}
