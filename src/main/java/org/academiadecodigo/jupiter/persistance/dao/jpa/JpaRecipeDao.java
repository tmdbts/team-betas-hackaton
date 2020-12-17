package org.academiadecodigo.jupiter.persistance.dao.jpa;

import org.academiadecodigo.jupiter.persistance.dao.RecipeDao;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.persistance.model.recipe.RecipeType;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JpaRecipeDao extends GenericJpaDao<Recipe> implements RecipeDao {

    public JpaRecipeDao() {
        super(Recipe.class);
    }

    public List<Recipe> findAllByType(String type){
        TypedQuery<Recipe> query = em.createQuery("SELECT DISTINCT recipe FROM Recipe recipe JOIN recipe.types t WHERE t = :type", Recipe.class);

        query.setParameter("type", type);
        return query.getResultList();
    }
}
