package br.ufba.mata62.SistemaAcademico.repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveTxtRepository {
public static void salvarHistoricoTxt(String nomeAluno, String salvar) {
        
        BufferedWriter txt = null;
        
        try {
        	FileWriter writer = new FileWriter("Historico_" + nomeAluno + ".txt");
            
            txt = new BufferedWriter(writer);
            txt.write(salvar);
            
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        	try {
				txt.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
    }

public static void salvarCurriculoTxt(String nomeAluno, String salvar) {
    
    BufferedWriter txt = null;
    
    try {
    	FileWriter writer = new FileWriter("Curriculo_" + nomeAluno + ".txt");
        
        txt = new BufferedWriter(writer);
        txt.write(salvar);
        
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
    finally {
    	try {
			txt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
}
