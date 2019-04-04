package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	AnagrammiModel model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button bntCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    public AnagrammiController() {
    	this.model = null;
    }
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	String parola = txtParola.getText();
    	//System.out.println("La parola inserita è: '"+parola+"'");
    	if(parola.equals("")) {
    		txtCorretti.setText("Inserisci prima una parola");
    		txtErrati.setText("Inserisci prima una parola");
    		return;
    	}
    	parola = parola.toLowerCase();
    	List<String> corretti = new ArrayList<String>();
    	List<String> errati = new ArrayList<String>();
    	model.trovaAnagrammi(parola, corretti, errati);
    	txtCorretti.clear();
    	txtErrati.clear();
    	for(String s : corretti) {
    		txtCorretti.appendText(s+"\n");
    	}
    	for(String s : errati) {
    		txtErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtParola.setPromptText("Inserisci qui la parola");
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bntCalcola != null : "fx:id=\"bntCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(AnagrammiModel model) {
		this.model = model;
	}
	
	public AnagrammiModel getModel() {
		return this.model;
	}
}

