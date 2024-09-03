package org.maksimgoncharov.artsurge.controller;

import org.maksimgoncharov.artsurge.model.Buyer;
import org.maksimgoncharov.artsurge.service.BuyerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for handling buyer-related requests.
 */
@Controller
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    /**
     * Handles the request to list all buyers.
     *
     * @param model the model to be used by the view
     * @return the view name for listing buyers
     */
    @GetMapping("/buyers")
    public String listBuyers(Model model) {
        model.addAttribute("buyers", buyerService.getAllBuyers());
        return "buyers";
    }

    /**
     * Shows the form for creating a new buyer.
     *
     * @param model the model to be used by the view
     * @return the view name for creating a buyer
     */
    @GetMapping("/buyers/new")
    public String createBuyerForm(Model model) {
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "create_buyer";
    }

    /**
     * Handles the form submission for creating a new buyer.
     *
     * @param buyer the buyer object from the form
     * @return redirect to the list of buyers
     */
    @PostMapping("/buyers")
    public String saveBuyer(@ModelAttribute("buyer") Buyer buyer) {
        buyerService.saveBuyer(buyer);
        return "redirect:/buyers";
    }

    /**
     * Shows the form for editing an existing buyer.
     *
     * @param id the ID of the buyer to be edited
     * @param model the model to be used by the view
     * @return the view name for editing a buyer
     */
    @GetMapping("/buyers/edit/{id}")
    public String editBuyerForm(@PathVariable Long id, Model model) {
        model.addAttribute("buyer", buyerService.getBuyerById(id));
        return "edit_buyer";
    }

    /**
     * Handles the form submission for updating an existing buyer.
     *
     * @param id the ID of the buyer to be updated
     * @param buyer the buyer object with updated details
     * @param model the model to be used by the view
     * @return redirect to the list of buyers
     */
    @PostMapping("/buyers/{id}")
    public String updateBuyer(@PathVariable Long id, @ModelAttribute("buyer") Buyer buyer, Model model) {
        Buyer existingBuyer = buyerService.getBuyerById(id);
        existingBuyer.setId(id);
        existingBuyer.setFirstName(buyer.getFirstName());
        existingBuyer.setLastName(buyer.getLastName());
        existingBuyer.setEmail(buyer.getEmail());
        buyerService.updateBuyer(existingBuyer);
        return "redirect:/buyers";
    }

    /**
     * Handles the request to delete a buyer.
     *
     * @param id the ID of the buyer to be deleted
     * @return redirect to the list of buyers
     */

    @GetMapping("/buyers/{id}")
    public String deleteBuyer(@PathVariable Long id) {
        System.out.println("IN  BuyerController->deleteBuyer()");
        buyerService.deleteBuyerById(id);
        return "redirect:/buyers";
    }


}
