package storefront.storefront.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VinylgroupRepository extends CrudRepository<Vinylgroup, Long> {
	List<Livery> findByName(@Param("name") String name);
}