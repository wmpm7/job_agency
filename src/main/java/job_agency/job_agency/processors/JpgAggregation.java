package job_agency.job_agency.processors;

import job_agency.job_agency.models.PDFUtil;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JpgAggregation implements AggregationStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(JpgAggregation.class);

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
      final String body = oldExchange.getIn().getBody(String.class);
      final String imagePath = newExchange.getIn().getHeader("CamelFilePath", String.class);
      
      LOG.debug("body:" + body);
      LOG.debug("header_path" + imagePath);
      
      String fileNameWithoutExtension = PDFUtil.getFileNameWithoutExtension(oldExchange);
      final String convertToXSLFOBody = PDFUtil.getFilledXSLFO(body, imagePath);
      
      newExchange.getIn().setBody(convertToXSLFOBody);
      newExchange.getIn().setHeader(Exchange.FILE_NAME, fileNameWithoutExtension + ".pdf");
      
	return newExchange;
	}

}