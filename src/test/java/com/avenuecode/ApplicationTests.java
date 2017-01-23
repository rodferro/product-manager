package com.avenuecode;

import com.avenuecode.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void beforeTests() throws Exception {

    }

    @Test
    public void shouldRetrieveAllProductsExcludingRelationships() throws Exception {
        mockMvc
                .perform(get("/product?projection=withoutRelationships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.product[1].parentProduct").doesNotExist())
                .andExpect(jsonPath("$._embedded.product[1].childProducts").doesNotExist())
                .andExpect(jsonPath("$._embedded.product[1].images").doesNotExist());
    }

    @Test
    public void shouldRetrieveAllProductsIncludingRelationships() throws Exception {
        mockMvc
                .perform(get("/product?projection=withRelationships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.product[1].parentProduct").exists())
                .andExpect(jsonPath("$._embedded.product[1].childProducts").exists())
                .andExpect(jsonPath("$._embedded.product[1].images").exists());
    }

    @Test
    public void shouldRetrieveOneProductExcludingRelationships() throws Exception {
        mockMvc
                .perform(get("/product/2?projection=withoutRelationships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parentProduct").doesNotExist())
                .andExpect(jsonPath("$.childProducts").doesNotExist())
                .andExpect(jsonPath("$.images").doesNotExist());
    }

    @Test
    public void shouldRetrieveOneProductIncludingRelationships() throws Exception {
        mockMvc
                .perform(get("/product/2?projection=withRelationships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parentProduct").exists())
                .andExpect(jsonPath("$.childProducts").exists())
                .andExpect(jsonPath("$.images").exists());
    }

    @Test
    public void shouldRetrieveChildProductsOfAProduct() throws Exception {
        mockMvc
                .perform(get("/product/1/childProducts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.product").isArray());
    }

    @Test
    public void shouldRetrieveImagesOfAProduct() throws Exception {
        mockMvc
                .perform(get("/product/2/images"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.image").isArray())
                .andExpect(jsonPath("$._embedded.image[0].type").exists())
                .andExpect(jsonPath("$._embedded.image[0].url").exists());
    }
}
