package mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.repository;

import jakarta.transaction.Transactional;
import mdm.cuf.core.server.persist.EntityRepository;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.VadirMilitaryServiceCDC;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface VadirMilitaryPersonCDCRepository extends EntityRepository<VadirMilitaryServiceCDC, Long> {

    @Modifying
    @Transactional
    @Query("update VadirMilitaryServiceCDC cdc set cdc.status = 'P'" +
            "where cdc.id = ?1 " )
    void updateMilitaryServiceCDC(Long id);

}
