package job_agency.job_agency;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;


public class WorkflowMain {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		CamelContext cc=new DefaultCamelContext();
		try {
			cc.addRoutes(
			         new RouteBuilder()
			         {
			            @Override
			            public void configure() throws Exception
			            {
			            	from("file:C:/Users/Kevin/Desktop/blub").process(new LoggingProcessor()).bean(new TransformationBean(),"makeUpperCase").to("file:C:/Users/Kevin/Desktop/huhu");
			            	//from("file:C:/Users/Kevin/Desktop/blub").to("file:C:/Users/Kevin/Desktop/huhu");
			            }

			         });
			
			cc.start();
			Thread.sleep(10000);
			cc.stop();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	}

}
