package mdm.cuf.military.summary.active.duty.adapter.vadir.server.rest.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.MessageSource;

import mdm.cuf.core.security.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.models.OpenAPI;
import mdm.cuf.core.rest.OpenAPICommon;
import org.springdoc.core.models.GroupedOpenApi;
import mdm.cuf.military.summary.active.duty.adapter.vadir.bio.MilitarySummaryActiveDutyAdapterBio;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * The MilitarySummaryActiveDutyAdapterBio Rest End point config, swagger end point registration
 *
 * @author darias
 */

public class MilitarySummaryActiveDutyAdapterServerRestProviderConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MilitarySummaryActiveDutyAdapterServerRestProviderConfig.class);

    @Autowired
    private SecurityProperties properties;

    @Autowired
    private MessageSource messageSource;

    @Value("classpath:service-doc/service-description.md")
    private Resource resource;

    @Bean
    public OpenAPI customOpenAPI() throws IOException {
        String title = "API Demo for Scenario 2 (Mastering of Data: VADIR Adapter)";
        InputStream is = null;
        String description = null;
        try {
            is = resource.getInputStream();
            description = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } finally {
            safeClose(is);
        }
        return OpenAPICommon.createOpenAPI(title, description);
    }

    private static void safeClose(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                LOGGER.warn("InputStream failed to close",e);
            }
        }
    }

    /**
     * Cuf militarysummaryactivedutyadapter bio v1 api.
     *
     * @return the GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi cufMilitarySummaryActiveDutyAdapterBioV1RestApi() {
        return OpenAPICommon.createCommonBioGroupedOpenApi(MilitarySummaryActiveDutyAdapterBio.class, MilitarySummaryActiveDutyAdapterBioRestProvider.VERSION,
                MilitarySummaryActiveDutyAdapterBioRestProvider.URL_PREFIX, messageSource, properties);
    }
}
