package co.com.plantinfo.model.plant;
import co.com.plantinfo.model.TypePlant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Plant {

    private Long id;
    private String name;
    private TypePlant type;
    private String description;
    private String image;
}
