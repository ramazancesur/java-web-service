package webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.GetLoanRequest;
import model.PaymentInfoResponse;

@WebService
public interface PaymentService {
	 @WebMethod
	 PaymentInfoResponse getLoan(GetLoanRequest getLoanRequest);
}
