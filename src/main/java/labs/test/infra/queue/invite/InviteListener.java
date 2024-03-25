package labs.test.infra.queue.invite;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

import io.micronaut.jms.annotations.JMSListener;
import io.micronaut.jms.annotations.Queue;
import static io.micronaut.jms.sqs.configuration.SqsConfiguration.CONNECTION_FACTORY_BEAN_NAME;
import io.micronaut.messaging.annotation.MessageBody;
// @KafkaListener(offsetReset = OffsetReset.EARLIEST) 
@JMSListener(CONNECTION_FACTORY_BEAN_NAME)
public class InviteListener {
    private static final Logger LOG = getLogger(InviteListener.class);
    // @Topic("invite-account")
    // public void receive(@KafkaKey UUID accountId, UUID inviteAaccountId, String email) {
    //     LOG.info("Got Product - {} by {} and {}", accountId, inviteAaccountId, email);
    // }

    @Queue(value = "invite-account")
    public void receive(@MessageBody String accountId) {
        LOG.info("Got Product - {}", accountId);
    }
}
