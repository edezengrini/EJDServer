package server.dao;

import javax.persistence.TypedQuery;

import server.entities.Usuario;

public class LoginDAO extends AbstractDAO<Usuario> {

    public Usuario find(String login, String senha) {
        StringBuilder sb = new StringBuilder();
        sb.append("select u from Usuario u ");
        sb.append("where ");
        sb.append("u.login = :login ");
        sb.append("and u.senha = :senha ");

        TypedQuery<Usuario> query = criarQuery(sb.toString());
        query.setParameter("login", login);
        query.setParameter("senha", senha);

        return getSingleResult(query);

    }

}
