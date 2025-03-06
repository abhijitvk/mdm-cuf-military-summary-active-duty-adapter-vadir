package mdm.cuf.military.summary.active.duty.adapter.vadir.server;

import java.util.Arrays;
import mdm.cuf.core.server.MdmCufSpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This is the actual Spring boot application that loads up the entire app.
 *
 * @author darias
 */
@SpringBootApplication
@Import(MilitarySummaryActiveDutyAdapterServerConfig.class)
@ComponentScan(basePackages = "mdm.cuf.military.summary.active.duty.adapter.vadir.server", excludeFilters = @Filter(Configuration.class))
@EnableAsync
@EnableScheduling
public class MilitarySummaryActiveDutyAdapterServerApplication extends SpringBootServletInitializer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MilitarySummaryActiveDutyAdapterServerApplication.class);

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(MilitarySummaryActiveDutyAdapterServerApplication.class);
    }

    public static void main(final String[] args) throws Exception {
        final ConfigurableApplicationContext context = new MdmCufSpringApplicationBuilder(MilitarySummaryActiveDutyAdapterServerApplication.class).build().run(args);
        final String[] profiles = context.getEnvironment().getActiveProfiles();
        if(LOGGER.isInfoEnabled()) 
            LOGGER.info("!!!!!!!!!!!!!!!!!! Active Profiles: "+ Arrays.toString(profiles) + "!!!!!!!!!!!!!!!!");
    }
}


