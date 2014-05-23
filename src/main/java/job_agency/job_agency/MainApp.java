package job_agency.job_agency;

import job_agency.job_agency.routes.MyRouteBuilder;
import org.apache.camel.spring.Main;

public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        //main.addRouteBuilder(new MyPublishSubscribe());
        //main.addRouteBuilder(new MyMessageFilter());
        main.run(args);
    }
}

