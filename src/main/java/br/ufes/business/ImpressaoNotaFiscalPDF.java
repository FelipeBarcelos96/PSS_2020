/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.NotaFiscal;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Felps
 */
public class ImpressaoNotaFiscalPDF implements ImpressaoNotaFiscalBusiness {

    @Override
    public void imprimir(NotaFiscal nota) {
        try {
            File arquivo = new File("assets\\Notas\\Nota Fiscal " + Integer.toString(nota.getNumeroNota()) + ".pdf");
            arquivo.createNewFile();
        } catch (IOException e) {
            System.out.println("Não Foi Possível Criar a nota em PDF!!!");
            e.printStackTrace();
        }
        Document document = new Document();
        try {
            FileWriter file = new FileWriter("assets\\Notas\\Nota Fiscal " + Integer.toString(nota.getNumeroNota()) + ".pdf");
        } catch (IOException e) {
            System.out.println("Não Foi Possível Imprimir a nota em PDF!!!");
        }
        try {
            PdfWriter.getInstance(document, new FileOutputStream("assets\\Notas\\Nota Fiscal " + Integer.toString(nota.getNumeroNota()) + ".pdf"));
        } catch (FileNotFoundException ex) {
            System.out.println("Não Foi Possível Imprimir a nota em PDF!!! Arquivo Não encontrado!");
        } catch (DocumentException ex) {
            System.out.println("Não Foi Possível Imprimir a nota em PDF!!! Documento não encontrado!");
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(nota.toString(), font);

        try {
            document.add(chunk);
        } catch (DocumentException ex) {
            System.out.println("Não Foi Possível preencher a nota em PDF!!! Documento não encontrado!");
        }
        document.close();
    }

}
