import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());

    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax","NS"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest(){
        list.addCity(new City("Edmonton","AB"));
        assertTrue(list.hasCity(new City("Edmonton","AB")));
    }

    @Test
    public void deleteCityTest(){
        list.addCity(new City("Edmonton","AB"));
        list.deleteCity(new City("Edmonton","AB"));
        assertFalse(list.hasCity(new City("Edmonton","AB")));
    }
}
