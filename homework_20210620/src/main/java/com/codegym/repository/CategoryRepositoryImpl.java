package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category  c", Category.class);
        return query.getResultList();
    }

    @Override
    public Category findById(Long id) {
        TypedQuery<Category> query = entityManager.createQuery("select c from Category c where  c.id=:id", Category.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Category category) {
        if (category.getId() != null) {
            entityManager.merge(category);
        } else {
            entityManager.persist(category);
        }
    }

    @Override
    public void remove(Long id) {
        Category category = findById(id);
        if (category != null) {
            entityManager.remove(category);
        }
    }
}
