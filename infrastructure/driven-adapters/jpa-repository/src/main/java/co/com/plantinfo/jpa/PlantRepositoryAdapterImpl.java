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
        Plant plant = plantRepositoryAdapter.findByName(name);
        if(plant == null)
            throw new PragmaException("No se ha encontrado ninguna planta con el nombre "+name+".");
        return plant;
    }

    @Override
    public List<Plant> findAll() {
        return plantRepositoryAdapter.findAll();
    }

    @Override
    public List<Plant> findByTypeAll(TypePlant type) { return plantRepositoryAdapter.findByTypeAll(type); }

    @Override
    public Plant save(Plant plant) {
        if(existsPlantByName(plant.getName()))
            throw new PragmaException("Ya existe una planta con ese nombre "+plant.getName()+".");
        plant = plantRepositoryAdapter.save(plant);
        if(plant == null)
            throw new PragmaException("No se ha registrado la planta.");
        return plant;
    }

    @Override
    public Plant update(Plant plant) {
        Plant plantDb = findById(plant.getId());
        if(equalsPlantByName(plantDb, plant))
            throw new PragmaException("Ya existe una planta con ese nombre "+plant.getName()+".");
        plant = plantRepositoryAdapter.save(plant);
        if(plant == null)
            throw new PragmaException("No se ha actualizado la planta.");
        return plant;
    }

    @Override
    public Plant deleteById(Long id) {
        Plant plant = findById(id);
        plantRepositoryAdapter.deleteById(id);
        return plant;
    }

    private boolean existsPlantByName(String name){
        try{
            findByName(name);
        }catch (PragmaException pragmaException){
            return false;
        }
        return true;
    }

    private boolean equalsPlantByName(Plant plantDb, Plant plant){
        return plantDb.getName().equalsIgnoreCase(plant.getName()) ? false : existsPlantByName(plant.getName());
    }
}
