package org.maksimgoncharov.artsurge.service;

import java.util.List;


import org.maksimgoncharov.artsurge.model.Artwork;
import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.model.Cart;
import org.maksimgoncharov.artsurge.model.CartItem;

public interface BuyerService {
    List<Buyer> getAllBuyers();

    Buyer saveBuyer(Buyer buyer);

    Buyer getBuyerById(Long id);

    Buyer updateBuyer(Buyer buyer);

    void deleteBuyerById(Long id);


    ///////////////////////////
    ///////////////////////////
    Artwork saveArtwork(Artwork artwork);
    List<Artwork> findArtworksByBuyer(Buyer buyer);
    Cart getCartByBuyer(Buyer buyer);
    CartItem addArtworkToCart(Artwork artwork, Cart cart);
    void removeFromCart(CartItem cartItem);
    double calculateCartTotal(Cart cart);
}
