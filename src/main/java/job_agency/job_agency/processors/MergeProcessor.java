package job_agency.job_agency.processors;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MergeProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		//"file:target/fromApi/reformat/external_offers_" + 
		String filename = exchange.getIn().getHeader("CamelFileName",String.class).split("_")[2];
		
		String body = "\n\nOffers from external DB:\n\n" + exchange.getIn().getBody(String.class);
		StringBuilder newbody = new StringBuilder();
		String line;
		
		//File file = new File();
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("target/fromApi/aggregated/internal_offers_" + filename));
		while ((line=br.readLine())!=null){
			newbody.append(line + "\n");
		}
		br.close();
		
		exchange.getIn().setBody(newbody.toString() + body);
	}

}
