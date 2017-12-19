package sample.jee.bean.jpa;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Created by pkumar on 5/10/17.
 */

@Entity
@Table(name = "QUESTION", schema = "TESTUSER3")
@NamedQuery(name = "Question.findAll", query = "Select q From Question q")
public class Question implements Serializable {

    @Id
    @Column(name = "QUESTION_ID")
    private Integer questionId;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "QUESTION_EXPLANATION")
    private String questionExplanation;

    @Column(name = "QUESTION_DESCRIPTOR")
    private String questionDescriptor;

    @Column(name = "DATE_TIME_CREATED")
    private Timestamp dateTimeCreated;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "DATE_TIME_MODIFIED")
    private Timestamp dateTimeModified;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public void setQuestionExplanation(String questionExplanation) {
        this.questionExplanation = questionExplanation;
    }

    public String getQuestionDescriptor() {
        return questionDescriptor;
    }

    public void setQuestionDescriptor(String questionDescriptor) {
        this.questionDescriptor = questionDescriptor;
    }

    public Timestamp getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Timestamp dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getDateTimeModified() {
        return dateTimeModified;
    }

    public void setDateTimeModified(Timestamp dateTimeModified) {
        this.dateTimeModified = dateTimeModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
