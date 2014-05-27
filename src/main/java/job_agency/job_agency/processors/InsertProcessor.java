package job_agency.job_agency.processors;

import job_agency.job_agency.beans.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertProcessor implements Processor {

	@Override
	public void process(Exchange arg0) throws Exception {
		Questionnaire qu = arg0.getIn().getBody(Questionnaire.class);
		String date="";
		String sqlstmt;
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
		sqlstmt = "insert into Person " + 
				"(username,firstname,lastname,sex,birthday,educationself,educationmother,educationfather,email) " + 
				"values (" +  
				"'" + qu.person.getUser() + "','" 
				+ qu.person.getFirstName() + "','" 
				+ qu.person.getLastName() +"','" 
				+ qu.person.getSex() + "'," 
				//+ "TO_DATE( '" + date + "', 'DD-MM-YYYY' ),'"
				+ "'" + date + "','"
				+ qu.person.getHighesteducation().getSelf() + "','" 
				+ qu.person.getHighesteducation().getMother() + "','" 
				+ qu.person.getHighesteducation().getFather() + "','" 
				+ qu.person.getEmail() + "')";
		
		System.out.println("***************Questionnaire:   " + sqlstmt);
		
		arg0.getIn().setBody(sqlstmt);
		
	}

}
