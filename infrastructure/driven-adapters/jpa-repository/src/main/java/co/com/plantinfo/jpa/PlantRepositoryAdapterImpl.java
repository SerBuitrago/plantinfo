package co.com.plantinfo.jpa;

import co.com.plantinfo.model.TypePlant;
import co.com.plantinfo.model.plant.Plant;
import co.com.plantinfo.model.plant.gateways.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlantRepositoryAdapterImpl implements PlantRepository {

    private PlantRepositoryAdapter plantRepositoryAdapter;

    @Override
    public Plant findById(Long id) {
        Plant plant = plantRepositoryAdapter.findById(id);
        return plant;
    }

    @Override
    public Plant findByName(String name) {
        return null;
    }

    @Override
    public List<Plant> findAll() {
        return plantRepositoryAdapter.findAll();
    }

    @Override
    public List<Plant> findByTypeAll(TypePlant type) {
        return null;
    }

    @Override
    public Plant save(Plant plant) {
        return null;
    }

    @Override
    public Plant update(Plant plant) {
        return null;
    }

    @Override
    public Plant deleteById(Long id) {
        return null;
    }
}
