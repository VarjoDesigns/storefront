package storefront.storefront.domain.cars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findByName(@Param("name") String name);
}
