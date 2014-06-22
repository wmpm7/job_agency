package job_agency.job_agency.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class CalcStatistic extends RouteBuilder{

	@Override
	public void configure() throws Exception {	

		from("timer://foo?period=30000")
		.routeId("StatisticCalculator-Route")
		.setBody(constant("select * from Person"))
		.to("jdbc:dataSource")
		.log("All persons read from DB")
		.beanRef("CalcStatisticBean","addToList")
		.beanRef("CalcStatisticBean","calc")
		//.beanRef("TransformationBean","makeUpperCase")
		.log("Statistics calculated and can be found in folder outbound/statistics!")
		.setHeader(Exchange.FILE_NAME, constant("statistic.txt"))
		.convertBodyTo(String.class, "UTF-8")
		.to("file://outbound/statistics?charset=UTF-8")
		.to("jms:WebsiteQueue")
		.to("jms:graphicQueue");

	}

}
