package com.example.artsurge.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.artsurge.model.Buyer;
import com.example.artsurge.repo.BuyerRepository;




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


}

