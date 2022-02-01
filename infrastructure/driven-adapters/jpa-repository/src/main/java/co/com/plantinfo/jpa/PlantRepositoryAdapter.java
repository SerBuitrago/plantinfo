package co.com.plantinfo.jpa;

import co.com.plantinfo.jpa.entity.PlantEntity;
import co.com.plantinfo.jpa.repository.PlantJPARepository;
import co.com.plantinfo.model.TypePlant;
import co.com.plantinfo.model.plant.Plant;
import co.com.plantinfo.jpa.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlantRepositoryAdapter
        extends AdapterOperations<Plant, PlantEntity, Long, PlantJPARepository>{

    public PlantRepositoryAdapter(PlantJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Plant.class));
    }

    public Plant findByName(String name){
        return toEntity(repository.findByName(name));
    }

    public List<Plant> findByTypeAll(TypePlant typePlant){
        List<PlantEntity> plantEntityList = repository.findByType(typePlant);
        List<Plant> plantList = plantEntityList.stream().map(this::toEntity).collect(Collectors.toList());
        return plantList;
    }
}
