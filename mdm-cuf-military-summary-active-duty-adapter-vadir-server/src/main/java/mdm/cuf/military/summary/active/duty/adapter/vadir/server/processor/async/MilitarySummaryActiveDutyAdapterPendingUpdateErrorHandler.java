//package mdm.cuf.military.summary.active.duty.adapter.vadir.server.processor.async;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//import mdm.cuf.core.api.async.AsyncStatus;
//import mdm.cuf.core.api.async.CufAsyncHandlerResponse;
//import mdm.cuf.core.api.async.CufPendingUpdateInstruction;
//import mdm.cuf.core.server.logging.LogUtil;
//import mdm.cuf.core.server.processor.async.pendingupdate.PendingUpdateErrorHandler;
//
///**
// * A PendingUpdateErrorHandler implementation that will receive CufPendingUpdateInstruction messages from the pending update error topic.
// *
// * @author jshrader
// */
//@Component
//@Primary
//public class MilitarySummaryActiveDutyAdapterPendingUpdateErrorHandler implements PendingUpdateErrorHandler {
//
//    /** The Constant LOGGER. */
//    private static final Logger LOGGER = LoggerFactory.getLogger(MilitarySummaryActiveDutyAdapterPendingUpdateErrorHandler.class);
//
//    @Override
//    public CufAsyncHandlerResponse handle(CufPendingUpdateInstruction cufPendingUpdateInstruction) {
//        LogUtil.logInfoWithBanner(LOGGER, "Pending Update Error Handler", "The following CufPendingUpdateInstruction was received in this handler: " + cufPendingUpdateInstruction);
//        CufAsyncHandlerResponse response = new CufAsyncHandlerResponse();
//        response.setStatus(AsyncStatus.COMPLETED_SUCCESS);
//        return response;
//    }
//
//}
