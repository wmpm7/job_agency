package job_agency.job_agency.processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.StringWriter;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class JpgAggregation implements AggregationStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(JpgAggregation.class);

	@Override
	public Exchange aggregate(Exchange statistic, Exchange image) {

		
		Document document = new Document();
	    String input = "outbound/statistics/graphics/FemaleMalePieChart.jpeg"; // .gif and .jpg are ok too!
	    String output = "outbound/statistics/graphics/FemaleMalePieChart.pdf";
	    try {
	      FileOutputStream fos = new FileOutputStream(output);
	      PdfWriter writer = PdfWriter.getInstance(document, fos);
	      writer.open();
	      document.open();
	      document.add(Image.getInstance(input));
	      document.close();
	      writer.close();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
		
		
		return null;
	}

 
	
//    public Exchange aggregate(Exchange original, Exchange resource) {
//    	
//    	return resource;
//		try {
//			
//	    	if(original == null)
//	    	{
//	    		return resource;
//	    	}
//	    	else if(resource == null)
//	    	{
//	    		return original;
//	    	}
//	    	
//	    	String originalBody = original.getIn().getBody(String.class);
//	    	File image = resource.getIn().getBody(File.class);
//	    	
//	        LOG.info("*********************** original: " + originalBody);
//	        LOG.info("________________________ resource: " + image);
//	        FileInputStream imageInFile;
//	        String imageDataString = "";
//	        
//			imageInFile = new FileInputStream(image);
//			
//	        byte imageData[] = new byte[(int) image.length()];
//	        imageInFile.read(imageData);
//	        
//	        imageDataString = Base64.encodeBase64URLSafeString(imageData);
//	        
//	        originalBody = originalBody + "\n";
//	        String str = Base64.encodeBase64URLSafeString(originalBody.getBytes()) + imageDataString;
//
//	        str = new String(Base64.decodeBase64(str.getBytes()));
//
//            imageInFile.close();
//            
//            
//            if (original.getPattern().isOutCapable()) {
//                original.getOut().setBody(str);
////                original.getOut().setBody(mergeResult);
//            } else {
//                original.getIn().setBody(str);
//            }
//            
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        return original;

        
//        SequenceInputStream mergeResult = new SequenceInputStream(originalBody, image);
////        byte arr[] = {'1', '2', '3', '4'};
//        
//        String str = "";
//        try {
//        	StringWriter writer = new StringWriter();
//        	IOUtils.copy(mergeResult, writer);
//        	str = writer.toString();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        
////        String str = new String(arr);
////        LOG.info("xxxxxxxxxxxxxxxxxxxxxxxxxxx arr: " + str);

        
//        if (original.getPattern().isOutCapable()) {
//            original.getOut().setBody(str);
////            original.getOut().setBody(mergeResult);
//        } else {
//            original.getIn().setBody(str);
//        }
//        return original;
//    }
	
//    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
//        if (oldExchange == null) {
////        	String body = newExchange.getIn().getBody(String.class).split("Ort:")[0];
////            newExchange.getIn().setBody("Titles: " + body.substring(6) + "; ");
//            return newExchange;
//        }
//        
//        LOG.info("***********************" + oldExchange.getIn().getBody().toString());
//        LOG.info("________________________" + newExchange.getIn().getBody().toString());
//
////        String body1 = oldExchange.getIn().getBody(String.class);
////        String body2 = newExchange.getIn().getBody(String.class).split("Ort:")[0].substring(6);
//// 
////        oldExchange.getIn().setBody(body1 + body2 + "; ");
// 
//        return oldExchange;
//    }
}