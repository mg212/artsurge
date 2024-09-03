package org.maksimgoncharov.artsurge.service;

import org.maksimgoncharov.artsurge.model.Artwork;
import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.model.Cart;
import org.maksimgoncharov.artsurge.model.CartItem;
import org.maksimgoncharov.artsurge.repo.CartItemRepository;
import org.maksimgoncharov.artsurge.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).get();
    }

    public Cart createCart(Buyer buyer) {
        Cart cart = new Cart();
        cart.setBuyer(buyer);
        return cartRepository.save(cart);
    }

    public void addToCart(Artwork artwork, Cart cart) {
        CartItem cartItem = new CartItem();
        cartItem.setArtwork(artwork);
        cartItem.setCart(cart);
        cartItem.setQuantity(1);
        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public List<CartItem> getCartItems(Cart cart) {
        return cart.getCartItems();
    }

    public double calculateCartTotal(Cart cart) {
        double total = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            total += cartItem.getArtwork().getPrice() * cartItem.getQuantity();
        }
        return total;
    }
}