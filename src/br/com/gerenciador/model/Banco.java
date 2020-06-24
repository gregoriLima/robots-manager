package br.com.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Robo> listaRobos = new ArrayList<>();
	
	private static Integer chaveSequencial = 1;
	
	static{
		
		var robo = new Robo();
		robo.setNome("Robô padrão");
		robo.setMarca("ABB");
		robo.setModelo("IRC5");
		robo.setId(chaveSequencial++);
		listaRobos.add(robo);
		
		var robo2 = new Robo();
		robo2.setNome("Robô Motoman");
		robo2.setMarca("M2000");
		robo2.setModelo("Yaskawa");
		robo.setId(chaveSequencial++);
		listaRobos.add(robo2);
		
	}
	
	

	public void adiciona(Robo robo) {
		robo.setId(chaveSequencial++);
		listaRobos.add(robo);
		
	}

	public List<Robo> getListaRobos() {
		return listaRobos;
	}

	public static void removeRobo(Integer id) {

		listaRobos.removeIf(n -> n.id == id); //remove um robô da lista dado o ID
		
	}

	public static Robo buscaRoboPeloId(Integer id) {
		
		return listaRobos.stream().filter(n -> n.id == id).findFirst().get();
	}

}
