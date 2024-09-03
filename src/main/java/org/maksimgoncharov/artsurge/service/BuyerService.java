package org.maksimgoncharov.artsurge.service;

import java.util.List;


import org.maksimgoncharov.artsurge.model.Buyer;

public interface BuyerService {
    List<Buyer> getAllBuyers();

    Buyer saveBuyer(Buyer buyer);

    Buyer getBuyerById(Long id);

    Buyer updateBuyer(Buyer buyer);

    void deleteBuyerById(Long id);
}
