package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Usuario;
import br.com.gerenciador.model.dao.UsuarioDao;

public class Login implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUsuario = request.getParameter("login");
		String senhaUsuario = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDao().existeUsuario(nomeUsuario, senhaUsuario); //Banco.existeUsuario(nomeUsuario, senhaUsuario);
		
//		System.out.println(usuario.getLogin());
		
		if(usuario == null) 
			return "redirect:entrada?action=LoginForm";
		else {
			//somente setar assim (request.setAttribute("usuarioLogado", usuario.getLogin());) o atributo não adianta, 
			//pois como fazemos um redirecionamento abaixo
			//no lado do cliente, uma nova requisição é gerada pelo navegador, que trata cada requisção de forma isolada
			//mas no primeiro acesso, é criado o 'session ID', onde quando o tomcat recebe uma requisição ele automaticamente
			//cria um JSESSIONID hexadecimal que devolve para o navegador para saber que está falando com o mesmo navegador
			//nas próximas requisições. Assim, nas próximas requisições, o navegador vai enviar este mesmo número junto.
			//O tomcat sempre cria um cookie e um objeto chamado HTTP Session quando recebe uma requisição crua, ou seja, sem cookie
			//Este número hexadecimal que compõe o cookie é enviado novamente nas próximas requisições e serve como uma chave de 
			//entrada que permite o acesso a esse objeto. Esta funcionalidade é pronta no tomcat, para termos acesso, basta 
			//importar o Sevlet HttpSession e usar o objeto request para obter-se o HttpSession devolvido pelo navegador.
				//request.setAttribute("usuarioLogado", usuario.getLogin());
				HttpSession sessao = request.getSession(); //Obtendo o HttpSession. Se o usuário estiver usando o mesmo navegador
														//o objeto HttpSession sempre será o mesmo.
				sessao.setAttribute("usuarioLogado", usuario);
				//A EL ${usuariologado.login} se não encontrar na request, procura na session
				return "redirect:entrada?action=ListaRobos";
				
				//O tempo de vida (timeout) de um HttpSession no Tomcat9 é de 30 minutos por padrão. Caso não haja nenhum acesso,
				//em 30 minutos o usuário é deslogado. O cookie é transiente, é um session cookie. Pode-se alterar pelo web.xml:
//				<session-config>
//			    <!-- 10 min -->
//			    <session-timeout>10</session-timeout>
//			    </session-config> 
			}
		
	}

}
