package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AtomicInteger nbVies= new AtomicInteger(7);
        BorderPane root = new BorderPane();
        VBox toutBas=new VBox();
        //toutes les case avec les numéros
        HBox PLigne=new HBox();
        Button a=new Button("a");
        Button e=new Button("e");
        Button i=new Button("i");
        Button o=new Button("o");
        Button u=new Button("u");
        Button y=new Button("y");
        PLigne.getChildren().addAll(a,e,i,o,u,y);
        PLigne.setAlignment(Pos.CENTER);
        HBox DLigne=new HBox();
        Button b=new Button("b");
        Button c=new Button("c");
        Button d=new Button("d");
        Button f=new Button("f");
        Button g=new Button("g");
        Button h=new Button("h");
        Button j=new Button("j");
        Button k=new Button("k");
        Button l=new Button("l");
        Button m=new Button("m");
        DLigne.getChildren().addAll(b,c,d,f,g,h,j,k,l,m);
        DLigne.setAlignment(Pos.CENTER);
        HBox TLigne=new HBox();
        Button n=new Button("n");
        Button p=new Button("p");
        Button q=new Button("q");
        Button r=new Button("r");
        Button s=new Button("s");
        Button t=new Button("t");
        Button v=new Button("v");
        Button w=new Button("w");
        Button x=new Button("x");
        Button z=new Button("z");
        TLigne.getChildren().addAll(n,p,q,r,s,t,v,w,x,z);
        TLigne.setAlignment(Pos.CENTER);
        HBox boutonBas=new HBox();
        Button Rejouer=new Button("Rejouer");
        boutonBas.getChildren().add(Rejouer);
        boutonBas.setAlignment(Pos.CENTER);

        //text field pour choisir la lettre
        VBox Milieu=new VBox();
        //Bas Vbox
        toutBas.getChildren().addAll(PLigne,DLigne,TLigne,boutonBas);
        root.setBottom(toutBas);

        //nbVie
        HBox nbViesBox=new HBox();
        Label nbVieLab=new Label("Nombre de vie :"+nbVies);
        nbViesBox.getChildren().add(nbVieLab);
        nbViesBox.setAlignment(Pos.CENTER);

        //mot a deviner
        HBox mot=new HBox();
        String motCache;
        Dico CreationMot=new Dico();
        motCache=CreationMot.getMot();
        String motEtoile=new String();
        String finalMotCache = motCache;
        for (int I=0;I<motCache.length();I++){
            motEtoile=motEtoile+"*";
        }

        AtomicReference<String> finalMotEtoile = new AtomicReference<>(motEtoile);
        Label motEtoileComp=new Label(finalMotEtoile.get());

        Label TESTAENLEVER=new Label(finalMotCache);

        mot.getChildren().add(motEtoileComp);
        mot.setAlignment(Pos.CENTER);

        //Vbox milieu
        Milieu.getChildren().addAll(nbViesBox,mot,TESTAENLEVER);
        root.setCenter(Milieu);


        a.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
                if (CreationMot.getPositions('a', finalMotCache).isEmpty()){
                    nbVies.decrementAndGet();
                    nbVieLab.setText("Nombre de vie :"+nbVies);
                }
                else {
                    for (int I=0;I<CreationMot.getPositions('a', finalMotCache).size();I++){
                        int charAModif= (CreationMot.getPositions('a', finalMotCache)).get(I);
                        finalMotEtoile.set(finalMotEtoile.get().substring(0, charAModif) + 'a' + finalMotEtoile.get().substring(charAModif + 1));
                        motEtoileComp.setText(finalMotEtoile.get());

                    }


                }
            if (finalMotEtoile.equals(finalMotCache)){
                System.out.println("gagné");
                Platform.exit();
            }
                if (nbVies.get() ==0){
                    Platform.exit();
                }
        });
        e.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            if (CreationMot.getPositions('e', finalMotCache).isEmpty()){
                nbVies.decrementAndGet();
                nbVieLab.setText("Nombre de vie :"+nbVies);
            }
            else {
                for (int I=0;I<CreationMot.getPositions('e', finalMotCache).size();I++){
                    int charAModif= (CreationMot.getPositions('e', finalMotCache)).get(I);
                    finalMotEtoile.set(finalMotEtoile.get().substring(0, charAModif) + 'e' + finalMotEtoile.get().substring(charAModif + 1));
                    motEtoileComp.setText(finalMotEtoile.get());

                }

            }
            if (finalMotEtoile.equals(finalMotCache)){
                System.out.println("gagné");
                Platform.exit();
            }
            if (nbVies.get() ==0){
                Platform.exit();
            }
        });



        root.setStyle("-fx-background-color: TURQUOISE");
        Scene scene =new Scene(root);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.setScene(scene);
        // A completer

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
