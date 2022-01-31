package co.com.plantinfo.usecase.plant;

import co.com.plantinfo.model.TypePlant;
import co.com.plantinfo.model.plant.Plant;
import co.com.plantinfo.model.plant.gateways.PlantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlantUseCase{

    private final PlantRepository plantRepositoryGateway;

    public Plant findById(Long id) {
        return plantRepositoryGateway.findById(id);
    }

    public Plant findByName(String name) {
        return plantRepositoryGateway.findByName(name);
    }

    public List<Plant> findAll(){return plantRepositoryGateway.findAll();}

    public List<Plant> findByTypeAll(TypePlant type) {
        return plantRepositoryGateway.findByTypeAll(type);
    }

    public Plant save(Plant plant) {
        return plantRepositoryGateway.save(plant);
    }

    public Plant update(Plant plant) {
        return plantRepositoryGateway.update(plant);
    }

    public Plant deleteById(Long id) {
        return plantRepositoryGateway.deleteById(id);
    }
}
