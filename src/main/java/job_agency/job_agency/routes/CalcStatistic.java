package job_agency.job_agency.routes;

import job_agency.job_agency.beans.CalcStatisticBean;
import job_agency.job_agency.beans.TransformationBean;
import job_agency.job_agency.processors.getallJobofferProcessor;
import job_agency.job_agency.processors.getallPersonProcessor;

import org.apache.camel.builder.RouteBuilder;

public class CalcStatistic extends RouteBuilder{

	@Override
	public void configure() throws Exception {	


		//berechnet anzahl der Joboffers
		//würde auch leichter gehen mit einem count habs aber so gemacht damit man sieht wie man
		//die daten in eine arrayliste haut
		from("timer://foo?period=30000")
		.setBody(constant("select * from Joboffer"))
		.to("jdbc:dataSource")
		.log("alle Joboffers werden ausgelesen")
		//.process(new getallJobofferProcessor())
		.beanRef("CalcStatisticBean","addToList")
		.beanRef("CalcStatisticBean","calc")
		.beanRef("CalcStatisticBean","makeUpperCase")
		//.to("jms:EmailQueue");
		.to("file://outbound");

		//nur da damit man sieht wie man alle persons in eine Arraylist bekommt
		from("timer://foo?period=30000")
		.setBody(constant("select * from Person"))
		.to("jdbc:dataSource")
		.log("alle Persons werden ausgelesen")
		//.process(new getallPersonProcessor())
		.beanRef("CalcStatisticBean","addToList")
		.beanRef("CalcStatisticBean","calc")
		.beanRef("CalcStatisticBean","makeUpperCase")
		.to("file://outbound");


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
