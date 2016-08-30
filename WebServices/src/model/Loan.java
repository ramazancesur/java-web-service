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

		public long getFileId() {
			return fileId;
		}

		public void setFileId(long fileId) {
			this.fileId = fileId;
		}

		public SubscriberInfo getSubscriberInfo() {
			return subscriberInfo;
		}

		public void setSubscriberInfo(SubscriberInfo subscriberInfo) {
			this.subscriberInfo = subscriberInfo;
		}

		public List<Undertaking> getUndertakingList() {
			return undertakingList;
		}

		public void setUndertakingList(List<Undertaking> undertakingList) {
			this.undertakingList = undertakingList;
		}

		public Double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
	    
	    
}
