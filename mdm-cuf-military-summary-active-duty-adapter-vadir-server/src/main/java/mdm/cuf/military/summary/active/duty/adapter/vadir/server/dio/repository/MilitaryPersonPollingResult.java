package mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.repository;


import jakarta.persistence.*;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.VadirMilitaryServiceCDC;

@SqlResultSetMapping(
        name = "getMilitaryPersonPollingResult",
        classes = {
                @ConstructorResult(
                        targetClass = MilitaryPersonPollingResult.class,
                        columns = {
                                @ColumnResult(name = "TOTAL_ACTIVE_SVC_DAYS_NBR", type=Long.class),
                                @ColumnResult(name = "EDIPI", type=String.class),
                                @ColumnResult(name = "VADIR_MLTRY_SUMMARY_CDC_ID", type=Long.class),
                                @ColumnResult(name = "status", type=String.class)
                        }
                )
        }
)
@NamedNativeQuery(name = "MilitaryPersonPollingResult.getMilitaryPersonPollingResult",
        resultSetMapping = "getMilitaryPersonPollingResult",
        query = "select a1.TOTAL_ACTIVE_SVC_DAYS_NBR, a1.EDIPI , a1.VADIR_MLTRY_SUMMARY_CDC_ID , a1.status \n" +
                "   from VADIR_MLTRY_SUMMARY_CDC a1 where a1.status='A'\n" )

@Entity
public class MilitaryPersonPollingResult extends VadirMilitaryServiceCDC {

    public MilitaryPersonPollingResult(){
        // Default empty constructor
    }

    public MilitaryPersonPollingResult(Long totalActiveSvcDays, String edipi, Long id, String status){
        this.setTotalActiveSvcDays(totalActiveSvcDays);
        this.setEdipi(edipi);
        this.setId(id);
        this.setStatus(status);

    }

}
