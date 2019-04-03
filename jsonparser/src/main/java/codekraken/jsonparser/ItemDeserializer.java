package codekraken.jsonparser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemDeserializer extends JsonDeserializer<Item> {

    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Item item = new Item();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        item.setId(node.get("item_id").asText());
        item.setName(node.get("item_name").asText());
        item.setPrice(node.get("item_price").asInt());

        final List<String> colors = new ArrayList<>();
        for (JsonNode color : node.get("colors")) {
            colors.add(color.asText());
        }
        item.setAvailableColors(colors);
        return item;
    }
}
