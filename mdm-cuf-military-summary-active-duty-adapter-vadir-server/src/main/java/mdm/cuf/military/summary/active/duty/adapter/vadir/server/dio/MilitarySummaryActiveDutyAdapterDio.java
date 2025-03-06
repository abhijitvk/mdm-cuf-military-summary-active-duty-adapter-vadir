package mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.envers.Audited;

import mdm.cuf.core.server.persist.dio.AbstractDio;

/**
 * The militarysummaryactivedutyadapter data information object.
 *
 * @author darias
 */
@Entity
@Table(name = "MILITARYSUMMARYACTIVEDUTYADAPTER")
@SequenceGenerator(name = "militarySummaryActiveDutyAdapterIdSeq", sequenceName = "MILITARYSUMMARYACTIVEDUTYADAPTER_S", allocationSize = 1)
@Audited
public class MilitarySummaryActiveDutyAdapterDio extends AbstractDio<Long>{

	/** The militarysummaryactivedutyadapter id. */
	private Long militarySummaryActiveDutyAdapterId;
	
	private String demoField;

	@Id
    @GeneratedValue(generator = "militarySummaryActiveDutyAdapterIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "MILITARYSUMMARYACTIVEDUTYADAPTER_ID", nullable = false)
    public Long getMilitarySummaryActiveDutyAdapterId() {
        return militarySummaryActiveDutyAdapterId;
    }
    
    public void setMilitarySummaryActiveDutyAdapterId(final Long militarySummaryActiveDutyAdapterId) {
        this.militarySummaryActiveDutyAdapterId = militarySummaryActiveDutyAdapterId;
    }
    
    @Column(name = "DEMO_FIELD", nullable = true)
    public String getDemoField() {
        return demoField;
    }

	public void setDemoField(String demoField) {
	    this.demoField = demoField;
	}

	@Override
    @Transient
    public Long getUniqueId() {
        return getMilitarySummaryActiveDutyAdapterId();
    }

}
