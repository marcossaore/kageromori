package labs.test.domain.entity;

import java.util.UUID;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Serdeable
public class Account {

    @NotBlank(message = "Invite account cannot be blank")
    @Pattern(regexp= "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}", message = "Invalid Account")
    private final String inviteAccountId;

    @NotBlank(message = "Email cannot be blank")
    @Email(message="Invalid email")
    private final String email;

    private UUID accountId = UUID.randomUUID();

    public Account(String inviteAccountId, String email) {
        this.inviteAccountId = inviteAccountId;
        this.email = email;
    }

    private Account(UUID accountId, UUID inviteAccountId, String email) {
        this.accountId = accountId;
        this.inviteAccountId = inviteAccountId.toString();
        this.email = email;
    }

    public static Account restore(UUID accountId , UUID inviteAccountId, String email) {
        return new Account(accountId, inviteAccountId, email);
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getInviteAccountId() {
        return inviteAccountId;
    }

    public UUID getInviteAccountIdAsUuid() {
        return UUID.fromString(inviteAccountId);
    }
}
