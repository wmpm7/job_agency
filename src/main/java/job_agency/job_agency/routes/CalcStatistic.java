package job_agency.job_agency.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class CalcStatistic extends RouteBuilder{

	@Override
	public void configure() throws Exception {	

		
		//calculates the statistic only with personal data
		// => joboffers currently not needed
		//in case adjust sql-statement or second block with joboffers
		
		from("timer://foo?period=30000")
		.setBody(constant("select * from Person"))
		.to("jdbc:dataSource")
		.log("All persons read from DB")
		.beanRef("CalcStatisticBean","addToList")
		.beanRef("CalcStatisticBean","calc")
		.beanRef("TransformationBean","makeUpperCase")
		.log("statistic calculated")
		.setHeader(Exchange.FILE_NAME, constant("statistic.txt"))
		.to("file://outbound/statistics")
		.to("jms:EmailQueue");

		
		
//		from("timer://foo?period=30000")
//		.setBody(constant("select * from Joboffer"))
//		.to("jdbc:dataSource")
//		.log("alle Joboffers werden ausgelesen")
//		//.process(new getallJobofferProcessor())
//		.beanRef("CalcStatisticBean","addToList")
//		.beanRef("CalcStatisticBean","calc")
//		.beanRef("CalcStatisticBean","makeUpperCase")
//		//.to("jms:EmailQueue");
//		.to("file://outbound/statJob");

//		from("timer://foo?period=60000")
//		.setBody(constant("select count(*) from Person where sex ='m'"))
//		.to("jdbc:dataSource")
//		.log("Anzahl männlicher Personen wird ausgelesen")
//		.to("jms:EmailQueue");
//
//		from("timer://foo?period=60000")
//		.setBody(constant("select count(*) from Person where sex ='w'"))
//		.to("jdbc:dataSource")
//		.log("Anzahl weiblicher Personen wird ausgelesen")
//		.to("jms:EmailQueue");




	}

}
