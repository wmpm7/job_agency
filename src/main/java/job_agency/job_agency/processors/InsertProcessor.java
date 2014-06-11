package job_agency.job_agency.processors;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.jfree.util.Log;

public class InsertProcessor implements Processor {

	@Override
	public void process(Exchange arg0) throws Exception {
		Questionnaire qu = arg0.getIn().getBody(Questionnaire.class);
		String date="";
		StringBuilder sqlstmt;
		date = qu.person.getBirthday().getYear() + "-";
		
		if (qu.person.getBirthday().getMonth()<10){
			date = date + "0";
		}
		date = date + qu.person.getBirthday().getMonth() + "-";
		
		if (qu.person.getBirthday().getDay()<10){
			date = date + "0";
		}
		date = date + qu.person.getBirthday().getDay();
		/*if (qu.person.getBirthday().getDay()<10){
			date = "0";
		}
		date = date + qu.person.getBirthday().getDay() + "-";
		
		if (qu.person.getBirthday().getMonth()<10){
			date = date + "0";
		}
		date = date + qu.person.getBirthday().getMonth() + "-" + qu.person.getBirthday().getYear();
*/
		sqlstmt = new StringBuilder("insert into Person ");
		sqlstmt.append("(username,firstname,lastname,sex,birthday,postalcode,city,country,educationself,educationmother,educationfather,email) "); 
		sqlstmt.append("values ('");
		sqlstmt.append(qu.person.getUser()).append("','"); 
		sqlstmt.append(qu.person.getFirstName()).append("','"); 
		sqlstmt.append(qu.person.getLastName()).append("','"); 
		sqlstmt.append(qu.person.getSex()).append("','"); 
		//+ "TO_DATE( '" + date + "', 'DD-MM-YYYY' ),'"
		sqlstmt.append(date).append("','");
		sqlstmt.append(qu.person.getAddress().getPostalcode()).append("','");
		sqlstmt.append(qu.person.getAddress().getCity()).append("','");
		sqlstmt.append(qu.person.getAddress().getCountry()).append("','"); 
		sqlstmt.append(qu.person.getHighesteducation().getSelf()).append("','"); 
		sqlstmt.append(qu.person.getHighesteducation().getMother()).append("','"); 
		sqlstmt.append(qu.person.getHighesteducation().getFather()).append("','"); 
		sqlstmt.append(qu.person.getEmail()).append("')");
		
		Log.info("Questionnaire:   " + sqlstmt.toString());
		
		arg0.getIn().setBody(sqlstmt.toString());
		
	}

}
