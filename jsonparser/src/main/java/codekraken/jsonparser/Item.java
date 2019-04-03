package codekraken.jsonparser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

@Data
@JsonDeserialize(using = ItemDeserializer.class)
public class Item {

    private String id;
    private String name;
    private int price;
    private List<String> availableColors;
}
