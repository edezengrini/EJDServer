package server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import server.entities.interfaces.IEntity;
import server.persistence.Persistence;
import arquitetura.common.exception.EJDException;
import arquitetura.common.util.ReflectionUtil;
import arquitetura.server.persistence.resource.EntityManagerProvider;
import arquitetura.server.persistence.resource.EntityManagerProviderFactory;

public abstract class AbstractDAO<E extends IEntity> {

    private Class<E> classeEntidade;
    private EntityManager em = Persistence.getInstance().createEntityManager();

    private EntityManagerProvider entityManagerProvider;

    public AbstractDAO() {
        this.classeEntidade = (Class<E>) ReflectionUtil.getTypeArguments(AbstractDAO.class, getClass()).get(0);
    }

    public Class<E> getClasseEntidade() {
        return classeEntidade;
    }

    public E criar() throws Exception {
        return classeEntidade.newInstance();
    }

    public E localizar(Long id) {
        return em.find(classeEntidade, id);
    }

    public List<E> localizarTodos() {
        return localizarTodos(false);
    }

    public List<E> localizarTodos(boolean limparCache) {
        if (limparCache) {
            em.clear();
        }
        CriteriaQuery<E> criteriaQuery = em.getCriteriaBuilder().createQuery(classeEntidade);

        Root<E> root = criteriaQuery.from(classeEntidade);
        criteriaQuery = criteriaQuery.select(root);
        TypedQuery<E> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public List<E> localizarTodosOrderBy() {

        CriteriaQuery<E> criteriaQuery = em.getCriteriaBuilder().createQuery(classeEntidade);

        Root<E> root = criteriaQuery.from(classeEntidade);
        criteriaQuery = criteriaQuery.select(root);
        criteriaQuery = criteriaQuery.orderBy(em.getCriteriaBuilder().asc(root));
        TypedQuery<E> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public E editar(E entity) throws EJDException {

        try {

            em.getTransaction().begin();

            entity = em.merge(entity);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;
        }
        return entity;
    }

    public E inserir(E entity) throws EJDException {
        try {
            em.getTransaction().begin();

            em.persist(entity);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;
        }
        return entity;
    }

    public void sincronizar(E entity) {
        em.refresh(entity);
    }

    public void excluir(E entity) throws EJDException {
        try {
            em.getTransaction().begin();

            em.remove(entity);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;
        }

    }

    public TypedQuery<E> criarQuery(String sql) {
        return em.createQuery(sql, classeEntidade);
    }

    public List<E> criarQuery(String sql, Object... params) {
        TypedQuery<E> query = em.createQuery(sql, classeEntidade);

        int i = 1;

        if (params != null) {
            for (Object param : params) {
                query.setParameter(i++, param);
            }
        }

        return query.getResultList();
    }

    protected <C> C getSingleResult(TypedQuery<C> typedQuery) {
        return getSingleResult(typedQuery, false);
    }

    protected <C> C getSingleResult(TypedQuery<C> typedQuery, boolean throwNoResultException) throws NoResultException {
        C t = null;
        try {

            t = typedQuery.getSingleResult();

        } catch (NoResultException e) {
            if (throwNoResultException) {
                throw e;
            }

        }

        return t;
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            em = getEntityManagerProvider().getEntityManager();
        }
        return em;
    }

    public EntityManagerProvider getEntityManagerProvider() {
        if (entityManagerProvider == null) {
            entityManagerProvider = EntityManagerProviderFactory.getEntityManagerProvider();
        }
        return entityManagerProvider;
    }


}
