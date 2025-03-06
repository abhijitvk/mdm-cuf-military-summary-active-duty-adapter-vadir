package mdm.cuf.military.summary.active.duty.adapter.vadir.server.rest;

import jakarta.annotation.PostConstruct;
import mdm.cuf.core.api.CufPushRequest;
import mdm.cuf.core.api.CufPushResponse;
import mdm.cuf.core.rest.client.AbstractRestClient;
import mdm.cuf.core.rest.client.DefaultRestClientErrorHandler;
import mdm.cuf.military.personnel.active.service.hub.bio.MilitaryPersonnelActiveServiceHubBio;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.MilitarySummaryActiveDutyAdapterServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class MilitaryServiceHubClient extends AbstractRestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(MilitaryServiceHubClient.class);

    private RestTemplate restTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @Value("${mdm-cuf.instance-system-name}")
    private String systemName;

    @Autowired
    protected Environment environment;

    @Autowired
    protected MilitarySummaryActiveDutyAdapterServerProperties properties;

    private static final ParameterizedTypeReference<CufPushResponse<MilitaryPersonnelActiveServiceHubBio>> CONTACT_INFO_BIO_TYPE_REF =
            new ParameterizedTypeReference<>(){};

    @PostConstruct
    public void setupRestTemplate() {
        restTemplate = getDefaultRestTemplate();
        restTemplate.setErrorHandler(new DefaultRestClientErrorHandler("contactInfoRestClient", HttpStatus.BAD_REQUEST));

    }

    public CufPushResponse<MilitaryPersonnelActiveServiceHubBio> pushToMaintenanceEndpoint(MilitaryPersonnelActiveServiceHubBio bio) {
        CufPushRequest<MilitaryPersonnelActiveServiceHubBio> cufPushRequest = new CufPushRequest<>();
        cufPushRequest.setBio(bio);

        // Add hint if skipPushToPartner is true


        HttpEntity<CufPushRequest<MilitaryPersonnelActiveServiceHubBio>> requestEntity = new HttpEntity<>(cufPushRequest);
        RestTemplate customRestTemplate = new RestTemplate();
        ResponseEntity<CufPushResponse<MilitaryPersonnelActiveServiceHubBio>> responseEntityString =
                customRestTemplate.exchange(
                        "http://localhost:9090/militarypersonnelactiveservicehub/v1/masterDataPush",
                        HttpMethod.POST,
                        requestEntity,
                        CONTACT_INFO_BIO_TYPE_REF);

        return responseEntityString.getBody();
    }

}
