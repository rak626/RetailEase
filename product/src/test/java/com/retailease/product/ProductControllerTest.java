package com.retailease.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailease.product.controllers.ProductController;
import com.retailease.product.entities.Product;
import com.retailease.product.payloads.request.ProductReqDto;
import com.retailease.product.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test-application.yaml")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProduct() throws Exception {
        ProductReqDto productReqDto = new ProductReqDto();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/products/add")
                        .content(asJsonString(productReqDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Product Added"));

        verify(productService, times(1)).addProduct(productReqDto);
    }

    @Test
    public void testRemoveProduct() throws Exception {
        String barcodeNo = "123456";
        long quantity = 5;

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/products/remove")
                        .param("barcodeNo", barcodeNo)
                        .param("quantity", String.valueOf(quantity))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("5 Product Removed"));

        verify(productService, times(1)).removeProduct(barcodeNo, quantity);
    }

    @Test
    public void testDisplayAllProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        when(productService.getAllProduct()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));

        verify(productService, times(1)).getAllProduct();
    }

    // Helper method to convert an object to JSON string
    private String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
