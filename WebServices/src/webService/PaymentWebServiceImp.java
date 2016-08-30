package webService;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.GetLoanRequest;
import model.Loan;
import model.PaymentInfoResponse;
import model.Undertaking;


@WebService(
        serviceName = "PaymentService",
        portName = "PaymentServicePort",
        targetNamespace = "DeptorServices",
        endpointInterface = "aras.law.webservice.payment.PaymentWebServiceImp"
)
@SOAPBinding(
        parameterStyle = SOAPBinding.ParameterStyle.BARE
)
@HandlerChain(file = "chain/payment_handler_chain.xml")
public class PaymentWebServiceImp implements PaymentService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentWebServiceImp.class);

    @Resource
    private WebServiceContext webServiceContext;
    
	@Override
	public PaymentInfoResponse getLoan(@WebParam(name = "GetLoanRequest") GetLoanRequest getLoanRequest) {
		
	    // işlemleri yapın...
		
		 PaymentInfoResponse response = null;
	        String refId = UUID.randomUUID().toString();
	        try {
	            response = new PaymentInfoResponse();
	            response.setRefId(refId);
	        
	            response.setResponseCode("0");
	            if(true) {
	                response.setErrorFields("300", "Bu Abone Numarasına Ait Kayıt Bulunamadı");
	                response.setResponseCode("1");
	            }
	        
	        }  catch (RuntimeException runtimeException) {
	            response.setErrorFields("599", "Serverda Bilinmeyen Bir Nedenden Ötürü Hata Meydana Geldi");
	            LOGGER.error("WEB SERVICE ERROR - (RuntimeException) : ", runtimeException);
	        } finally {
	            webServiceContext.getMessageContext().put("responseCode", response.getResponseCode());
	            webServiceContext.getMessageContext().put("refId", refId);
	        }

	        return response;
	}

}
