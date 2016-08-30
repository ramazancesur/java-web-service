package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( name = "PaymentInfoResponse", propOrder = {"refId", "loans",})
@XmlRootElement(name = "PaymentInfoResponse")
public class PaymentInfoResponse extends ResponseMessage {
	 @XmlElement(name = "ReferenceId")
	    private String refId;

	    @XmlElementWrapper(name = "Loans")
	    @XmlElement(name = "Loan")
	    private List<Loan> loans;

		public String getRefId() {
			return refId;
		}

		public void setRefId(String refId) {
			this.refId = refId;
		}

		public List<Loan> getLoans() {
			return loans;
		}

		public void setLoans(List<Loan> loans) {
			this.loans = loans;
		}
	    
	    
	    

}
