package demo.spring.service;

import javax.jws.WebService;

@WebService
public interface SayInfo {
	
	public String sayHi();
	
	public String setUser(String id, int age);
	
}
