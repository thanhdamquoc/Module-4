package com.codegym.repository;

import com.codegym.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT c FROM Blog c ORDER BY c.date DESC", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT c FROM Blog c WHERE c.id = :id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean save(Blog blog) {
        try {
            if (blog.getId() == null) {
                entityManager.persist(blog);
            } else {
                entityManager.merge(blog);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Long id) {
        Blog blog = findById(id);
        try {
            entityManager.remove(blog);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
