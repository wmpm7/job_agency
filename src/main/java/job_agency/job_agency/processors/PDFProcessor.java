package job_agency.job_agency.processors;

import job_agency.job_agency.models.PDFUtil;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.codec.binary.Base64;

public class PDFProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
//        String body = exchange.getIn().getBody(String.class);
//        body = new String(Base64.decodeBase64(body.getBytes()));
        final String body = exchange.getIn().getBody(String.class);
        final String fileNameWithoutExtension = PDFUtil.getFileNameWithoutExtension(exchange);
        final String convertToXSLFOBody = PDFUtil.getFilledXSLFO(body);
        
        exchange.getIn().setBody(convertToXSLFOBody);
        exchange.getIn().setHeader(Exchange.FILE_NAME, fileNameWithoutExtension + ".pdf");
    }

}
