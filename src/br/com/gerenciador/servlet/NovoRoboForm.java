package br.com.gerenciador.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoRoboForm {

	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:formNovoRobo.jsp";
	}

}
