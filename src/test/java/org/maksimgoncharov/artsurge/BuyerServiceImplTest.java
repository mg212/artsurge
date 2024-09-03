/*Tests the methods of the BuyerServiceImpl class, which provides business logic for interacting with buyer data.
Verifies that the service correctly fetches all buyers from the repository.
Can also include tests for other methods like saveBuyer, getBuyerById, and deleteBuyerById.*/

package org.maksimgoncharov.artsurge;
import org.maksimgoncharov.artsurge.service.BuyerService;
import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.repo.BuyerRepository;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyerServiceImplTest {

    @Autowired
    private BuyerService buyerService;

    @MockBean
    private BuyerRepository buyerRepository;

    @Test
    public void testGetAllBuyers() {
        List<Buyer> buyers = Arrays.asList(new Buyer("John", "Doe", "johndoe@example.com"),
                new Buyer("Jane", "Smith", "janesmith@example.com"));

        Mockito.when(buyerRepository.findAll()).thenReturn(buyers);

        List<Buyer> fetchedBuyers = buyerService.getAllBuyers();

        assertEquals(2, fetchedBuyers.size());
        assertEquals(buyers, fetchedBuyers);
    }

}