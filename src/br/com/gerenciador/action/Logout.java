package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession();
//		sessao.removeAttribute("usuarioLogado");//não adianta apenas remover o atributo, pois outros existem na sessão
		sessao.invalidate();//remove o HttpSession e todos os objetos associados a ele
							//removendo todos os atributos e destroi o cookie
//		assim, na resposta ao navegador, outro JSESSIONID é criado e enviado

		return "redirect:entrada?action=LoginForm";
	}

}
