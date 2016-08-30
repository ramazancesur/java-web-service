package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberInfo", propOrder = {"name", "surname"})
@XmlRootElement(name = "SubscriberInfo")
public class SubscriberInfo {
	    @XmlElement(name = "Name")
	    private String name;

	    @XmlElement(name = "Surname")
	    private String surname;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

}
