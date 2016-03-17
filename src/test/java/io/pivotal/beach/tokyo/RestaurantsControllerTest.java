package io.pivotal.beach.tokyo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RestaurantsControllerTest {
    private MockMvc mockMvc;
    private FakeRestaurantRepository fakeRepository;

    @Before
    public void setup() {
        fakeRepository = new FakeRestaurantRepository();
        RestaurantsController restaurantsController = new RestaurantsController(fakeRepository);
        mockMvc = standaloneSetup(restaurantsController)
                .build();
    }

    @Test
    public void testGettingAListOfRestaurants() throws Exception {
        fakeRepository.selectAll_returnValue = Arrays.asList(
                new Restaurant(1, "Afuri")
        );

        mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("Afuri")));
    }
}
