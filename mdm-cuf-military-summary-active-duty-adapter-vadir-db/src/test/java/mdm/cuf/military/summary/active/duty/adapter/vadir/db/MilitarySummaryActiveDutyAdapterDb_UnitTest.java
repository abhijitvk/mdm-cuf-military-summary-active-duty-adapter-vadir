package mdm.cuf.military.summary.active.duty.adapter.vadir.db;

import mdm.cuf.core.db.AbstractMdmCufCoreDbTest;

/**
 * This unit test executes the database schema scripts against an in-memory H2 database in order
 * to enable CI verification of changes to the core VaProfile database schema. This will let us know before the next
 * deployment if there are issues with the database scripts.
 * 
 * @author darias
 */
public class MilitarySummaryActiveDutyAdapterDb_UnitTest extends AbstractMdmCufCoreDbTest {
    
    /** liquibase change log path for mdm-cuf-core-db project */ 
    private static final String LIQUIBASE_CHANGE_LOG_PATH = "classpath:/cuf-militarysummaryactivedutyadapter-database/mdm.cuf.military.summary.active.duty.adapter.vadir-master-changelog.xml";
    
    /** liquibase change log path for mdm-cuf-core-db project */ 
    @Override
    public String getChangeLogPath() {
        return LIQUIBASE_CHANGE_LOG_PATH;
    }

}
