package job_agency.job_agency;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        
        /******/
        /*CamelContext context = new DefaultCamelContext();
        /*context.addRoutes(new MyRouteBuilder());
        /*If you are using Spring to configure the camel context this is automatically done for you; 
        /*though if you are using a pure Java approach then you just need to call the start() method
        /*context.start();
        /******/
        
        //main.addRouteBuilder(new MyRouteBuilder());
        main.addRouteBuilder(new MailRoute());
        main.run(args);
    }

}

