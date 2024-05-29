package com.example.tp_note;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PizzaController implements Initializable{
    @FXML
    private Label welcomeText;

    @FXML
    private TableColumn colRecette;

    @FXML
    private TableColumn colPrix;

    @FXML
    private TableColumn colNombreIngredients;

    @FXML
    private TableView<Pizza> tableau;

    @FXML
    private TextField inRecette;

    @FXML
    private TextField inPrix;

    @FXML
    private TextField inNombreIngredients;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Label erreurTableVide;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private PizzaDAO pizzaDAO = new PizzaDAO();

    //linkage des colonnes à leurs attributs dans la classe Pizza
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRecette.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colNombreIngredients.setCellValueFactory(new PropertyValueFactory<>("nombreIngredients"));
        ObservableList<Pizza>  pizzas = FXCollections.observableArrayList(pizzaDAO.getPizzas());
        tableau.setItems(pizzas);
    }

    //lister les pizzas de la base de données


    //configuration du bouton ajouter
    @FXML
    private void ajouterPizza(){
        //récupération du texte des TextField
        String recette = inRecette.getText();
        int prix = Integer.parseInt(inPrix.getText());
        int nombreIngredients = Integer.parseInt(inNombreIngredients.getText());

        Pizza pizza = new Pizza(recette, prix, nombreIngredients);
        pizzaDAO.ajouterPizza(pizza);
        ObservableList<Pizza> pizzas = tableau.getItems();
        pizzas.add(pizza);
        tableau.setItems(pizzas);
    }

    //configuration du bouton supprimer
    @FXML
    private void supprimerPizza(){
        //récupération de l'id de l'élément à supprimer
        Pizza pizzaSelectionnee = tableau.getSelectionModel().getSelectedItem();
        if(pizzaSelectionnee != null){
            pizzaDAO.supprimerPizza(pizzaSelectionnee.getNom());
            tableau.getItems().remove(pizzaSelectionnee);
        }else{
            erreurTableVide.setText("Aucune ligne sélectionnée");
        }
    }

    @FXML
    private void viderTableau(){
        if(tableau.getItems().isEmpty()){
            erreurTableVide.setText("Le tableau est déjà vide");
        }else{
            pizzaDAO.viderPizza();
            tableau.getItems().clear();
        }
    }
}