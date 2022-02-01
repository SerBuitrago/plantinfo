package co.com.plantinfo.jpa.repository;

import co.com.plantinfo.jpa.entity.PlantEntity;
import co.com.plantinfo.model.TypePlant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PlantJPARepository
        extends CrudRepository<PlantEntity, Long>,
                QueryByExampleExecutor<PlantEntity> {
}
