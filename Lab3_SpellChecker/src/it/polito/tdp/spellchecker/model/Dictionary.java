package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	List<String>dizionario;
	
	public Dictionary() {
		dizionario=new ArrayList<String>();
	}

	public void loadDictionary(String language) {
		if(language.equals("English")) {
			try {
				FileReader fr=new FileReader("rsc/English.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					//Aggiungo alla struttura dati
					dizionario.add(word);
				}
				br.close();
			}catch(IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}
		else if(language.equals("Italiano")) {
			try {
				FileReader fr=new FileReader("rsc/Italian.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					//Aggiungo alla struttura dati
					dizionario.add(word);
				}
				br.close();
			}catch(IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}
		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord>parole=new ArrayList<RichWord>();
		
		RichWord p;
		
		for(String s: inputTextList) {
			if(dizionario.contains(s)) {
				p=new RichWord(s);
				p.setCorretta(true);
				parole.add(p);
			}else {
				p=new RichWord(s);
				p.setCorretta(false);
				parole.add(p);
			}
		}
		
		return parole;
	}
	
	
	
	
	
}
