package co.com.plantinfo.jpa;

import co.com.plantinfo.jpa.entity.PlantEntity;
import co.com.plantinfo.jpa.repository.PlantJPARepository;
import co.com.plantinfo.model.plant.Plant;
import co.com.plantinfo.jpa.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PlantRepositoryAdapter
        extends AdapterOperations<Plant, PlantEntity, Long, PlantJPARepository>{

    public PlantRepositoryAdapter(PlantJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Plant.class));
    }
}
