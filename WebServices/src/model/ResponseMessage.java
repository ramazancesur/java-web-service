package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ResponseMessage",
        propOrder = {
                "responseCode",
                "response",
                "errorCode",
                "errorDescription"
        })
public class ResponseMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "ResponseCode")
	private String responseCode = "";

	@XmlElement(name = "Response")
	private String response;

	@XmlElement(name = "ErrorCode")
	private String errorCode = "";

	@XmlElement(name = "ErrorDescription")
	private String errorDescription = "";

	public void setErrorFields(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public void setSuccessFields(String responseCode, String response) {
		this.responseCode = responseCode;
		this.response = response;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
