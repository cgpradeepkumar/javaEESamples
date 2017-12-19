package sample.jee.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sample.jee.bean.jpa.Question;

/**
 * Created by pkumar on 5/10/17.
 */

@Stateless(name = "QuestionnaireManagerBean", mappedName = "sample/QuestionnaireManagerBean")
public class QuestionnaireManagerBean implements QuestionnaireManagerRemote {

    @PersistenceContext(unitName = "sample.pu")
    private EntityManager entityManager;

    @Override
    public List<Question> findAllQuestions() {

        if (entityManager == null) {
            System.out.println("EntityManager cannot be null");
        } else {
            System.out.println("EntityManager is not null");
        }
        Query query = entityManager.createNamedQuery("Question.findAll");
        List<Question> questions = query.getResultList();
        return questions;
    }

    public Question find() {
        if (entityManager == null) {
            System.out.println("EntityManager cannot be null");
        } else {
            System.out.println("EntityManager is not null");
        }

        Question question = entityManager.find(Question.class, 1);

        return question;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
