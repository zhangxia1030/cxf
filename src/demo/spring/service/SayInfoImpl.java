package demo.spring.service;

import javax.jws.WebService;

@WebService(endpointInterface = "demo.spring.service.SayInfo")
public class SayInfoImpl implements SayInfo {

	public String sayHi() {
		return "Hi me!!";
	}

	public String setUser(String id, int age) {
		return id+","+age;
	}

}
