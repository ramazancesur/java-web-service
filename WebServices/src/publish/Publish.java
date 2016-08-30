package publish;

import javax.xml.ws.Endpoint;

import webService.PaymentWebServiceImp;

public class Publish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Endpoint.publish("http://localhost:9999/ws/hello", new PaymentWebServiceImp());
	}

}
