package com.things.customer.xcitycustomerskb.optionals;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuitaristService {
    public Optional<Guitarist> findByLastName(String lastName) {
        if (lastName.equalsIgnoreCase("Hendrix")) {
            Guitarist result =  new Guitarist("Jimi", "Hendrix", "Purple Haze");
            return Optional.of(result);
        }
        return Optional.empty();
    }
}

class Guitarist{

    String firstname;
    String lastname;
    String album;

    public Guitarist(String firstname, String surname, String album) {
        this.firstname = firstname;
        this.lastname = surname;
        this.album = album;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAlbum() {
        return album;
    }
}