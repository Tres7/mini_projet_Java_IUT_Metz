package com.example.tp_note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    public List<Pizza> getPizzas(){
        List<Pizza> pizzas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e5756u_mini_Projet_Java", "e5756u_appli", "32317718");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(("select * from pizza"));
            while(rs.next()){
                pizzas.add(new Pizza(rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return pizzas;
    }

    public void ajouterPizza(Pizza pizza){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e5756u_mini_Projet_Java", "e5756u_appli", "32317718");

            PreparedStatement statement = con.prepareStatement("INSERT INTO pizza(nom, prix, nombreIngredients) VALUES(?,?,?);");
            statement.setString(1, pizza.getNom());
            statement.setInt(2,pizza.getPrix());
            statement.setInt(3,pizza.getNombreIngredients());

            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void supprimerPizza(String nom){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e5756u_mini_Projet_Java", "e5756u_appli", "32317718");

            PreparedStatement statement = con.prepareStatement("DELETE FROM pizza WHERE nom=?;");
            statement.setString(1, nom);

            statement.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void viderPizza(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/e5756u_mini_Projet_Java", "e5756u_appli", "32317718");

            PreparedStatement statement = con.prepareStatement("DELETE FROM pizza");
            statement.executeUpdate();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

}
