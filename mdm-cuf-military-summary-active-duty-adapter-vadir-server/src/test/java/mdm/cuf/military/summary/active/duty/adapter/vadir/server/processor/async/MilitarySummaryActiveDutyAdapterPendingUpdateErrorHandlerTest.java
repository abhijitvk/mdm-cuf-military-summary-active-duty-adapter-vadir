//package mdm.cuf.military.summary.active.duty.adapter.vadir.server.processor.async;
//
//
//import org.junit.Test;
//import mdm.cuf.core.api.async.AsyncStatus;
//import mdm.cuf.core.api.async.CufAsyncHandlerResponse;
//import mdm.cuf.core.api.async.CufPendingUpdateInstruction;
//import static org.mockito.Mockito.mock;
//import static org.junit.Assert.assertTrue;
//
//public class MilitarySummaryActiveDutyAdapterPendingUpdateErrorHandlerTest{
//
//    MilitarySummaryActiveDutyAdapterPendingUpdateErrorHandler subject = new MilitarySummaryActiveDutyAdapterPendingUpdateErrorHandler();
//
//    @Test
//    public void testHandle(){
//        CufAsyncHandlerResponse response = subject.handle(mock(CufPendingUpdateInstruction.class));
//        assertTrue(response.getStatus().equals(AsyncStatus.COMPLETED_SUCCESS));
//    }
//}