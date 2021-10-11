package net.povv.event.eventlogserver.infrastructure;

import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.PutRecordResult;
import com.amazonaws.services.kinesisfirehose.model.Record;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import net.povv.event.eventlogserver.config.aws.AWSKinesis;
import net.povv.event.eventlogserver.domain.event.command.TrackEventCommand;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

@Service
@RequiredArgsConstructor
public class KinesisFirehoseEventStream implements ApplicationListener<TrackEventCommand> {
    private final AWSKinesis awsKinesis;

    @Override
    public void onApplicationEvent(TrackEventCommand command) {
        Gson gson = new Gson();
        String data = gson.toJson(command);

        PutRecordRequest putRecordsRequest = new PutRecordRequest();
        putRecordsRequest.setDeliveryStreamName("event_logging");

        Record rc = new Record();
        rc.setData(ByteBuffer.wrap(data.getBytes()));

        putRecordsRequest.setRecord(rc);

        PutRecordResult putRecordsResult = awsKinesis.kinesisFirehoseFactory().putRecord(putRecordsRequest);
        System.out.println("Put Result" + putRecordsResult);
    }
}
