
package labs.test.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import labs.test.application.usecases.CreateAccount;
import labs.test.domain.entity.Account;

@Controller("/accounts")
public class CreateAccountController {

    private final CreateAccount createAccount;

    public CreateAccountController(CreateAccount createAccount) {
        this.createAccount = createAccount;
    }

    @Post(uri = "/", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse execute(@Body @Valid Account account) {
        createAccount.execute(account);
        return HttpResponse.ok().status(HttpStatus.CREATED); 
    }
}
