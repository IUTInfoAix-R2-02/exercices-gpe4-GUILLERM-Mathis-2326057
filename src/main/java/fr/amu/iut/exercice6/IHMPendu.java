package fr.amu.iut.exercice6;

import javafx.application.Application;
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

import java.util.HashSet;
import java.util.Set;

public class IHMPendu extends Application {

    private Label livesLabel;
    private Label wordLabel;
    private TextField barre;
    private int lives;
    private String wordToGuess;
    private Set<Character> guessedLetters;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        VBox lettre = new VBox();
        HBox rejouer=new HBox();
        Button retryButton = new Button("Rejoue Pélo");
        retryButton.setOnAction(event -> setupGame());
        rejouer.getChildren().addAll(retryButton);
        rejouer.setAlignment(Pos.BOTTOM_CENTER);

        Button a = new Button("A");
        Button e = new Button("E");
        Button i = new Button("I");
        Button o = new Button("O");
        Button u = new Button("U");
        Button y = new Button("Y");
        HBox ae = new HBox();
        ae.getChildren().addAll(a, e, i, o, u, y);
        ae.setAlignment(Pos.CENTER);

        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button f = new Button("F");
        Button g = new Button("G");
        Button h = new Button("H");
        Button j = new Button("J");
        Button k = new Button("K");
        Button l = new Button("L");
        Button m = new Button("M");
        HBox bm = new HBox();
        bm.getChildren().addAll(b, c, d, f, g, h, j, k, l, m);
        bm.setAlignment(Pos.CENTER);

        Button n = new Button("N");
        Button p = new Button("P");
        Button q = new Button("Q");
        Button r = new Button("R");
        Button s = new Button("S");
        Button t = new Button("T");
        Button v = new Button("V");
        Button w = new Button("W");
        Button x = new Button("X");
        Button z = new Button("Z");
        HBox nz = new HBox();
        nz.getChildren().addAll(n, p, q, r, s, t, v, w, x, z);
        nz.setAlignment(Pos.CENTER);

        barre = new TextField();
        barre.setAlignment(Pos.CENTER);
        lettre.getChildren().addAll(barre, ae, bm, nz,rejouer);
        root.setBottom(lettre);

        livesLabel = new Label();
        wordLabel = new Label();
        wordLabel.setStyle("-fx-font-size: 20px;");


        VBox mot = new VBox(10, livesLabel, wordLabel);
        mot.setAlignment(Pos.CENTER);
        root.setCenter(mot);

        a.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('A'));
        b.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('B'));
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('C'));
        d.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('D'));
        e.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('E'));
        f.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('F'));
        g.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('G'));
        h.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('H'));
        i.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('I'));
        j.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('J'));
        k.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('K'));
        l.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('L'));
        m.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('M'));
        n.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('N'));
        o.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('O'));
        p.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('P'));
        q.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('Q'));
        r.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('R'));
        s.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('S'));
        t.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('T'));
        u.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('U'));
        v.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('V'));
        w.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('W'));
        x.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('X'));
        y.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('Y'));
        z.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleGuess('Z'));

        setupGame();

        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        root.setStyle("-fx-background-color: turquoise; -fx-text-fill: white;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupGame() {
        guessedLetters = new HashSet<>();
        lives = 7;

        Dico dico = new Dico();
        wordToGuess = dico.getMot().toUpperCase();
        updateWordLabel();
        updateLivesLabel();
    }

    private void handleGuess(char letter) {
        if (guessedLetters.contains(letter)) {
            return; // Skip if already guessed
        }

        guessedLetters.add(letter);

        if (wordToGuess.contains(String.valueOf(letter))) {
            updateWordLabel();
        } else {
            lives--;
            updateLivesLabel();
        }

        checkGameStatus();
    }

    private void updateWordLabel() {
        StringBuilder displayedWord = new StringBuilder();
        for (char letter : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                displayedWord.append(letter);
            } else {
                displayedWord.append('*');
            }
        }
        wordLabel.setText(displayedWord.toString());
    }

    private void updateLivesLabel() {
        livesLabel.setText("Nombre de vies : " + lives);
    }

    private void checkGameStatus() {
        if (lives <= 0) {
            wordLabel.setText(wordToGuess);
            barre.setText("Perdu!");
        } else if (wordLabel.getText().equals(wordToGuess)) {
            barre.setText("Gagné!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}