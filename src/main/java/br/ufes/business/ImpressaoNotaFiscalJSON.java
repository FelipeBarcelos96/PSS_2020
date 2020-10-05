/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import br.ufes.model.NotaFiscal;
import java.io.File;

/**
 *
 * @author Felps
 */
public class ImpressaoNotaFiscalJSON implements ImpressaoNotaFiscalBusiness{

    @Override
    public void imprimir(NotaFiscal nota) {
        JSONObject jsonObject = new JSONObject();
      //Colocando Nota Fiscal no JSON
      jsonObject.put("Número da Nota", Integer.toString(nota.getNumeroNota()));
      jsonObject.put("Dados da Nota: ", nota.toString());
      try { 
          try {
           File arquivo = new File("assets\\Notas\\Nota Fiscal "+Integer.toString(nota.getNumeroNota())+".json");
              arquivo.createNewFile();
          }catch (IOException e) {
             System.out.println("Não Foi Possível Criar a nota em JSON!!!");
             e.printStackTrace();
          }
          
         FileWriter file = new FileWriter("assets\\Notas\\Nota Fiscal "+Integer.toString(nota.getNumeroNota())+".json");
         file.write(jsonObject.toJSONString());
         file.close();
      } catch (IOException e) {
         System.out.println("Não Foi Possível Imprimir a nota em JSON!!!");
      }
    }
    
}
