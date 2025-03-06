package mdm.cuf.military.summary.active.duty.adapter.vadir.server.processor.transformer;

import org.springframework.stereotype.Component;

import mdm.cuf.core.server.processor.AbstractBioDioTransformer;
import mdm.cuf.military.summary.active.duty.adapter.vadir.bio.MilitarySummaryActiveDutyAdapterBio;
import mdm.cuf.military.summary.active.duty.adapter.vadir.server.dio.MilitarySummaryActiveDutyAdapterDio;


/**
 * Transformer for MilitarySummaryActiveDutyAdapter Bio's and Dio's.
 * @author darias
 */
@Component
public class MilitarySummaryActiveDutyAdapterBioDioTransformer extends AbstractBioDioTransformer<MilitarySummaryActiveDutyAdapterBio, MilitarySummaryActiveDutyAdapterDio> {

    @Override
    public MilitarySummaryActiveDutyAdapterDio bioToDio(MilitarySummaryActiveDutyAdapterBio bio) {
    	final MilitarySummaryActiveDutyAdapterDio dio = bioToDioAllProperties(bio, new MilitarySummaryActiveDutyAdapterDio());
        return dio;

    }

    @Override
    public MilitarySummaryActiveDutyAdapterBio dioToBio(MilitarySummaryActiveDutyAdapterDio dio) {
    	final MilitarySummaryActiveDutyAdapterBio bio = dioToBioAllProperties(dio, new MilitarySummaryActiveDutyAdapterBio());
        return bio;
    }

}
