package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.service.TsinjoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TsinjoController {
  private final TsinjoService tsinjoService;

  public TsinjoController(TsinjoService tsinjoService) {
    this.tsinjoService = tsinjoService;
  }

  @GetMapping("/")
  public String showAllTransactions(Model model) {
    model.addAttribute("donations", tsinjoService.getAllDonations());
    return "transactions";
  }

  @PostMapping("/donate")
  public String submitDonation(
      @RequestParam String email,
      @RequestParam String fullName,
      @RequestParam int amount, // Changé de double à int pour correspondre au service
      @RequestParam String pspPaymentId) { // Renommé paymentMethod -> pspPaymentId

    tsinjoService.createDonation(email, fullName, amount, pspPaymentId);
    return "redirect:/";
  }
}
