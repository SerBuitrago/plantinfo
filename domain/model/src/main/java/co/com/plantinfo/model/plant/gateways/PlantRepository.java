package co.com.plantinfo.model.plant.gateways;

import co.com.plantinfo.model.TypePlant;
import co.com.plantinfo.model.plant.Plant;

import java.util.List;

public interface PlantRepository {
    Plant findById(Long id);

    Plant findByName(String name);

    List<Plant> findByTypeAll(TypePlant type);

    Plant save(Plant plant);

    Plant update(Plant plant);

    Plant deleteById(Long id);
}
