package labs.test.infra.queue.invite;
import java.util.UUID;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;


@KafkaListener(offsetReset = OffsetReset.EARLIEST) 
public class InviteListener {
    private static final Logger LOG = getLogger(InviteListener.class);
    @Topic("invite-account")
    public void receive(@KafkaKey UUID accountId, UUID inviteAaccountId, String email) {
        LOG.info("Got Product - {} by {} and {}", accountId, inviteAaccountId, email);
    }
}
