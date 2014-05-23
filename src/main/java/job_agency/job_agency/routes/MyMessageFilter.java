package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class MyMessageFilter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		/**
    	 * MESSAGE FILTER
    	 */
    	
    	from("file:src/data?noop=true")
    		.filter().xpath("//person/address/country='AUT'")
    			.log("Filter message")
    			.to("file:target/messages/filter");
		
	}

}
