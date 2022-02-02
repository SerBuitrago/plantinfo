package co.com.plantinfo.api;
import co.com.plantinfo.model.TypePlant;
import co.com.plantinfo.model.plant.Plant;
import co.com.plantinfo.usecase.plant.PlantUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/plant", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@CrossOrigin
public class PlantRest {

    private final PlantUseCase plantUseCase;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Plant> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(plantUseCase.findById(id));
    }

    @GetMapping(path = "/find/name/{name}")
    public ResponseEntity<Plant> findByName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(plantUseCase.findByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Plant>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(plantUseCase.findAll());
    }

    @GetMapping(path = "/all/find/type/{type}")
    public ResponseEntity<List<Plant>> findByTypeAll(@PathVariable("type")TypePlant type) {
        return ResponseEntity.status(HttpStatus.OK).body(plantUseCase.findByTypeAll(type));
    }

    @PostMapping
    public ResponseEntity<Plant> save(@RequestBody Plant plant){
        return ResponseEntity.status(HttpStatus.CREATED).body(plantUseCase.save(plant));
    }

    @PutMapping
    public ResponseEntity<Plant> update(@RequestBody Plant plant){
        return ResponseEntity.status(HttpStatus.OK).body(plantUseCase.update(plant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plant> deleteById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(plantUseCase.deleteById(id));
    }
}
