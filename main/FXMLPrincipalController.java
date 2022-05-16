package main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;
import static javafx.fxml.FXMLLoader.getDefaultClassLoader;

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
    public void eventoJugar(MouseEvent mouseEvent) throws IOException {


        Node source = (Node) mouseEvent.getSource();     //Me devuelve el elemento al que hice click
        Stage stage2 = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLDocumentController controlador = (FXMLDocumentController) fxmlLoader.getController();
        stage.show();
        controlador.setJugadores(this.listaJugadores);




    }
}
