package br.ufba.mata62.SistemaAcademico.repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveHtmlRepository {
	 public static void salvarHistoricoHtml(String nomeHtml, String salvar) {
	        
	        BufferedWriter html = null;
	        
	        try {
	        	FileWriter writer = new FileWriter("Historico_" + nomeHtml + ".html");
	            
	            html = new BufferedWriter(writer);
	            html.write(salvar);
	            
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	        finally {
	        	try {
					html.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        
	    }
	 
	 public static void salvarCurriculoHtml(String nomeHtml, String salvar) {
	        
	        BufferedWriter html = null;
	        
	        try {
	        	FileWriter writer = new FileWriter("Curriculo_" + nomeHtml + ".html");
	            
	            html = new BufferedWriter(writer);
	            html.write(salvar);
	            
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	        finally {
	        	try {
					html.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        
	    }
}
