package net.povv.event.eventlogserver.config.aws;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AWSKinesis {

    private final AWSCredentialProperties awsCredentialProperties;

    public AmazonKinesisFirehose kinesisFirehoseFactory() {
        AmazonKinesisFirehoseClientBuilder clientBuilder = AmazonKinesisFirehoseClientBuilder.standard();
        clientBuilder.setRegion(Regions.AP_NORTHEAST_2.getName());
        clientBuilder.setCredentials(awsCredentialProperties.getCredentials());

        return clientBuilder.build();
    }
}
