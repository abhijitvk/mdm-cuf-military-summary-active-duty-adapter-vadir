package mdm.cuf.military.summary.active.duty.adapter.vadir.server.processor.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import mdm.cuf.core.messages.Message;
import mdm.cuf.core.server.processor.AbstractBioValidator;
import mdm.cuf.military.summary.active.duty.adapter.vadir.bio.MilitarySummaryActiveDutyAdapterBio;


/**
 * Validator for MilitarySummaryActiveDutyAdapter Bio.  Iterates over the MilitarySummaryActiveDutyAdapter bio graph calling the validator on each sub bio in the graph
 *
 * @author darias
 */
@Component
public class MilitarySummaryActiveDutyAdapterBioValidator extends AbstractBioValidator<MilitarySummaryActiveDutyAdapterBio> {

    @Override
    public List<Message> fullValidation(MilitarySummaryActiveDutyAdapterBio bioPrevious, MilitarySummaryActiveDutyAdapterBio bioNew, Class<?>... validationHints) {
        // TODO implement your full validation here!
        return null;
    }
    
}
