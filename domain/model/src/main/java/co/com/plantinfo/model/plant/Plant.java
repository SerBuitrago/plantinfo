package co.com.plantinfo.model.plant;
import co.com.plantinfo.model.TypePlant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Plant {

    private Long id;
    private String name;
    private TypePlant type;
    private String description;
    private String image;
}
