package br.com.mykidpet.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.mykidpet.modelo.usuario.Logradouro;
import br.com.mykidpet.modelo.usuario.Paesci;

public class Popular {

	public List<Logradouro> logradouro(String endereco) {
		Logradouro logradouro;
		List<Logradouro> logradouros = new ArrayList<Logradouro>();
		try {
			InputStream is = new FileInputStream(endereco);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();

			while (s != null) {
				logradouro = new Logradouro();
				logradouro.setLogradouro(s);
				logradouros.add(logradouro);
				s = br.readLine();
				System.out.println("PopularLogradouro: " + s);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logradouros;
	}

	public List<Paesci> paesci(String endereco) {
		List<Paesci> paescis = new ArrayList<Paesci>();
		try {
			InputStream is = new FileInputStream(endereco);
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
			Paesci paesci;

			while (s != null) {
				first = 0;
				second = s.indexOf("-", first);
				third = s.indexOf("-", second + 1);
				lenght = s.length();
				pais = s.substring(first, second);
				estado = s.substring(second + 1, third);
				cidade = s.substring(third + 1, lenght);
				paesci = new Paesci();
				paesci.setCidade(cidade);
				paesci.setEstado(estado);
				paesci.setPais(pais);
				System.out.println(
						"first: " + first + " - second: " + second + " - third: " + third + " - lenght: " + lenght);
				System.out.println("cidade: " + paesci.getCidade() + " - estado: " + paesci.getEstado() + " - pais: "
						+ paesci.getPais());
				paescis.add(paesci);
				s = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paescis;
	}

}
