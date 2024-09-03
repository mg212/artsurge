package com.example.artsurge.service;

import java.util.List;


import com.example.artsurge.model.Buyer;

public interface BuyerService {
    List<Buyer> getAllBuyers();

    Buyer saveBuyer(Buyer buyer);

    Buyer getBuyerById(Long id);

    Buyer updateBuyer(Buyer buyer);

    void deleteBuyerById(Long id);
}
