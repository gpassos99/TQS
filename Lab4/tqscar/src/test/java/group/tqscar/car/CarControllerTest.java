package group.tqscar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)


class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void whenPostCar_thenCreateCar( ) throws Exception {
        Car bmw = new Car("118d", "BMW");

        given(service.save(Mockito.any())).willReturn(bmw);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(bmw)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("118d")));

        verify(service, times(1)).save(Mockito.any());

    }



}