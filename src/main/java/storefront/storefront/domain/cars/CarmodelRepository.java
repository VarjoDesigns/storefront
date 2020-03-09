package storefront.storefront.domain.cars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarmodelRepository extends CrudRepository<Carmodel, Long> {
	List<Carmodel> findByName(@Param("name") String name);
}
