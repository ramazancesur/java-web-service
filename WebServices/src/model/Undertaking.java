package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Undertaking",
        propOrder = {
                "id",
                "sortId",
                "commitmentDate",
                "amount"
        })
@XmlRootElement(name = "Commitment")

public class Undertaking {
	 @XmlElement(name = "Id")
	    private String id;

	    @XmlElement(name = "SortId")
	    private int sortId;

	    @XmlElement(name = "CommitmentDate")
	    private Date commitmentDate;

	    @XmlElement(name = "Amount")
	    private Double amount;

}
