package sample.jee.bean.test;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import junit.framework.TestCase;
import sample.jee.bean.QuestionnaireManagerRemote;
import sample.jee.bean.jpa.Question;
import sample.jee.bean.util.ServiceResolver;

/**
 * Created by pkumar on 5/10/17.
 */
public class QuestionnaireManagerTest extends TestCase {

    @Test
    public void testFindAllQuestions() {
        try {
            QuestionnaireManagerRemote questionnaireManagerRemote = ServiceResolver.getInstance().lookup(QuestionnaireManagerRemote.JNDI_NAME, QuestionnaireManagerRemote.class);
            List<Question> questions = questionnaireManagerRemote.findAllQuestions();
            assertNotNull(questions);
            for(Question question : questions) {
                System.out.println(question.getQuestion());
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
