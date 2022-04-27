package it.polito.tdp.alien.model;
import java.util.*; 

public class Dizionario {
	
	List <Traduzione> traduzioni= new LinkedList <Traduzione>(); 
	
	public void add(Traduzione t) {
		this.traduzioni.add(t); 
	}

	public List <Traduzione> getTraduzioni(){
		return this.traduzioni; 
	}
}
