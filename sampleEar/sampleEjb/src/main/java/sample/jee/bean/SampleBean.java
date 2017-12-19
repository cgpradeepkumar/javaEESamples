package sample.jee.bean;

import javax.ejb.Stateless;

@Stateless
public class SampleBean implements SampleRemote {

	@Override
	public String greeting(String name) {
		return "Hello " + name + "!";
	}

	@Override
	public String serverInfo() {
		return "Stateless EJB Method SampleBean.serverInfo().";
	}

}
