package uk.co.prodapt.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.prodapt.inventory.model.Product;
import uk.co.prodapt.inventory.service.ProductService;

@SpringBootTest
class InventoryDataTest {

	@Autowired
	private ProductService productService;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testGetAllData() throws IOException, InterruptedException {
		List<Product> result = productService.getAll();
		String expectedResult = "[{\"id\":1,\"name\":\"Product A\",\"available\":true,\"supplierId\":1,\"supplierName\":\"Supplier A\"},{\"id\":2,\"name\":\"Product B\",\"available\":false,\"supplierId\":2,\"supplierName\":\"Supplier B\"},{\"id\":3,\"name\":\"Product C\",\"available\":true,\"supplierId\":3,\"supplierName\":\"Supplier C\"}]";
		String acthualResult = objectMapper.writeValueAsString(result);
		assertEquals(expectedResult, acthualResult);
	}
}