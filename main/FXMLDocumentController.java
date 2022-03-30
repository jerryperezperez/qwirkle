package main;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.bind.SchemaOutputResolver;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView casilla_0_0;
    
    @FXML
    private ImageView casilla_1_0;
    
    @FXML
    private ImageView casilla_2_0;
    
    @FXML
    private ImageView casilla_3_0;
    
    @FXML
    private ImageView casilla_4_0;
    
    @FXML
    private ImageView casilla_5_0;
    
    @FXML
    private ImageView casilla_6_0;
    
    @FXML
    private ImageView casilla_7_0;
    
    @FXML
    private ImageView casilla_8_0;
    
    @FXML
    private ImageView casilla_9_0;
    
    @FXML
    private ImageView casilla_10_0;
    
    @FXML
    private ImageView casilla_11_0;
    
    @FXML
    private ImageView casilla_12_0;
    
    @FXML
    private ImageView casilla_13_0;
    
    @FXML
    private ImageView casilla_14_0;
    
    @FXML
    private ImageView casilla_15_0;
    
    @FXML
    private ImageView casilla_16_0;
    
    @FXML
    private ImageView casilla_17_0;
    
    @FXML
    private ImageView casilla_0_1;
    
    @FXML
    private ImageView casilla_1_1;
    
    @FXML
    private ImageView casilla_2_1;
    
    @FXML
    private ImageView casilla_3_1;
    
    @FXML
    private ImageView casilla_4_1;
    
    @FXML
    private ImageView casilla_5_1;
    
    @FXML
    private ImageView casilla_6_1;
    
    @FXML
    private ImageView casilla_7_1;
    
    @FXML
    private ImageView casilla_8_1;
    
    @FXML
    private ImageView casilla_9_1;
    
    @FXML
    private ImageView casilla_10_1;
    
    @FXML
    private ImageView casilla_11_1;
    
    @FXML
    private ImageView casilla_12_1;
    
    @FXML
    private ImageView casilla_13_1;
    
    @FXML
    private ImageView casilla_14_1;
    
    @FXML
    private ImageView casilla_15_1;
    
    @FXML
    private ImageView casilla_16_1;
    
    @FXML
    private ImageView casilla_17_1;
    
    @FXML
    private ImageView casilla_0_2;
    
    @FXML
    private ImageView casilla_1_2;
    
    @FXML
    private ImageView casilla_2_2;
    
    @FXML
    private ImageView casilla_3_2;
    
    @FXML
    private ImageView casilla_4_2;
    
    @FXML
    private ImageView casilla_5_2;
    
    @FXML
    private ImageView casilla_6_2;
    
    @FXML
    private ImageView casilla_7_2;
    
    @FXML
    private ImageView casilla_8_2;
    
    @FXML
    private ImageView casilla_9_2;
    
    @FXML
    private ImageView casilla_10_2;
    
    @FXML
    private ImageView casilla_11_2;
    
    @FXML
    private ImageView casilla_12_2;
    
    @FXML
    private ImageView casilla_13_2;
    
    @FXML
    private ImageView casilla_14_2;
    
    @FXML
    private ImageView casilla_15_2;
    
    @FXML
    private ImageView casilla_16_2;
    
    @FXML
    private ImageView casilla_17_2;
    
    @FXML
    private ImageView casilla_0_3;
    
    @FXML
    private ImageView casilla_1_3;
    
    @FXML
    private ImageView casilla_2_3;
    
    @FXML
    private ImageView casilla_3_3;
    
    @FXML
    private ImageView casilla_4_3;
    
    @FXML
    private ImageView casilla_5_3;
    
    @FXML
    private ImageView casilla_6_3;
    
    @FXML
    private ImageView casilla_7_3;
    
    @FXML
    private ImageView casilla_8_3;
    
    @FXML
    private ImageView casilla_9_3;
    
    @FXML
    private ImageView casilla_10_3;
    
    @FXML
    private ImageView casilla_11_3;
    
    @FXML
    private ImageView casilla_12_3;
    
    @FXML
    private ImageView casilla_13_3;
    
    @FXML
    private ImageView casilla_14_3;
    
    @FXML
    private ImageView casilla_15_3;
    
    @FXML
    private ImageView casilla_16_3;
    
    @FXML
    private ImageView casilla_17_3;
    
    @FXML
    private ImageView casilla_0_4;
    
    @FXML
    private ImageView casilla_1_4;
    
    @FXML
    private ImageView casilla_2_4;
    
    @FXML
    private ImageView casilla_3_4;
    
    @FXML
    private ImageView casilla_4_4;
    
    @FXML
    private ImageView casilla_5_4;
    
    @FXML
    private ImageView casilla_6_4;
    
    @FXML
    private ImageView casilla_7_4;
    
    @FXML
    private ImageView casilla_8_4;
    
    @FXML
    private ImageView casilla_9_4;
    
    @FXML
    private ImageView casilla_10_4;
    
    @FXML
    private ImageView casilla_11_4;
    
    @FXML
    private ImageView casilla_12_4;
    
    @FXML
    private ImageView casilla_13_4;
    
    @FXML
    private ImageView casilla_14_4;
    
    @FXML
    private ImageView casilla_15_4;
    
    @FXML
    private ImageView casilla_16_4;
    
    @FXML
    private ImageView casilla_17_4;
    
    @FXML
    private ImageView casilla_0_5;
    
    @FXML
    private ImageView casilla_1_5;
    
    @FXML
    private ImageView casilla_2_5;
    
    @FXML
    private ImageView casilla_3_5;
    
    @FXML
    private ImageView casilla_4_5;
    
    @FXML
    private ImageView casilla_5_5;
    
    @FXML
    private ImageView casilla_6_5;
    
    @FXML
    private ImageView casilla_7_5;
    
    @FXML
    private ImageView casilla_8_5;
    
    @FXML
    private ImageView casilla_9_5;
    
    @FXML
    private ImageView casilla_10_5;
    
    @FXML
    private ImageView casilla_11_5;
    
    @FXML
    private ImageView casilla_12_5;
    
    @FXML
    private ImageView casilla_13_5;
    
    @FXML
    private ImageView casilla_14_5;
    
    @FXML
    private ImageView casilla_15_5;
    
    @FXML
    private ImageView casilla_16_5;
    
    @FXML
    private ImageView casilla_17_5;
    
    @FXML
    private ImageView casilla_0_6;
    
    @FXML
    private ImageView casilla_1_6;
    
    @FXML
    private ImageView casilla_2_6;
    
    @FXML
    private ImageView casilla_3_6;
    
    @FXML
    private ImageView casilla_4_6;
    
    @FXML
    private ImageView casilla_5_6;
    
    @FXML
    private ImageView casilla_6_6;
    
    @FXML
    private ImageView casilla_7_6;
    
    @FXML
    private ImageView casilla_8_6;
    
    @FXML
    private ImageView casilla_9_6;
    
    @FXML
    private ImageView casilla_10_6;
    
    @FXML
    private ImageView casilla_11_6;
    
    @FXML
    private ImageView casilla_12_6;
    
    @FXML
    private ImageView casilla_13_6;
    
    @FXML
    private ImageView casilla_14_6;
    
    @FXML
    private ImageView casilla_15_6;
    
    @FXML
    private ImageView casilla_16_6;
    
    @FXML
    private ImageView casilla_17_6;
    
    @FXML
    private ImageView casilla_0_7;
    
    @FXML
    private ImageView casilla_1_7;
    
    @FXML
    private ImageView casilla_2_7;
    
    @FXML
    private ImageView casilla_3_7;
    
    @FXML
    private ImageView casilla_4_7;
    
    @FXML
    private ImageView casilla_5_7;
    
    @FXML
    private ImageView casilla_6_7;
    
    @FXML
    private ImageView casilla_7_7;
    
    @FXML
    private ImageView casilla_8_7;
    
    @FXML
    private ImageView casilla_9_7;
    
    @FXML
    private ImageView casilla_10_7;
    
    @FXML
    private ImageView casilla_11_7;
    
    @FXML
    private ImageView casilla_12_7;
    
    @FXML
    private ImageView casilla_13_7;
    
    @FXML
    private ImageView casilla_14_7;
    
    @FXML
    private ImageView casilla_15_7;
    
    @FXML
    private ImageView casilla_16_7;
    
    @FXML
    private ImageView casilla_17_7;
    
    @FXML
    private ImageView casilla_0_8;
    
    @FXML
    private ImageView casilla_1_8;
    
    @FXML
    private ImageView casilla_2_8;
    
    @FXML
    private ImageView casilla_3_8;
    
    @FXML
    private ImageView casilla_4_8;
    
    @FXML
    private ImageView casilla_5_8;
    
    @FXML
    private ImageView casilla_6_8;
    
    @FXML
    private ImageView casilla_7_8;
    
    @FXML
    private ImageView casilla_8_8;
    
    @FXML
    private ImageView casilla_9_8;
    
    @FXML
    private ImageView casilla_10_8;
    
    @FXML
    private ImageView casilla_11_8;
    
    @FXML
    private ImageView casilla_12_8;
    
    @FXML
    private ImageView casilla_13_8;
    
    @FXML
    private ImageView casilla_14_8;
    
    @FXML
    private ImageView casilla_15_8;
    
    @FXML
    private ImageView casilla_16_8;
    
    @FXML
    private ImageView casilla_17_8;
    
    @FXML
    private ImageView casilla_0_9;
    
    @FXML
    private ImageView casilla_1_9;
    
    @FXML
    private ImageView casilla_2_9;
    
    @FXML
    private ImageView casilla_3_9;
    
    @FXML
    private ImageView casilla_4_9;
    
    @FXML
    private ImageView casilla_5_9;
    
    @FXML
    private ImageView casilla_6_9;
    
    @FXML
    private ImageView casilla_7_9;
    
    @FXML
    private ImageView casilla_8_9;
    
    @FXML
    private ImageView casilla_9_9;
    
    @FXML
    private ImageView casilla_10_9;
    
    @FXML
    private ImageView casilla_11_9;
    
    @FXML
    private ImageView casilla_12_9;
    
    @FXML
    private ImageView casilla_13_9;
    
    @FXML
    private ImageView casilla_14_9;
    
    @FXML
    private ImageView casilla_15_9;
    
    @FXML
    private ImageView casilla_16_9;
    
    @FXML
    private ImageView casilla_17_9;
    
    @FXML
    private ImageView casilla_0_10;
    
    @FXML
    private ImageView casilla_1_10;
    
    @FXML
    private ImageView casilla_2_10;
    
    @FXML
    private ImageView casilla_3_10;
    
    @FXML
    private ImageView casilla_4_10;
    
    @FXML
    private ImageView casilla_5_10;
    
    @FXML
    private ImageView casilla_6_10;
    
    @FXML
    private ImageView casilla_7_10;
    
    @FXML
    private ImageView casilla_8_10;
    
    @FXML
    private ImageView casilla_9_10;
    
    @FXML
    private ImageView casilla_10_10;
    
    @FXML
    private ImageView casilla_11_10;
    
    @FXML
    private ImageView casilla_12_10;
    
    @FXML
    private ImageView casilla_13_10;
    
    @FXML
    private ImageView casilla_14_10;
    
    @FXML
    private ImageView casilla_15_10;
    
    @FXML
    private ImageView casilla_16_10;
    
    @FXML
    private ImageView casilla_17_10;
    
    @FXML
    private ImageView casilla_0_11;
    
    @FXML
    private ImageView casilla_1_11;
    
    @FXML
    private ImageView casilla_2_11;
    
    @FXML
    private ImageView casilla_3_11;
    
    @FXML
    private ImageView casilla_4_11;
    
    @FXML
    private ImageView casilla_5_11;
    
    @FXML
    private ImageView casilla_6_11;
    
    @FXML
    private ImageView casilla_7_11;
    
    @FXML
    private ImageView casilla_8_11;
    
    @FXML
    private ImageView casilla_9_11;
    
    @FXML
    private ImageView casilla_10_11;
    
    @FXML
    private ImageView casilla_11_11;
    
    @FXML
    private ImageView casilla_12_11;
    
    @FXML
    private ImageView casilla_13_11;
    
    @FXML
    private ImageView casilla_14_11;
    
    @FXML
    private ImageView casilla_15_11;
    
    @FXML
    private ImageView casilla_16_11;
    
    @FXML
    private ImageView casilla_17_11;
    
    @FXML
    private ImageView casilla_0_12;
    
    @FXML
    private ImageView casilla_1_12;
    
    @FXML
    private ImageView casilla_2_12;
    
    @FXML
    private ImageView casilla_3_12;
    
    @FXML
    private ImageView casilla_4_12;
    
    @FXML
    private ImageView casilla_5_12;
    
    @FXML
    private ImageView casilla_6_12;
    
    @FXML
    private ImageView casilla_7_12;
    
    @FXML
    private ImageView casilla_8_12;
    
    @FXML
    private ImageView casilla_9_12;
    
    @FXML
    private ImageView casilla_10_12;
    
    @FXML
    private ImageView casilla_11_12;
    
    @FXML
    private ImageView casilla_12_12;
    
    @FXML
    private ImageView casilla_13_12;
    
    @FXML
    private ImageView casilla_14_12;
    
    @FXML
    private ImageView casilla_15_12;
    
    @FXML
    private ImageView casilla_16_12;
    
    @FXML
    private ImageView casilla_17_12;
    
    @FXML
    private ImageView casilla_0_13;
    
    @FXML
    private ImageView casilla_1_13;
    
    @FXML
    private ImageView casilla_2_13;
    
    @FXML
    private ImageView casilla_3_13;
    
    @FXML
    private ImageView casilla_4_13;
    
    @FXML
    private ImageView casilla_5_13;
    
    @FXML
    private ImageView casilla_6_13;
    
    @FXML
    private ImageView casilla_7_13;
    
    @FXML
    private ImageView casilla_8_13;
    
    @FXML
    private ImageView casilla_9_13;
    
    @FXML
    private ImageView casilla_10_13;
    
    @FXML
    private ImageView casilla_11_13;
    
    @FXML
    private ImageView casilla_12_13;
    
    @FXML
    private ImageView casilla_13_13;
    
    @FXML
    private ImageView casilla_14_13;
    
    @FXML
    private ImageView casilla_15_13;
    
    @FXML
    private ImageView casilla_16_13;
    
    @FXML
    private ImageView casilla_17_13;
    
    @FXML
    private ImageView casilla_0_14;
    
    @FXML
    private ImageView casilla_1_14;
    
    @FXML
    private ImageView casilla_2_14;
    
    @FXML
    private ImageView casilla_3_14;
    
    @FXML
    private ImageView casilla_4_14;
    
    @FXML
    private ImageView casilla_5_14;
    
    @FXML
    private ImageView casilla_6_14;
    
    @FXML
    private ImageView casilla_7_14;
    
    @FXML
    private ImageView casilla_8_14;
    
    @FXML
    private ImageView casilla_9_14;
    
    @FXML
    private ImageView casilla_10_14;
    
    @FXML
    private ImageView casilla_11_14;
    
    @FXML
    private ImageView casilla_12_14;
    
    @FXML
    private ImageView casilla_13_14;
    
    @FXML
    private ImageView casilla_14_14;
    
    @FXML
    private ImageView casilla_15_14;
    
    @FXML
    private ImageView casilla_16_14;
    
    @FXML
    private ImageView casilla_17_14;
    
    @FXML
    private ImageView casilla_0_15;
    
    @FXML
    private ImageView casilla_1_15;
    
    @FXML
    private ImageView casilla_2_15;
    
    @FXML
    private ImageView casilla_3_15;
    
    @FXML
    private ImageView casilla_4_15;
    
    @FXML
    private ImageView casilla_5_15;
    
    @FXML
    private ImageView casilla_6_15;
    
    @FXML
    private ImageView casilla_7_15;
    
    @FXML
    private ImageView casilla_8_15;
    
    @FXML
    private ImageView casilla_9_15;
    
    @FXML
    private ImageView casilla_10_15;
    
    @FXML
    private ImageView casilla_11_15;
    
    @FXML
    private ImageView casilla_12_15;
    
    @FXML
    private ImageView casilla_13_15;
    
    @FXML
    private ImageView casilla_14_15;
    
    @FXML
    private ImageView casilla_15_15;
    
    @FXML
    private ImageView casilla_16_15;
    
    @FXML
    private ImageView casilla_17_15;
    
    @FXML
    private ImageView casilla_0_16;
    
    @FXML
    private ImageView casilla_1_16;
    
    @FXML
    private ImageView casilla_2_16;
    
    @FXML
    private ImageView casilla_3_16;
    
    @FXML
    private ImageView casilla_4_16;
    
    @FXML
    private ImageView casilla_5_16;
    
    @FXML
    private ImageView casilla_6_16;
    
    @FXML
    private ImageView casilla_7_16;
    
    @FXML
    private ImageView casilla_8_16;
    
    @FXML
    private ImageView casilla_9_16;
    
    @FXML
    private ImageView casilla_10_16;
    
    @FXML
    private ImageView casilla_11_16;
    
    @FXML
    private ImageView casilla_12_16;
    
    @FXML
    private ImageView casilla_13_16;
    
    @FXML
    private ImageView casilla_14_16;
    
    @FXML
    private ImageView casilla_15_16;
    
    @FXML
    private ImageView casilla_16_16;
    
    @FXML
    private ImageView casilla_17_16;
    
    @FXML
    private ImageView casilla_0_17;
    
    @FXML
    private ImageView casilla_1_17;
    
    @FXML
    private ImageView casilla_2_17;
    
    @FXML
    private ImageView casilla_3_17;
    
    @FXML
    private ImageView casilla_4_17;
    
    @FXML
    private ImageView casilla_5_17;
    
    @FXML
    private ImageView casilla_6_17;
    
    @FXML
    private ImageView casilla_7_17;
    
    @FXML
    private ImageView casilla_8_17;
    
    @FXML
    private ImageView casilla_9_17;
    
    @FXML
    private ImageView casilla_10_17;
    
    @FXML
    private ImageView casilla_11_17;
    
    @FXML
    private ImageView casilla_12_17;
    
    @FXML
    private ImageView casilla_13_17;
    
    @FXML
    private ImageView casilla_14_17;
    
    @FXML
    private ImageView casilla_15_17;
    
    @FXML
    private ImageView casilla_16_17;
    
    @FXML
    private ImageView casilla_17_17;
    
    @FXML
    private Label pj1;
    
    @FXML
    private Label pj2;
    
    @FXML
    private Label pj3;
    
    @FXML
    private Label pj4;
    
    @FXML
    private ImageView imgperfil;

    @FXML
    private ImageView ficha_n1;

    @FXML
    private ImageView ficha_n2;

    @FXML
    private ImageView ficha_n3;

    @FXML
    private ImageView ficha_n4;

    @FXML
    private ImageView ficha_n5;

    @FXML
    private ImageView ficha_n6;
    
    @FXML
    private ImageView ficha_cambio_n1;
    
    @FXML
    private ImageView ficha_cambio_n2;
    
    @FXML
    private ImageView ficha_cambio_n3;
    
    @FXML
    private ImageView ficha_cambio_n4;
    
    @FXML
    private ImageView ficha_cambio_n5;
    
    @FXML
    private ImageView ficha_cambio_n6;

    Juego juego;
    int idFicha;
    ImageView [] arregloImageView;


    public void actualizarFichasTablero(){
       for (int i=0; i<juego.getJugadorEnTurno().getFichas().length; i++){
           System.out.println("CANTIDAD DE FICHAS ACTUALES E MANO : " + juego.getJugadorEnTurno().getFichas().length);
            idFicha = (juego.getJugadorEnTurno().getFichas()[i].getId());
           arregloImageView[i].setImage(new Image("Fichas/Ficha"+ idFicha +".png"));
       }
    }

    @FXML
    private void seleccionarFicha (MouseEvent event) {
        this.actualizarFichasTablero();
        String fs = event.getSource().toString();
        for (int i = 0; i < this.juego.getJugadorEnTurno().getFichas().length; i++) {
            if (((ImageView) (event.getSource())).getId().equals(this.arregloImageView[i].getId())) {
                ((ImageView) (event.getSource())).setImage(new Image("Fichas/Ficha0.png"));
                this.juego.getJugadorEnTurno().setFichaSeleccionada(this.juego.getJugadorEnTurno().getFichas()[i]);
            }
        }
    }

    @FXML
    private void ponerFicha(MouseEvent event) {
        if (juego.getJugadorEnTurno().getFichaSeleccionada() != null) {
            ((ImageView) (event.getSource())).setImage(new Image("Fichas/Ficha" + this.juego.getJugadorEnTurno().getFichaSeleccionada().getId() + ".png"));
            this.juego.getJugadorEnTurno().removerFicha(this.juego.getJugadorEnTurno().getFichaSeleccionada());
            //una vez puesta la ficha, se agrega otra al jugador de manera automática
            this.juego.getJugadorEnTurno().setFicha(this.juego.sacarFichaBolsa());
        }
        this.juego.getJugadorEnTurno().removerFichaSeleccionada();
        this.actualizarFichasTablero();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        juego = new Juego(4);
        arregloImageView = new ImageView[] {ficha_n1, ficha_n2, ficha_n3,
                ficha_n4, ficha_n5, ficha_n6};
        this.actualizarFichasTablero();

    }
    
}
