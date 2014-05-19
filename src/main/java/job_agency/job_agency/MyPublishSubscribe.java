package job_agency.job_agency;

import org.apache.camel.builder.RouteBuilder;

public class MyPublishSubscribe extends RouteBuilder{
	
	public void configure(){
	
		/**
		 * PUBLISH SUBSCRIBE HELLO WORLD
		 */
		//from("file:src/data?noop=true")
			//.multicast().to("file:target/messages/others");
		
		from("file:src/data?noop=true")
	    	.multicast().to("file:target/messages/uk", "file:target/messages/others");
		
	}
	

}
