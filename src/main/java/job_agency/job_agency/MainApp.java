package job_agency.job_agency;

import job_agency.job_agency.routes.MyRouteBuilder;

import org.apache.camel.spring.Main;

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
        main.addRouteBuilder(new MyRouteBuilder());
        //main.addRouteBuilder(new MyPublishSubscribe());
        //main.addRouteBuilder(new MyMessageFilter());
        main.run(args);
    }

}

