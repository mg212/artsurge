package org.maksimgoncharov.artsurge.repo;

import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByBuyer(Buyer buyer);
}
