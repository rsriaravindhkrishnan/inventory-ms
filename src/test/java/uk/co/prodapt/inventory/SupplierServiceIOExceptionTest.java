package uk.co.prodapt.inventory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.co.prodapt.inventory.service.ProductService;
import uk.co.prodapt.inventory.service.SupplierService;

@SpringBootTest
public class SupplierServiceIOExceptionTest {

	@Autowired
	private ProductService productService;
	@MockBean
	private SupplierService supplierService;

	@Test
	void testIOExceptions() throws IOException, InterruptedException {
		when(supplierService.getAll()).thenThrow(new IOException("Simulated IOException"));
		assertThrows(IOException.class, () -> productService.getAll());
	}
}
