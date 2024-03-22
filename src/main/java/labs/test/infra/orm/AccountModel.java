
package labs.test.infra.orm;

import java.util.UUID;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import labs.test.domain.entity.Account;

@MappedEntity(value = "account")
public class AccountModel {

    @MappedProperty(value = "invite_account_id")
    private UUID inviteAccountId;

    private String email;

    @Id
    @MappedProperty(value = "account_id")
    private UUID accountId;

    private AccountModel(UUID accountId, UUID inviteAccountId, String email) {
        this.accountId = accountId;
        this.inviteAccountId = inviteAccountId;
        this.email = email;
    }

    public static AccountModel fromAggregate (Account account) {
        return new AccountModel(account.getAccountId(), account.getInviteAccountIdAsUuid(), account.getEmail());
    }

    // public Account getAggregate () {
	// 	return Account.restore(this.accountId, this.inviteAccountId, this.email);
	// }

    public UUID getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public UUID getInviteAccountId() {
        return inviteAccountId;
    }
}
