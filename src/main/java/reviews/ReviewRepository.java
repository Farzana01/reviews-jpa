package reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReviewRepository extends CrudRepository<Review, Long> {

//Set<Review>findByTitleContaining(String str);


}