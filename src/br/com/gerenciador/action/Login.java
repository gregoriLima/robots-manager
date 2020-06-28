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
			//somente setar assim (request.setAttribute("usuarioLogado", usuario.getLogin());) o atributo n�o adianta, 
			//pois como fazemos um redirecionamento abaixo
			//no lado do cliente, uma nova requisi��o � gerada pelo navegador, que trata cada requis��o de forma isolada
			//mas no primeiro acesso, � criado o 'session ID', onde quando o tomcat recebe uma requisi��o ele automaticamente
			//cria um JSESSIONID hexadecimal que devolve para o navegador para saber que est� falando com o mesmo navegador
			//nas pr�ximas requisi��es. Assim, nas pr�ximas requisi��es, o navegador vai enviar este mesmo n�mero junto.
			//O tomcat sempre cria um cookie e um objeto chamado HTTP Session quando recebe uma requisi��o crua, ou seja, sem cookie
			//Este n�mero hexadecimal que comp�e o cookie � enviado novamente nas pr�ximas requisi��es e serve como uma chave de 
			//entrada que permite o acesso a esse objeto. Esta funcionalidade � pronta no tomcat, para termos acesso, basta 
			//importar o Sevlet HttpSession e usar o objeto request para obter-se o HttpSession devolvido pelo navegador.
				//request.setAttribute("usuarioLogado", usuario.getLogin());
				HttpSession sessao = request.getSession(); //Obtendo o HttpSession. Se o usu�rio estiver usando o mesmo navegador
														//o objeto HttpSession sempre ser� o mesmo.
				sessao.setAttribute("usuarioLogado", usuario);
				//A EL ${usuariologado.login} se n�o encontrar na request, procura na session
				return "redirect:entrada?action=ListaRobos";
				
				//O tempo de vida (timeout) de um HttpSession no Tomcat9 � de 30 minutos por padr�o. Caso n�o haja nenhum acesso,
				//em 30 minutos o usu�rio � deslogado. O cookie � transiente, � um session cookie. Pode-se alterar pelo web.xml:
//				<session-config>
//			    <!-- 10 min -->
//			    <session-timeout>10</session-timeout>
//			    </session-config> 
			}
		
	}

}
