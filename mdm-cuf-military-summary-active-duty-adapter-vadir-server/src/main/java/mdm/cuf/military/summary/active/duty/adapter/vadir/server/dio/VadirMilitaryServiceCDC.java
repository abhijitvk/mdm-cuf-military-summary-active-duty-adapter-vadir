package mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio;

import jakarta.persistence.*;
import mdm.cuf.core.server.persist.dio.AbstractDio;

/**
 * The militarypersonnelactiveserviceadapter data information object.
 *
 * @author mrao
 */
@Entity
@Table(name = "VADIR_MLTRY_SUMMARY_CDC")
@SequenceGenerator(name = "VadirMilitaryServiceCDCIdSeq", sequenceName = "VADIR_MLTRY_SUMMARY_CDC_S", allocationSize = 1)
public class VadirMilitaryServiceCDC extends AbstractDio<Long>{


	private Long id;
	
	private Long totalActiveSvcDays;

    private String edipi;

    private String status;



    @Id
    @GeneratedValue(generator = "VadirMilitaryServiceCDCIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "VADIR_MLTRY_SUMMARY_CDC_ID", nullable = true)
    public Long getId() {
        return id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "TOTAL_ACTIVE_SVC_DAYS_NBR", nullable = false)
    public Long getTotalActiveSvcDays() {
        return totalActiveSvcDays;
    }

    public void setTotalActiveSvcDays(Long totalActiveSvcDays) {
        this.totalActiveSvcDays = totalActiveSvcDays;
    }

    @Column(name = "EDIPI", nullable = false)
    public String getEdipi() {
        return edipi;
    }

    public void setEdipi(String edipi) {
        this.edipi = edipi;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    @Transient
    public Long getUniqueId() {
        return getId();
    }

}
