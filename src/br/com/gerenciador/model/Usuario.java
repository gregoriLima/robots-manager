package br.com.gerenciador.model;

public class Usuario {

	private long _id;
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean ehIgual(String login, String senha) {
        if(!this.login.equals(login)) {
            return false;
        }

        if(!this.senha.equals(senha)) {
            return false;
        }

        return true;
    }

	public long getId() {
		return _id;
	}

	public void setId(long _id) {
		this._id = _id;
	}
}