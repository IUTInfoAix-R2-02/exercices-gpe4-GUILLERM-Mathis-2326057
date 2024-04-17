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

import java.util.ArrayList;
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
        Obstacle mur3=new Obstacle(300,20,40,100);
        Obstacle mur4=new Obstacle(400,20,200,40);
        ArrayList<Obstacle> obstList=new ArrayList<Obstacle>();
        obstList.add(mur);
        obstList.add(mur2);
        obstList.add(mur3);
        obstList.add(mur4);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        for(int i=0; i< obstList.size();i++){
            jeu.getChildren().add(obstList.get(i));
        }
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome,obstList);

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
    private void deplacer(Personnage j1, Personnage j2,ArrayList<Obstacle> obstList) {
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
            for(int i=0; i< obstList.size();i++){
                if (j1.murCollision(obstList.get(i))) {
                    j1.setLayoutX(posJ1X);
                    j1.setLayoutY(posJ1Y);
                }
                if (j2.murCollision(obstList.get(i))) {
                    j2.setLayoutX(posJ2X);
                    j2.setLayoutY(posJ2Y);
                }
            }

        });
    }


}
