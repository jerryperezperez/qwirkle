package main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPrincipalController implements Initializable {
    @FXML
    public ListView<String> listaJugadores;
    @FXML
    public Spinner<Integer> spinnerJugadores;
    @FXML
    private MenuItem botonCantidadJugadores;
    @FXML
    private Button botonPrueba;


    public void eventoJugador(ActionEvent actionEvent) {
        this.listaJugadores.getItems().clear();
        JOptionPane.showMessageDialog(null, "IMPRIME" + actionEvent.getSource().toString());
        for (int i = 0; i < Integer.parseInt(((MenuItem) actionEvent.getSource()).getText()); i++) {
            this.listaJugadores.getItems().add("Jugador Humano");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.spinnerJugadores.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0));

        this.spinnerJugadores.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if (oldValue < newValue) {
                    listaJugadores.getItems().add("Jugador Humano");
                } else {
                    listaJugadores.getItems().remove("Jugador Humano");
                }
            }
        });

    }

    @FXML
    public void eventoBot(ActionEvent actionEvent) {
        this.listaJugadores.getItems().add(((MenuItem) actionEvent.getSource()).getText());
    }

    @FXML
    public void eventoJugar(MouseEvent mouseEvent) {
        if (this.listaJugadores.getItems().get(0).equals("Jugador Humano")) {
            JOptionPane.showMessageDialog(null, "NO puede empezar un bot");
        }
    }
}
