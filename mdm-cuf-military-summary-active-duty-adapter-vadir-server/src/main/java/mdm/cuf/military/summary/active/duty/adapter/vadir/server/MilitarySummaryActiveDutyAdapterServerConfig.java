package mdm.cuf.military.summary.active.duty.adapter.vadir.server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import mdm.cuf.core.server.MdmCufCoreServerConfig;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.rest.provider.MilitarySummaryActiveDutyAdapterServerRestProviderConfig;

/**
 * This is the main Spring config class for this module, it should declare any additional packages to scan declare any beans, supply
 * any other annotations etc.
 *
 * @author darias
 */

@Configuration
@ComponentScan(basePackages = "mdm.cuf.military.summary.active.duty.adapter.vadir.server", excludeFilters = @Filter(Configuration.class))
@Import({MdmCufCoreServerConfig.class,MilitarySummaryActiveDutyAdapterServerRestProviderConfig.class})
public class MilitarySummaryActiveDutyAdapterServerConfig {


}

