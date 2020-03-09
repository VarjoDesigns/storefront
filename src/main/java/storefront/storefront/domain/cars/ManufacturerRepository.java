package storefront.storefront.domain.cars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
	List<Manufacturer> findByName(@Param("name") String name);
}
