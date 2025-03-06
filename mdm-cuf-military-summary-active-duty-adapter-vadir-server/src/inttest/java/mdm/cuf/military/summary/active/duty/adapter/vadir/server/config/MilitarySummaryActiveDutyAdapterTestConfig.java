package mdm.cuf.military.summary.active.duty.adapter.vadir.server.config;

import org.springframework.boot.test.web.client.LocalHostUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan(basePackages = { "mdm.cuf.military.summary.active.duty.adapter.vadir.server" })
public class MilitarySummaryActiveDutyAdapterTestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public LocalHostUriTemplateHandler getLocalHostUriTemplateHandler(Environment environment) {
        return new LocalHostUriTemplateHandler(environment);
    }

}
