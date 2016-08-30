package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Loan", propOrder = {"fileId", "subscriberInfo", "undertakingList", "totalAmount"})
@XmlRootElement(name = "Loan")
public class Loan {

	 @XmlElement(name = "FileId")
	    private long fileId;

	    @XmlElement(name = "SubscriberInfo")
	    private SubscriberInfo subscriberInfo;

	    @XmlElementWrapper(name = "Commitments")
	    @XmlElement(name = "Commitment")
	    private List<Undertaking> undertakingList;

	    @XmlElement(name = "TotalAmount")
	    private Double totalAmount;
}
