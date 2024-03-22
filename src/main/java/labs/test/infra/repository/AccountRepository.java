package labs.test.infra.repository;

import java.util.UUID;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import labs.test.infra.orm.AccountModel;

@Repository
@JdbcRepository(dialect = Dialect.POSTGRES) 
public interface AccountRepository extends CrudRepository<AccountModel, UUID>  {
    
}