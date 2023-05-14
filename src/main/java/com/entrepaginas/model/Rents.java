package com.entrepaginas.model;

import java.util.ArrayList;

public class Rents {
    
    private ArrayList<Rent> rents;

    public Rents() {
        rents = new ArrayList<>();
    }

    public ArrayList<Rent> returnRents() {
        return rents;
    }

    public void addRent(String rentId,String isbn3, String book, String idClient, String username) {
        rents.add(new Rent(rentId,isbn3, book, idClient, username));
    }

    public void addRent(Rent rent) {
        rents.add(rent);
    }

    public void removeRent(String idRent) {
        for (Rent rent : rents) {
            if (rent.getRentId().equals(idRent)) {
                rents.remove(rent);
                break;
            }
        }
    }
}
