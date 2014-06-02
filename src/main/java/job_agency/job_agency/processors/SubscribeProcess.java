package job_agency.job_agency.processors;

import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscribeProcess implements Processor{
	
	private static final Logger LOG = LoggerFactory.getLogger(SubscribeProcess.class);

	@Override
	public void process(Exchange exchange) throws Exception {
	    LOG.info(exchange.getIn().getBody(String.class));

	    String list = "";
	    String email;
	    String endpoint = "smtp://wmpm.group7@smtp.gmail.com:25?password={{emailPassword}}&username={{emailUsername}}"
	    		+ "&mail.smtp.starttls.enable=true&to=";
	    
	    
	    //list = exchange.getIn().getBody(String.class);
	    //email = list.split(",");
	    //list = endpoint;
	    
	    List<?> data = exchange.getIn().getBody(List.class);

		for(int i =0; i<data.size();i++)
		{
			Map<?, ?> row = (Map<?, ?>)data.get(i);
	    	//email[i] = row.get("EMAIL");
			list = list + endpoint + row.get("EMAIL") + ",";
	    }
		
		list = list.substring(0, list.length()-1);
	    //list = list.substring(1);
	    		
	    exchange.getIn().setHeader("subject", "Newsletter job agency");
	    exchange.getIn().setHeader("recipients", list);
	    
	    exchange.getIn().setBody("Dies ist der newsletter mit der neuesten statistik");
	    exchange.getIn().addAttachment("statistic.pdf", new DataHandler(new FileDataSource("outbound/statistics/pdf/statistic.pdf")));
	}

}