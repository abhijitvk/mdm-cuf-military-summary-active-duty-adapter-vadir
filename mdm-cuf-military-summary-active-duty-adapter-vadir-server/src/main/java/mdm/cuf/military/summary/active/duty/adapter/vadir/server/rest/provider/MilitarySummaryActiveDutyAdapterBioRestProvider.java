package mdm.cuf.military.summary.active.duty.adapter.vadir.server.rest.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mdm.cuf.core.api.ServiceResponse;
import mdm.cuf.core.api.CufCommonPullMessageKeys;
import mdm.cuf.core.api.CufCommonPushMessageKeys;
import mdm.cuf.core.api.CufInteractionType;
import mdm.cuf.core.api.CufPullByExampleRequest;
import mdm.cuf.core.api.CufPullOneResponse;
import mdm.cuf.core.api.CufPushRequest;
import mdm.cuf.core.api.CufPushResponse;
import mdm.cuf.core.api.CufStatusRequest;
import mdm.cuf.core.api.CufStatusResponse;
import mdm.cuf.core.server.rest.provider.AbstractRestProvider;
import mdm.cuf.core.messages.MsgKeyGen;
import mdm.cuf.core.rest.OpenAPICommon;
import mdm.cuf.military.summary.active.duty.adapter.vadir.bio.MilitarySummaryActiveDutyAdapterBio;
//import mdm.cuf.military.summary.active.duty.adapter.vadir.server.processor.MilitarySummaryActiveDutyAdapterBioProcessor;

/**
 * The MilitarySummaryActiveDutyAdapterBio Rest endpoint.
 *
 * @author darias
 */
@RequestMapping(value = MilitarySummaryActiveDutyAdapterBioRestProvider.URL_PREFIX)
@RestController
@Tag(name = MilitarySummaryActiveDutyAdapterBioRestProvider.TAG, description = MilitarySummaryActiveDutyAdapterBioRestProvider.DESCRIPTION)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = OpenAPICommon.MESSAGE_200 ),
        @ApiResponse(responseCode = "400", description = OpenAPICommon.MESSAGE_400, content = { @Content(schema =  @Schema(implementation = ServiceResponse.class)) } ),
        @ApiResponse(responseCode = "403", description = OpenAPICommon.MESSAGE_403, content = { @Content(schema =  @Schema(implementation = ServiceResponse.class)) } ),
        @ApiResponse(responseCode = "404", description = OpenAPICommon.MESSAGE_404, content = { @Content(schema =  @Schema(implementation = ServiceResponse.class)) } ),
        @ApiResponse(responseCode = "429", description = OpenAPICommon.MESSAGE_429, content = { @Content(schema =  @Schema(implementation = ServiceResponse.class)) } ),
        @ApiResponse(responseCode = "500", description = OpenAPICommon.MESSAGE_500, content = { @Content(schema =  @Schema(implementation = ServiceResponse.class)) })
})
public class MilitarySummaryActiveDutyAdapterBioRestProvider extends AbstractRestProvider {

    /** The version of this rest endpoint */
    public static final String VERSION = "1";

    /** The URL prefix of this endpoint. */
    public static final String URL_PREFIX = "/cuf/militarysummaryactivedutyadapter/v" + VERSION;
    
    public static final String MAINTENANCE_PREFIX = "/maintenance";

    /** the message keys file url */
    public static final String MSG_KEYS_URL = "swagger/militarysummaryactivedutyadapter-v" + VERSION + "-msg-keys.html";
    
    /** the req's file url */
    public static final String REQUIREMENTS_URL = "features/militarysummaryactivedutyadapter-v" + VERSION + "/index.html";
    
    /** The tag used in swagger documentation. */
    public static final String TAG = "MilitarySummaryActiveDutyAdapterBio";
    
    /** The description that shows up in swagger documentation. */
    public static final String DESCRIPTION = "";

//    @Autowired
//    protected MilitarySummaryActiveDutyAdapterBioProcessor processor;
    
    @RequestMapping(value = "/{militarysummaryactivedutyadapterId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @Operation(summary = "Gets a MilitarySummaryActiveDutyAdapter Bio", description = "Will retrieve a MilitarySummaryActiveDutyAdapter Bio found for the id.")
    @MsgKeyGen(jsr303KeyClasses={CufPullByExampleRequest.class}, keyInterfaces={CufCommonPullMessageKeys.class})
    public ResponseEntity<CufPullOneResponse<MilitarySummaryActiveDutyAdapterBio>> pull(@PathVariable final Long militarysummaryactivedutyadapterId) {
        final CufPullByExampleRequest<MilitarySummaryActiveDutyAdapterBio> cufPullRequest = new CufPullByExampleRequest<>();
        if(militarysummaryactivedutyadapterId != null){
            MilitarySummaryActiveDutyAdapterBio example = new MilitarySummaryActiveDutyAdapterBio();
            example.setMilitarySummaryActiveDutyAdapterId(militarysummaryactivedutyadapterId);
            cufPullRequest.setPullByExampleBio(example);    
        }
        return null;
        //return new ResponseEntity<>(processor.pullOneByExample(cufPullRequest), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/status/{txAuditId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @Operation(summary  = "Get status for a MilitarySummaryActiveDutyAdapter save or update transaction.", description = "Will retrieve status of the MilitarySummaryActiveDutyAdapter transaction.")
    @MsgKeyGen(jsr303KeyClasses = { CufStatusRequest.class }, keyInterfaces = { CufCommonPushMessageKeys.class })
    public ResponseEntity<CufStatusResponse<MilitarySummaryActiveDutyAdapterBio>> status(@PathVariable final String txAuditId) {
        final CufStatusRequest cufStatusRequest = new CufStatusRequest();
        cufStatusRequest.setTxAuditId(txAuditId);
        return null;
//        return new ResponseEntity<>(processor.status(cufStatusRequest), HttpStatus.OK);
    }

    
	@RequestMapping(value = "/attendedPush", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @Operation(summary  = "Adds a new MilitarySummaryActiveDutyAdapter Bio.", description = "Will add the given MilitarySummaryActiveDutyAdapter Bio, subject to business rules validation.")
	@MsgKeyGen(jsr303KeyClasses = { CufPushRequest.class, MilitarySummaryActiveDutyAdapterBio.class }, keyInterfaces = {
			CufCommonPushMessageKeys.class })
	public ResponseEntity<CufPushResponse<MilitarySummaryActiveDutyAdapterBio>> attendedPush(
			@RequestBody final CufPushRequest<MilitarySummaryActiveDutyAdapterBio> cufPushRequest) {
    return null;
//		return new ResponseEntity<>(processor.push(cufPushRequest, CufInteractionType.ATTENDED), HttpStatus.OK);
	}

	@RequestMapping(value = "/unattendedPush", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @Operation(summary  = "Adds a new MilitarySummaryActiveDutyAdapter Bio.", description = "Will add the given MilitarySummaryActiveDutyAdapter Bio, subject to business rules validation.")
	@MsgKeyGen(jsr303KeyClasses = { CufPushRequest.class, MilitarySummaryActiveDutyAdapterBio.class }, keyInterfaces = {
			CufCommonPushMessageKeys.class })
	public ResponseEntity<CufPushResponse<MilitarySummaryActiveDutyAdapterBio>> unattendedPush(
			@RequestBody final CufPushRequest<MilitarySummaryActiveDutyAdapterBio> cufPushRequest) {
    return null;
//		return new ResponseEntity<>(processor.push(cufPushRequest, CufInteractionType.UNATTENDED), HttpStatus.OK);
	}

}
