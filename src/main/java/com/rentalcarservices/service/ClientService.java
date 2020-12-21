package com.rentalcarservices.service;

import com.rentalcarservices.model.Car;
import com.rentalcarservices.model.Client;
import com.rentalcarservices.model.ClientForm;
import com.rentalcarservices.model.Reservation;
import com.rentalcarservices.repository.ClientRepository;
import com.rentalcarservices.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public void add(ClientForm clientForm){
//        Reservation clientReservation = reservationRepository.findById(clientForm.getReservationId()).get();
        Client client = new Client();
//        client.setReservationList((List<Reservation>) clientReservation);
        client.setName(clientForm.getName());
        client.setLastName(clientForm.getLastName());
        client.setEmailAddress(clientForm.getEmailAddress());
        client.setCity(clientForm.getCity());
        client.setStreet(clientForm.getStreet());
        client.setStreetNumber(clientForm.getStreetNumber());
        client.setPostCode(clientForm.getPostCode());

        clientRepository.save(client);
    }

    public List<Client> getClientList(){
        return  clientRepository.findAll();
    }

    public void deleteClientById(Long clientIdentifier){
        clientRepository.deleteById(clientIdentifier);
    }

    public Optional<Client> findClient(Long id){
        return clientRepository.findById(id);
    }
}
