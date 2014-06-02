package job_agency.job_agency.routes;

import job_agency.job_agency.processors.RecipientListGenerator;
import job_agency.job_agency.processors.getallJobofferProcessor;
import job_agency.job_agency.processors.getallPersonProcessor;

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

		
		
		//CHRISI PUBLISH SUBSCRIBE TEST
		
		//NEWSLETTER
		
		//read email addresses from DB
		//send mails
			//from("timer://foo?period=60000")
			//.setBody(constant("select email from person where newsletter=true union select email from joboffer where newsletter=true"))
			//.setBody(constant("select email from person union select email from joboffer"))
			//.to("jdbc:dataSource")
			//.process(new RecipientListGenerator()).recipientList().tokenize("|");
		
		
		//gmail-account
			//from("file://target/emails?noop=true")
			//.log("Working on file ${header.CamelFileName}")
			//.setHeader("subject", constant("My Subject"))
			//.to("smtp://wmpm.group7@smtp.gmail.com:25?password=blubb123
			//&username=wmpm.group7&mail.smtp.starttls.enable=true&to=kevin17@gmx.at");
		
		
		//from("direct:a").recipientList(header("myHeader").tokenize(","));



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
