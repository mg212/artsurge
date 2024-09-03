package org.maksimgoncharov.artsurge.repo;

import org.maksimgoncharov.artsurge.model.Artwork;
import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.model.Cart;
import org.maksimgoncharov.artsurge.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}
