package org.maksimgoncharov.artsurge.service;

import java.util.List;


import org.maksimgoncharov.artsurge.model.Artwork;
import org.maksimgoncharov.artsurge.model.Cart;
import org.maksimgoncharov.artsurge.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.repo.BuyerRepository;




@Service
public class BuyerServiceImpl implements BuyerService{


    private BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        super();
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }


    @Override
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }


    @Override
    public Buyer getBuyerById(Long id) {
        return buyerRepository.findById(id).get();
    }


    @Override
    public Buyer updateBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }


    @Override
    public void deleteBuyerById(Long id) {
        buyerRepository.deleteById(id);
    }

    @Override
    public Artwork saveArtwork(Artwork artwork) {
        return null;
    }

    @Override
    public List<Artwork> findArtworksByBuyer(Buyer buyer) {
        return List.of();
    }

    @Override
    public Cart getCartByBuyer(Buyer buyer) {
        return null;
    }

    @Override
    public CartItem addArtworkToCart(Artwork artwork, Cart cart) {
        return null;
    }

    @Override
    public void removeFromCart(CartItem cartItem) {

    }

    @Override
    public double calculateCartTotal(Cart cart) {
        return 0;
    }



    //////////////////////////
    //////////////////////////
//    @Autowired
//    private ArtworkRepository artworkRepository;
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private CartItemRepository cartItemRepository;
//
//    @Override
//    public Artwork saveArtwork(Artwork artwork) {
//        return artworkRepository.save(artwork);
//    }
//
//    @Override
//    public List<Artwork> findArtworksByBuyer(Buyer buyer) {
//        return artworkRepository.findByBuyer(buyer);
//    }
//
//    @Override
//    public Cart getCartByBuyer(Buyer buyer) {
//        return cartRepository.findByBuyer(buyer);
//    }
//
//    @Override
//    public CartItem addArtworkToCart(Artwork artwork, Cart cart) {
//        CartItem cartItem = new CartItem();
//        cartItem.setArtwork(artwork);
//        cartItem.setCart(cart);
//        cartItem.setQuantity(1); // Or set a default quantity
//        return cartItemRepository.save(cartItem);
//    }
//
//    @Override
//    public void removeFromCart(CartItem cartItem) {
//        cartItemRepository.delete(cartItem);
//    }
//
//    @Override
//    public double calculateCartTotal(Cart cart) {
//        double total = 0;
//        for (CartItem cartItem : cart.getCartItems()) {
//            total += cartItem.getArtwork().getPrice() * cartItem.getQuantity();
//        }
//        return total;
//    }

}

