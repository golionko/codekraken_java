import codekraken.jsonparser.Item;
import codekraken.jsonparser.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import static org.junit.Assert.*;

import java.io.IOException;

public class JsonParserTest {

    @Test
    public void userTest() throws IOException {
        Resource userJson = new ClassPathResource("user.json");

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson.getFile(),User.class);
        assertEquals(user.getCity(),"Toronto");
        assertEquals(user.getCountry(),"Canada");
        assertEquals(user.getStreet(),"Younge st");
        assertEquals(user.getFirstName(),"Dante");
        assertEquals(user.getLastName(),"Alighieri");
        assertEquals(user.getId(),"user_1");

       System.out.println(objectMapper.writeValueAsString(user));
    }

    @Test
    public void itemTest() throws IOException {
        Resource itemJson = new ClassPathResource("item.json");

        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue(itemJson.getFile(), Item.class);

        assertEquals(item.getId(),"item_1");
        assertEquals(item.getName(),"winter gloves");
        assertEquals(item.getPrice(),2000);
        assertArrayEquals(item.getAvailableColors().toArray(), Arrays.array("red","green","blue"));

        System.out.println(objectMapper.writeValueAsString(item));
    }
}
