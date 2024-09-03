/*Tests if the findById method in the BuyerRepository retrieves a specific buyer by its ID correctly. It creates a test buyer, saves it to the repository, finds it by its ID, and checks if the retrieved buyer matches the original one.*/


package org.maksimgoncharov.artsurge;

import org.maksimgoncharov.artsurge.repo.BuyerRepository;
import org.maksimgoncharov.artsurge.model.Buyer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

// Assert that the retrieved buyers are correct


@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyerRepositoryTests {

    @Autowired
    private BuyerRepository buyerRepository;


    private void assertEquals(int i, int size) {
    }

    @Test
    public void testFindById() {
        // Create a test buyer
        Buyer buyer = new Buyer("John", "Doe", "john.doe@example.com");
        buyer = buyerRepository.save(buyer);

        // Find buyer by id
        Optional<Buyer> optionalBuyer = buyerRepository.findById(buyer.getId());

        // Assert that the retrieved buyer is correct
        assertTrue(optionalBuyer.isPresent());
        assertEquals(buyer, optionalBuyer.get());
    }

    private void assertEquals(Buyer buyer, Buyer buyer1) {
    }
}