package mdm.cuf.military.summary.active.duty.adapter.vadir.server.service;

import io.micrometer.core.instrument.MeterRegistry;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.repository.MilitaryPersonPollingResult;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.repository.MilitaryPersonPollingResultRepository;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.repository.VadirMilitaryPersonCDCRepository;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.rest.MilitaryServiceHubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import mdm.cuf.military.personnel.active.service.hub.bio.*;
import java.util.Calendar;
import java.util.List;

@Service
public class MilitaryPersonPollingService {


    @Autowired
    private MilitaryPersonPollingResultRepository cdcPollingResultRepository;

    @Autowired
    private VadirMilitaryPersonCDCRepository repository;



    @Autowired
    private MeterRegistry meterRegistry;


    @Scheduled(fixedDelayString = "${info.mdm-cuf-military-summary-active-duty-adapter-vadir-server.scheduled-delay-rate}")
    public void pollForNewChangeRecords() {
        List<MilitaryPersonPollingResult> newEvents = null;
            newEvents = cdcPollingResultRepository.getMilitaryPersonPollingResult();
        // Convert VadirpMilitaryServiceCDC into BIO
        System.out.println("**********+*********"+newEvents.size());
        for(MilitaryPersonPollingResult result:newEvents){
            MilitaryPersonnelActiveServiceHubBio bio = new MilitaryPersonnelActiveServiceHubBio();
            bio.setEdipi(result.getEdipi());
            bio.setTotalActiveSvcDays(result.getTotalActiveSvcDays());
            bio.setSourceSystem("VADIR");
            bio.setOriginatingSourceSystem("originatingSourceSystem");
            bio.setSourceDate(Calendar.getInstance().getTime());
            bio.setSourceSystemUser("VADIR");

            MilitaryServiceHubClient client = new MilitaryServiceHubClient();
            client.pushToMaintenanceEndpoint(bio);

            repository.updateMilitaryServiceCDC(result.getId());

        }
        //Call hub post

    }


}
