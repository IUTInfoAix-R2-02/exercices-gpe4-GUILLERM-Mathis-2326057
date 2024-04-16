package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(50 * 10);

        //obstacle
        Obstacle mur=new Obstacle(200,200,200,200);
        Obstacle mur2=new Obstacle(20,100,100,200);
        Obstacle mur3=new Obstacle(300,20,10,100);
        Obstacle mur4=new Obstacle(400,20,200,20);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(mur,mur2,mur3,mur4);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome,mur,mur2,mur3,mur4);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2,Obstacle mur,Obstacle mur2,Obstacle mur3,Obstacle mur4) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double posJ1X=j1.getLayoutX();
            double posJ1Y=j1.getLayoutY();
            double posJ2X=j2.getLayoutX();
            double posJ2Y=j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getWidth());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;

            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                Platform.exit();
            }
            if (j1.murCollision(mur) || j1.murCollision(mur2)
                    ||j1.murCollision(mur3)||j1.murCollision(mur4) ) {
                j1.setLayoutX(posJ1X);
                j1.setLayoutY(posJ1Y);
            }
            if (j2.murCollision(mur)|| j2.murCollision(mur2)
                    ||j2.murCollision(mur3)||j2.murCollision(mur4) ) {
                j2.setLayoutX(posJ2X);
                j2.setLayoutY(posJ2Y);
            }
        });
    }


}
