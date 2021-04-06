package agawrylak.credit.repositories;

import agawrylak.credit.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
