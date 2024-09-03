package com.example.artsurge.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.artsurge.model.Buyer;
import com.example.artsurge.service.BuyerService;






@Controller
public class BuyerController {


    private BuyerService buyerService;


    public BuyerController(BuyerService buyerService) {
        super();
        this.buyerService = buyerService;
    }


    // handler method to handle list buyers and return mode and view
    @GetMapping("/buyers")
    public String listBuyers(Model model) {
        System.out.println("IN  BuyerController->listBuyers()");
        model.addAttribute("buyers", buyerService.getAllBuyers());
        return "buyers";
    }


    @GetMapping("/buyers/new")
    public String createBuyerForm(Model model) {
        System.out.println("IN  BuyerController->createBuyerForm()");
        // create buyer object to hold buyer form data
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "create_buyer";


    }


    @PostMapping("/buyers")
    public String saveBuyer(@ModelAttribute("buyer") Buyer buyer) {
        System.out.println("IN  BuyerController->saveBuyer()");
        buyerService.saveBuyer(buyer);
        return "redirect:/buyers";
    }


    @GetMapping("/buyers/edit/{id}")
    public String editBuyerForm(@PathVariable Long id, Model model) {
        System.out.println("IN  BuyerController->editBuyerForm()");
        model.addAttribute("buyer", buyerService.getBuyerById(id));
        return "edit_buyer";
    }


    @PostMapping("/buyers/{id}")
    public String updateBuyer(@PathVariable Long id,
                              @ModelAttribute("buyer") Buyer buyer,
                              Model model) {


        // get buyer from database by id
        Buyer existingBuyer = buyerService.getBuyerById(id);
        existingBuyer.setId(id);
        existingBuyer.setFirstName(buyer.getFirstName());
        existingBuyer.setLastName(buyer.getLastName());
        existingBuyer.setEmail(buyer.getEmail());


        // save updated buyer object
        buyerService.updateBuyer(existingBuyer);
        return "redirect:/buyers";
    }


    // handler method to handle delete buyer request


    @GetMapping("/buyers/{id}")
    public String deleteBuyer(@PathVariable Long id) {
        System.out.println("IN  BuyerController->deleteBuyer()");
        buyerService.deleteBuyerById(id);
        return "redirect:/buyers";
    }


}
