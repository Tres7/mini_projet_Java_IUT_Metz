package com.example.tp_note;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {
    @Test
    void verificationNom(){
        Pizza p1 = new Pizza("Regina",45,21);
        Pizza p2 = new Pizza("Sicilienne",30,6);
        String idenP1= p1.getNom();
        String idenP2= p2.getNom();
        assertEquals("Regina",idenP1);
        assertEquals("Sicilienne",idenP2);

    }

    @Test
    void verificationPrix(){
        Pizza p1 = new Pizza("Regina",45,21);
        Pizza p2 = new Pizza("Sicilienne",30,6);
        int idenP1= p1.getPrix();
        int idenP2= p2.getPrix();
        assertEquals(45,idenP1);
        assertEquals(30,idenP2);
    }

    @Test
    void verificationIngredients(){
        Pizza p1 = new Pizza("Regina",45,21);
        Pizza p2 = new Pizza("Sicilienne",30,6);
        int idenP1= p1.getNombreIngredients();
        int idenP2= p2.getNombreIngredients();
        assertEquals(21,idenP1);
        assertEquals(6,idenP2);
    }

    @Test
    void verificationModifNom(){
        Pizza p1 = new Pizza("Regina",45,21);
        Pizza p2 = new Pizza("Sicilienne",30,6);
        p1.setNom("Pepperoni");
        p2.setNom("Margherita");
        assertEquals("Pepperoni",p1.getNom());
        assertEquals("Margherita",p2.getNom());
    }

    @Test
    void verificationModifPrix(){
        Pizza p1 = new Pizza("Regina",45,21);
        Pizza p2 = new Pizza("Sicilienne",30,6);
        p1.setPrix(15);
        p2.setPrix(12);
        assertEquals(15,p1.getPrix());
        assertEquals(12,p2.getPrix());
    }

    @Test
    void verificationModifNombreIngredients(){
        Pizza p1 = new Pizza("Regina",45,21);
        Pizza p2 = new Pizza("Sicilienne",30,6);
        p1.setNombreIngredients(5);
        p2.setNombreIngredients(2);
        assertEquals(5,p1.getNombreIngredients());
        assertEquals(2,p2.getNombreIngredients());
    }
}
