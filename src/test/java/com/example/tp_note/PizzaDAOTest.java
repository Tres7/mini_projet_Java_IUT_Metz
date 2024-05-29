package com.example.tp_note;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaDAOTest {
    private PizzaDAO pizzaDAO = new PizzaDAO();



    @Test
    public void testAjouterETSupprimerPizza(){
        Pizza pizza = new Pizza("Margharita",9,3);
        pizzaDAO.ajouterPizza(pizza);
        List<Pizza> pizzas = pizzaDAO.getPizzas();
        assertEquals(1, pizzas.size());
        assertEquals("Margharita", pizzas.get(0).getNom());
        assertEquals(9, pizzas.get(0).getPrix());
        assertEquals(3 ,pizzas.get(0).getNombreIngredients());
    }

    @Test
    public void testSupprimerPizza(){
        pizzaDAO.viderPizza();;
        List<Pizza> pizzas = pizzaDAO.getPizzas();
        assertEquals(0, pizzas.size());
    }
}
