package labs.test.infra.queue.invite;

import io.micronaut.jms.annotations.JMSProducer;
import io.micronaut.jms.annotations.Queue;
import static io.micronaut.jms.sqs.configuration.SqsConfiguration.CONNECTION_FACTORY_BEAN_NAME;
import io.micronaut.messaging.annotation.MessageBody;

// @KafkaClient
@JMSProducer(CONNECTION_FACTORY_BEAN_NAME)
public interface InviteClient {
    // @Topic("invite-account")
    // void sendProduct(@KafkaKey UUID accountId, UUID inviteAaccountId, String email);

    @Queue("invite-account")
    void sendProduct(@MessageBody String accountId);
}
