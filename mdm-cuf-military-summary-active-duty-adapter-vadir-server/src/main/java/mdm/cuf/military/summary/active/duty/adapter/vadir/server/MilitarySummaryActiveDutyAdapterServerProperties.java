package mdm.cuf.military.summary.active.duty.adapter.vadir.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import mdm.cuf.core.AbstractMdmCufCoreProperties;

/**
 * Application properties, they can be wired up by using mdm-cuf-military-summary-active-duty-adapter-vadir placeholder in yml
 *
 * @author darias
 */
@Component
@ConfigurationProperties(prefix = "mdm-cuf-military-summary-active-duty-adapter-vadir")
public class MilitarySummaryActiveDutyAdapterServerProperties extends AbstractMdmCufCoreProperties {

    private String serviceHost;

    public String getServiceHost() {
        return serviceHost;
    }

    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }
}
