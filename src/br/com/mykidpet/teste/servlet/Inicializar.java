package br.com.mykidpet.teste.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.mykidpet.modelo.tag.MagnetMaterial;
import br.com.mykidpet.modelo.tag.ModeloDeTag;
import br.com.mykidpet.modelo.tag.TagColor;
import br.com.mykidpet.modelo.tag.TagFormat;
import br.com.mykidpet.modelo.tag.TagMaterial;
import br.com.mykidpet.modelo.usuario.Logradouro;
import br.com.mykidpet.modelo.usuario.Paesci;

public class Inicializar {

	public void logradouro(EntityManager manager) {
		try {
			InputStream is = new FileInputStream(
					"C:/Users/User/Desktop/workspace/petDivisionReal/src/br/com/mykidpet/modelo/dono/logradouros");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();

			Logradouro logradouro;

			while (s != null) {
				logradouro = new Logradouro();
				logradouro.setLogradouro(s);
				manager.persist(logradouro);
				s = br.readLine();
				System.out.println("while - nova linha: " + s);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paesci(EntityManager manager) {
		try {
			InputStream is = new FileInputStream(
					"C:/Users/User/Desktop/workspace/petDivisionReal/src/br/com/mykidpet/modelo/dono/paesci");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			Integer first;
			Integer second;
			Integer third;
			Integer lenght;
			String pais;
			String estado;
			String cidade;
			Paesci ciespa;

			while (s != null) {
				first = 0;
				second = s.indexOf("-", first);
				third = s.indexOf("-", second + 1);
				lenght = s.length();
				pais = s.substring(first, second);
				estado = s.substring(second + 1, third);
				cidade = s.substring(third + 1, lenght);
				ciespa = new Paesci();
				ciespa.setCidade(cidade);
				ciespa.setEstado(estado);
				ciespa.setPais(pais);
				System.out.println(
						"first: " + first + " - second: " + second + " - third: " + third + " - lenght: " + lenght);
				System.out.println("cidade: " + ciespa.getCidade() + " - estado: " + ciespa.getEstado() + " - pais: "
						+ ciespa.getPais());
				manager.persist(ciespa);
				s = br.readLine();

				System.out.println("while - nova linha: " + s);

			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modeloDeTag(EntityManager manager){
//		BigDecimal alturaTag;
//		BigDecimal espessuraTag;
//		BigDecimal comprimentoTag;
//		BigDecimal diametroTag;
//		BigDecimal alturaIma;
//		BigDecimal comprimentoIma;
//		BigDecimal espessuraIma;
		ModeloDeTag modeloDeTag;
		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, new BigDecimal(2+2), new BigDecimal(1+1), new BigDecimal(2+2), new BigDecimal(0), TagMaterial.NYLON, new BigDecimal(2+2), new BigDecimal(2), new BigDecimal(2), MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, new BigDecimal(2+2), new BigDecimal(1+1), new BigDecimal(2+2), new BigDecimal(0), TagMaterial.PLA, new BigDecimal(2+2), new BigDecimal(2), new BigDecimal(2), MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		
		/*for(double f = 0.5; f<4.5;f=f+0.5){espessuraIma = new BigDecimal(f); espessuraTag = new BigDecimal(f+1);
		for(int g = 2; g<22;g=g+2){comprimentoIma = new BigDecimal(g); comprimentoTag = new BigDecimal(g+2);
		for(int h = 2; h<22;h=h+2){alturaIma = new BigDecimal(h); alturaTag = new BigDecimal(h+2);
		for(int d=0; d<5;d=d+2){diametroTag = new BigDecimal(d+(g+h)); if(d!=0){alturaTag = new BigDecimal(0);comprimentoTag = new BigDecimal(0);}
		

		// INTERVALO MAGNET MATERIAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.ARTIFICIAL);
		manager.persist(modeloDeTag);		

		

		
		
		
		
		// INTERVALO MAGNET MATERIAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NATURAL);
		manager.persist(modeloDeTag);		

		

		
		
		
		
		// INTERVALO MAGNET MATERIAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.NEOMIDIO);
		manager.persist(modeloDeTag);		

		

		
		
		
		
		// INTERVALO MAGNET MATERIAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANENTE_ALNICO);
		manager.persist(modeloDeTag);		

		

		
		
		
		
		// INTERVALO MAGNET MATERIAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.NYLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PLA, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.PVC, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		

		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.CIRCULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.QUADRADO, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		
		
		modeloDeTag = new ModeloDeTag(TagColor.AMARELO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.AZUL, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.BRANCO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.PRETO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROSA, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.ROXO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERDE, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);
		modeloDeTag = new ModeloDeTag(TagColor.VERMELHO, TagFormat.RETANGULAR, alturaTag, espessuraTag, comprimentoTag, diametroTag, TagMaterial.TEFLON, alturaIma, comprimentoIma, espessuraIma, MagnetMaterial.PERMANTENTE_FERRITE);
		manager.persist(modeloDeTag);		

		
		}
		}
		}
		
		*/
	//}


}}
