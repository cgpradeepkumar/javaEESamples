package sample.jee.bean;

import java.util.List;

import javax.ejb.Remote;

import sample.jee.bean.jpa.Question;

/**
 * Created by pkumar on 5/10/17.
 */

@Remote
public interface QuestionnaireManagerRemote {

    public static String JNDI_NAME = "sample/QuestionnaireManagerBean";

    public List<Question> findAllQuestions();

    public Question find();
}
