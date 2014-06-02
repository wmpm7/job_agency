package job_agency.job_agency.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class CalcStatistic extends RouteBuilder{

	@Override
	public void configure() throws Exception {	

		//PERIOD = 60000 --> every minute

		//calculates the statistic only with personal data
		// => joboffers currently not needed
		//in case adjust sql-statement or second block with joboffers
		
		from("timer://foo?period=30000")
		.routeId("StatisticCalculator-Route")
		.setBody(constant("select * from Person"))
		.to("jdbc:dataSource")
		.log("All persons read from DB")
		.beanRef("CalcStatisticBean","addToList")
		.beanRef("CalcStatisticBean","calc")
		.beanRef("TransformationBean","makeUpperCase")
		.log("Statistics calculated and can be found in folder outbound/statistics!")
		.setHeader(Exchange.FILE_NAME, constant("statistic.txt"))
		.to("file://outbound/statistics")
		.to("jms:EmailQueue");

//		from("timer://foo?period=60000")
//		.setBody(constant("select count(*) from Person where sex ='m'"))
//		.to("jdbc:dataSource")
//		.log("Anzahl männlicher Personen wird ausgelesen")
//		.to("jms:EmailQueue");
	}

}
