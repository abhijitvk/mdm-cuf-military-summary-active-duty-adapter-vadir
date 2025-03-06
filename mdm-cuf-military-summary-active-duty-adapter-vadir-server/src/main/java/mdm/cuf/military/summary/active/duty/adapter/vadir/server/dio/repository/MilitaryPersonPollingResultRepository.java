package mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.repository;

import mdm.cuf.core.server.persist.EntityRepository;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.VadirMilitaryServiceCDC;

import java.util.List;


public interface MilitaryPersonPollingResultRepository extends EntityRepository<VadirMilitaryServiceCDC, Long> {

    List<MilitaryPersonPollingResult> getMilitaryPersonPollingResult();


}
