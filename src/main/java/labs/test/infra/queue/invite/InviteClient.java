package labs.test.infra.queue.invite;

import java.util.UUID;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface InviteClient {
    @Topic("invite-account")
    void sendProduct(@KafkaKey UUID accountId, UUID inviteAaccountId, String email);
}
