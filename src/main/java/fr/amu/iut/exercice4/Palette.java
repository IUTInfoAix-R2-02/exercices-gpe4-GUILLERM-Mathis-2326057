package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root ;
    private Label label;
    private Pane panneau;
    private HBox bas;
    private HBox haut;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root=new BorderPane();
        this.bas=new HBox();
        this.haut=new HBox();
        this.panneau=new Pane();
        this.label=new Label();

        this.vert=new Button("Vert");

        this.vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbVert=this.nbVert+1;
            label.setText("Vert choisi "+this.nbVert+" fois");
            this.panneau.setStyle("-fx-background-color: green");
        });

        this.rouge=new Button("Rouge");
        this.rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbRouge=this.nbRouge+1;
            label.setText("Rouge choisi "+this.nbRouge+" fois");
            this.panneau.setStyle("-fx-background-color: red");
        });

        this.bleu=new Button("Bleu");
        this.bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbBleu=this.nbBleu+1;
            label.setText("Bleu choisi "+this.nbBleu+" fois");
            this.panneau.setStyle("-fx-background-color: blue");
        });



        this.haut.getChildren().add(label);
        this.haut.setAlignment(Pos.CENTER);

        this.bas.getChildren().addAll(this.vert,this.rouge,this.bleu);
        this.bas.setAlignment(Pos.CENTER);
        this.bas.setSpacing(25);
        this.root.setBottom(this.bas);
        this.root.setCenter(this.panneau);
        this.root.setTop(this.haut);


        // Ajout du conteneur à la scene
        Scene scene = new Scene(this.root);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 400 );
        primaryStage.setHeight( 200 );

        // Affichage de la fenêtre
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }
}

