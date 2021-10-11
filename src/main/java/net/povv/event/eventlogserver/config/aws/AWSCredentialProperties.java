package net.povv.event.eventlogserver.config.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@ConfigurationProperties(prefix = "aws.credentials")
@Getter
@Setter
public class AWSCredentialProperties {
    private String accessKey;
    private String secretKey;

    @Bean
    @Primary
    public AWSCredentialsProvider getCredentials() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        return new AWSStaticCredentialsProvider(credentials);
    }
}
