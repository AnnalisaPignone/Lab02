/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.*; 

import it.polito.tdp.alien.model.Dizionario;
import it.polito.tdp.alien.model.Traduzione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario modello; 
	int i; 
	int flag; 
	char a; 
	Set <String> trad= new <String> HashSet(); 

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea"
    private TextArea txtArea; // Value injected by FXMLLoader

    @FXML // fx:id="txtInserito"
    private TextField txtInserito; // Value injected by FXMLLoader

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	flag=0; 
    	//acquisizione e controllo dati 
    	String supporto= txtInserito.getText(); 
    	String[] parole = supporto.split(" ");
    	
    	if (parole.length==2) {
    	// controllo dati inseriti
    		char[] a = parole[0].toCharArray(); 
    		char[] b= parole[1].toCharArray(); 
    		
    		for(i=0; i<parole[0].length(); i++) {
    			if (Character.isLetter(a[i])==false) {
    				txtArea.setText("Le parole possono contenere solo caratteri alfabetici");
    				return; 
    			}
    		}
    		
    		for(i=0; i<parole[1].length(); i++) {
    			if (Character.isLetter(b[i])==false) {
    				txtArea.setText("Le parole possono contenere solo caratteri alfabetici");
    				return; 
    			}
    		}
    			
    	Traduzione temp= new Traduzione(parole[0], parole[1]); 
    	modello.add(temp); 
    	txtArea.setText("Traduzione inserita correttamente");
    	}
    	else if (parole.length==1){
    	List <Traduzione> listaTemp=modello.getTraduzioni(); 
    	for (i=0; i<listaTemp.size(); i++)
    	{
    		if(listaTemp.get(i).getParolaAliena().compareToIgnoreCase(parole[0])==0) {
    			//txtArea.setText(listaTemp.get(i).getTraduzioneItaliana());
    			trad.add(listaTemp.get(i).getTraduzioneItaliana());
    			txtArea.setText(trad.toString());
    			flag=1; 
    		}
    	}
    	if (flag==0) {
    		txtArea.setText("Spiacente, parola non trovata nel dizionario");
    	}
    }
    	else {
    		txtArea.setText("Per favore, inserisci soltanto due parole");
    	}
    }
    
    public void setModel(Dizionario modello) {
    	this.modello=modello; 
    }
    
   
    
	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserito != null : "fx:id=\"txtInserito\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
