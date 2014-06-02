package job_agency.job_agency.processors;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RecipientListGenerator implements Processor{

	@Override
	public void process(Exchange arg0) throws Exception {
		List data = arg0.getIn().getBody(List.class);
		Map m;
		String recList = "";
		for (Object s:data){
			m = (Map) s;
			recList = recList + "smtp://wmpm.group7@smtp.gmail.com:25?password=blubb123&username=wmpm.group7&mail.smtp.starttls.enable=true&to=";
			recList = recList + m.get("EMAIL") + "|";
		}
		recList = recList.substring(0, recList.length()-1);
		System.out.println("header" + arg0.getIn().getHeaders());
		System.out.println(recList);
		arg0.getIn().setBody(recList);
	}

}
