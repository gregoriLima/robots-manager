package br.com.gerenciador.model;

import java.util.List;

public class Position {
	  private String endereco;
	  private List<Double> coordinates;
	  private String type = "Point";

	  
	  public Position() { }

	  public Position(String endereco, List<Double> coordinates) {
	    this.endereco = endereco;
	    this.coordinates = coordinates;
	  }
	  
	  
	  
	  public String getEndereco() {
	    return endereco;
	  }
	  public void setEndereco(String endereco) {
	    this.endereco = endereco;
	  }
	  public List<Double> getCoordinates() {
	    return coordinates;
	  }
	  public void setCoordinates(List<Double> coordinates) {
	    this.coordinates = coordinates;
	  }
	  public String getType() {
	    return type;
	  }
	  public void setType(String type) {
	    this.type = type;
	  }

}
