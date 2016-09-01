package server.dao;

import javax.persistence.TypedQuery;

import server.entities.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario> {
    public Usuario find(Long idUsuario) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select u from usuario u ");
        sb.append(" where ");
        sb.append("   u.idUsuario = :idUsuario ");

        TypedQuery<Usuario> query = criarQuery(sb.toString());

        query.setParameter("idUsuario", idUsuario);

        return getSingleResult(query);
    }

}
