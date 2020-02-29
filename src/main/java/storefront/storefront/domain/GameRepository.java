package storefront.storefront.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends CrudRepository<Game, Long> {
	
	List<Game> findByName(@Param("name") String name);
	List<Game> findByAbbreviation(@Param("abbreviation") String abbreviation);

}
