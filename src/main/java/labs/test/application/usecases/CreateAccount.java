package labs.test.application.usecases;

import jakarta.inject.Singleton;
import labs.test.domain.entity.Account;
import labs.test.infra.orm.AccountModel;
import labs.test.infra.queue.invite.InviteClient;
import labs.test.infra.repository.AccountRepository;

@Singleton
public class CreateAccount {

    private final AccountRepository accountRepository;
    private final InviteClient inviteClient;

    public CreateAccount(AccountRepository accountRepository, InviteClient inviteClient) {
        this.accountRepository = accountRepository;
        this.inviteClient = inviteClient;
    }
    
    public void execute(Account account) {
        boolean existsInvitationer = accountRepository.existsById(account.getInviteAccountIdAsUuid());
        if (!existsInvitationer) {
            throw new IllegalArgumentException("Invitationer not found");
        }
        AccountModel newAccount = AccountModel.fromAggregate(account);
        accountRepository.save(newAccount);
        inviteClient.sendProduct(account.getAccountId().toString());
        // inviteClient.sendProduct(account.getAccountId(), account.getInviteAccountIdAsUuid(), account.getEmail());
    }
}
