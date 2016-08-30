

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLoanRequest", propOrder = {"subscriberId"})
@XmlRootElement(name = "GetLoanRequest")
public class GetLoanRequest {
	  @XmlElement(name = "SubscriberId", required = true)
	    private String subscriberId;

	    public String getSubscriberId() {
	        return subscriberId;
	    }

	    public void setSubscriberId(String subscriberId) {
	        this.subscriberId = subscriberId;
	    }
}