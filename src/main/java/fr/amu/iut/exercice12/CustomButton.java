package fr.amu.iut.exercice12;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;

public class CustomButton extends Button {

    private final IntegerProperty nbClics = new SimpleIntegerProperty(0);
    private final String couleur;

    public CustomButton(String text, String couleur) {
        super(text);
        this.couleur = couleur;
    }

    public int getNbClics() {
        return nbClics.get();
    }

    public void setNbClics(int nbClics) {
        this.nbClics.set(nbClics);
    }

    public IntegerProperty nbClicsProperty() {
        return nbClics;
    }

    public String getCouleur() {
        return couleur;
    }
}