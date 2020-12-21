package com.rentalcarservices.controller;

import com.rentalcarservices.model.Client;
import com.rentalcarservices.model.ClientForm;
import com.rentalcarservices.service.ClientService;
import com.rentalcarservices.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/add")
    public String clientAdd(Model model){
        model.addAttribute("newClient", new ClientForm());
        //     model.addAttribute("listOfClientReservation", reservationService.getReservationList());
        return "client_new_form";
    }

    @PostMapping("/add")
    public String clientAdd(ClientForm clientForm) {
        clientService.add(clientForm);
        return "redirect:/client/list";
    }
    @GetMapping("/list")
    public String clientList(Model model){
        model.addAttribute("listOfClient", clientService.getClientList());
        return "client_list";
    }

    @GetMapping("/delete/{clientIdentifier}")
    public String deleteClient(@PathVariable Long clientIdentifier){
        clientService.deleteClientById(clientIdentifier);
        return "redirect:/client/list";
    }
    @GetMapping("/details")
    public String clientDetailsPage(Model model, @RequestParam Long clientIdentifier){
        Optional<Client> optionalClient = clientService.findClient(clientIdentifier);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            model.addAttribute("clientDetails", client);
            return "client_details";
        }
        return "redirect:/client/list";
    }

    @GetMapping("/details/{clientIdentifier}")
    public String detailsClient(Model model, @PathVariable Long clientIdentifier) {
        model.addAttribute("listOfCReservationForClient", reservationService.findByClient(clientIdentifier));
        return "client_details";

    }


}
