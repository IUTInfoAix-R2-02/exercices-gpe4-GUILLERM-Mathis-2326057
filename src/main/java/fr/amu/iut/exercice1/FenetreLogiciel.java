package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création du conteneur principal
        VBox vbox = new VBox();
        BorderPane root = new BorderPane();

        // Création du conteneur correspondant à la ligne de contrôle haut avec les menu
        HBox MenuBox = new HBox();
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Edit");
        Menu menu3 = new Menu("Help");
        MenuItem New= new MenuItem("New");
        MenuItem Open= new MenuItem("Open");
        MenuItem Save= new MenuItem("Save");
        MenuItem Close= new MenuItem("Close");
        MenuItem Cut= new MenuItem("Cut");
        MenuItem Copy= new MenuItem("Copy");
        MenuItem Paste= new MenuItem("Paste");
        menu1.getItems().add(New);
        menu1.getItems().add(Open);
        menu1.getItems().add(Save);
        menu1.getItems().add(Close);
        menu2.getItems().add(Cut);
        menu2.getItems().add(Copy);
        menu2.getItems().add(Paste);
        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        Separator sepHor = new Separator(Orientation.HORIZONTAL);
        MenuBox.getChildren().addAll(menuBar,sepHor);
        HBox.setHgrow(MenuBox,Priority.ALWAYS);
        root.setTop(MenuBox);




        //creation bouton
        VBox leftControls = new VBox();
        leftControls.setAlignment( Pos.CENTER_LEFT );
        Label EtiqBout=new Label("Boutons :");
        Button bouton1= new Button("Bouton1");
        Button bouton2= new Button("Bouton2");
        Button bouton3= new Button("Bouton3");

        leftControls.getChildren().add( EtiqBout );
        leftControls.getChildren().add( bouton1 );
        leftControls.getChildren().add( bouton2 );
        leftControls.getChildren().add( bouton3 );
        leftControls.setMargin(EtiqBout, new Insets(5.0d));
        leftControls.setMargin(bouton1, new Insets(5.0d));
        leftControls.setMargin(bouton2, new Insets(5.0d));
        leftControls.setMargin(bouton3, new Insets(5.0d));

        //les trucs au centre avec le texte
        VBox CentreText = new VBox();

        HBox nomControls = new HBox();
        nomControls.setAlignment(Pos.CENTER);
        Label EtiqNom = new Label("Name: ");
        TextField champ = new TextField();
        nomControls.getChildren().addAll(EtiqNom,champ);
        nomControls.setSpacing(50);

        HBox Email = new HBox();
        Email.setAlignment(Pos.CENTER);
        Label EtiqMail = new Label("Email: ");
        TextField mail = new TextField();
        Email.getChildren().addAll(EtiqMail,mail);
        Email.setSpacing(50);

        HBox Passwd = new HBox();
        Passwd.setAlignment(Pos.CENTER);
        Label EtiqPsswd = new Label("Password: ");
        TextField Psswd = new TextField();
        Passwd.getChildren().addAll(EtiqPsswd,Psswd);
        Passwd.setSpacing(50);

        HBox lesBoutons =new HBox();
        lesBoutons.setAlignment(Pos.CENTER);
        Button Submit=new Button("Submit");
        Button Cancel=new Button("Cancel");
        lesBoutons.getChildren().addAll(Submit,Cancel);
        lesBoutons.setSpacing(50);

        CentreText.getChildren().addAll(nomControls,Email,Passwd,lesBoutons);
        CentreText.setAlignment(Pos.CENTER_RIGHT);


        Separator sepVert = new Separator(Orientation.VERTICAL);

        HBox ToutLeCentre= new HBox();
        ToutLeCentre.getChildren().addAll(leftControls,sepVert,CentreText);
        root.setCenter(ToutLeCentre);

        //bas de page
        VBox basAvecSep=new VBox();
        HBox basDePage= new HBox();
        Label texteBas=new Label("Ceci est un label de bas de page");
        basDePage.getChildren().addAll(texteBas);
        basDePage.setAlignment(Pos.CENTER);
        basAvecSep.getChildren().addAll(sepHor,basDePage);
        root.setBottom(basAvecSep);




        // Ajout du conteneur à la scene
        Scene scene = new Scene(root );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

