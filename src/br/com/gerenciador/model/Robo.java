package br.com.gerenciador.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Robo {

	
	
	private long _id;
	private String nome;
	private String marca;
	private String modelo;
	private LocalDate data = LocalDate.now();
	private Position position;
	
	public long getId() {
		return _id;
	}
	public void setId(long id) {
		this._id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getData() {
		String s = data.format(DateTimeFormatter.ofPattern("dd/MM/u")).toString();
		System.out.println(s);
		return s;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
