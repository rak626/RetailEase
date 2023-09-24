package com.retailease.product;

import com.retailease.product.entities.Product;
import com.retailease.product.exceptions.InvalidQuantityException;
import com.retailease.product.payloads.request.ProductReqDto;
import com.retailease.product.payloads.response.ProductResDto;
import com.retailease.product.repositories.ProductRepo;
import com.retailease.product.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceImplTest {

    private ProductServiceImpl productServiceImpl;

    @Mock
    private ProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productServiceImpl = new ProductServiceImpl(productRepo);
    }

    @Test
    public void testAddProduct() {
        ProductReqDto productReqDto = new ProductReqDto();
        productReqDto.setBarcodeNo("123456");
        productReqDto.setQuantity(10L);
        productReqDto.setName("Test Product");
        productReqDto.setCategory("Test Category");
        productReqDto.setPrice(50.0);
        productReqDto.setStoreId(1L);

        when(productRepo.findByBarcodeNo("123456")).thenReturn(Optional.empty());

        productServiceImpl.addProduct(productReqDto);

        verify(productRepo, times(1)).save(any(Product.class));
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product();
        product.setBarcodeNo("123456");
        product.setQuantity(20L);
        product.setId(1L);

        when(productRepo.findByBarcodeNo("123456")).thenReturn(Optional.of(product));

        productServiceImpl.removeProduct("123456", 10);

        assertEquals(10, product.getQuantity());
        verify(productRepo, times(1)).save(any(Product.class));
    }

    @Test
    public void testRemoveProductWithInvalidQuantity() {
        Product product = new Product();
        product.setBarcodeNo("123456");
        product.setQuantity(5L);

        when(productRepo.findByBarcodeNo("123456")).thenReturn(Optional.of(product));

        assertThrows(InvalidQuantityException.class, () -> productServiceImpl.removeProduct("123456", 10));
    }

    @Test
    public void testAddNewProduct() {
        ProductReqDto productReqDto = new ProductReqDto();
        productReqDto.setBarcodeNo("123456");
        productReqDto.setQuantity(10L);
        productReqDto.setName("Test Product");
        productReqDto.setCategory("Test Category");
        productReqDto.setPrice(50.0);
        productReqDto.setStoreId(1L);

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        when(productRepo.save(any(Product.class))).thenReturn(savedProduct);

        ProductResDto productResDto = productServiceImpl.addNewProduct(productReqDto);

        assertNotNull(productResDto);
        assertEquals(1L, productResDto.getId());
    }

    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        ProductReqDto productReqDto = new ProductReqDto();
        productReqDto.setQuantity(20L);
        productReqDto.setPrice(60.0);

        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setBarcodeNo("123456");
        existingProduct.setQuantity(10L);
        existingProduct.setPrice(50.0);

        when(productRepo.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepo.save(any(Product.class))).thenReturn(existingProduct);

        ProductResDto updatedProduct = productServiceImpl.updateProduct(productId, productReqDto);

        assertNotNull(updatedProduct);
        assertEquals(20, updatedProduct.getQuantity());
        assertEquals(60.0, updatedProduct.getPrice());
    }

    @Test
    public void testFindProductById() {
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        product.setBarcodeNo("123456");
        product.setQuantity(10L);
        product.setPrice(50.0);

        when(productRepo.findById(productId)).thenReturn(Optional.of(product));

        ProductResDto productResDto = productServiceImpl.findProductById(productId);

        assertNotNull(productResDto);
        assertEquals(productId, productResDto.getId());
    }
}
