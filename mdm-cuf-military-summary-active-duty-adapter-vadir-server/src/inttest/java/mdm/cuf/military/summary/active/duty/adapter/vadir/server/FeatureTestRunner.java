package mdm.cuf.military.summary.active.duty.adapter.vadir.server;

import mdm.cuf.military.summary.active.duty.adapter.vadir.server.config.MilitarySummaryActiveDutyAdapterTestConfig;
import mdm.cuf.core.server.AbstractMdmCufCoreServerSpringTest;
import mdm.cuf.core.test.cucumber.annotation.SpringCucumberOptions;
import mdm.cuf.core.test.runner.SpringCucumberRunnerKafkaEnabled;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringCucumberRunnerKafkaEnabled.class)
@SpringCucumberOptions(
		glue = { "mdm.cuf.military.summary.active.duty.adapter.vadir" },
        features = { "src/main/resources/static/features" },
        tags = { "@Feature" },
        threads = 10)
@ContextConfiguration(classes = { MilitarySummaryActiveDutyAdapterTestConfig.class})
public class FeatureTestRunner extends AbstractMdmCufCoreServerSpringTest {
}
