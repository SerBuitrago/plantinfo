package co.com.plantinfo.jpa;

import co.com.plantinfo.jpa.exception.PragmaException;
import co.com.plantinfo.model.TypePlant;
import co.com.plantinfo.model.plant.Plant;
import co.com.plantinfo.model.plant.gateways.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlantRepositoryAdapterImpl implements PlantRepository {

    private final PlantRepositoryAdapter plantRepositoryAdapter;

    @Override
    public Plant findById(Long id) {
        Plant plant = plantRepositoryAdapter.findById(id);
        if(plant == null)
            throw new PragmaException("No se ha encontrado ninguna planta con el id "+id+".");
        return plant;
    }

    @Override
    public Plant findByName(String name) {
        Plant plant = null;
        if(plant == null)
            throw new PragmaException("No se ha encontrado ninguna planta con el nombre "+name+".");
        return plant;
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
        plant = plantRepositoryAdapter.save(plant);
        return plant;
    }

    @Override
    public Plant update(Plant plant) {
        findById(plant.getId());
        plant = plantRepositoryAdapter.save(plant);
        return plant;
    }

    @Override
    public Plant deleteById(Long id) {
        Plant plant = findById(id);
        plantRepositoryAdapter.deleteById(id);
        return plant;
    }
}
