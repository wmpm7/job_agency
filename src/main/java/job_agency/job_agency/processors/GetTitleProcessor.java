package job_agency.job_agency.processors;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTitleProcessor implements Processor{

	private static final Logger LOG = LoggerFactory.getLogger(GetTitleProcessor.class);	

	@Override
	public void process(Exchange exchange) throws Exception {
	    
	    Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    
	    String key = qu.person.getInterest();
	    String who;
	    
	    who = qu.person.getUser();

	    exchange.getIn().setHeader("CamelFileName", "internal_offers_" + who + ".txt"); 
	    String sql = "select * from joboffer where keyword like '" + key + "'";//" + key + "'";
	    LOG.debug(sql);
	    LOG.debug(key);
	    exchange.getIn().setBody(sql);// where keyword = 'Java'");//"+ key.toLowerCase() + "'");
	    
	}
}
