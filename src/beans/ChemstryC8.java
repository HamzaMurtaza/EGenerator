package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Entity;
import javax.persistence.Entity;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@SuppressWarnings("PersistenceUnitPresent")
public class ChemstryC8 implements Serializable {

    private static final long serialVersionUID = 1L;

   // public ChemstryC8(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    private String question; //notnull
    private String type; //notnull
    private String section; //notnull setion change karna hay lazmi yad se!!!!
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;
    private String description;//dd
    private Double marks;
    private String term; //notnull
    private String grade; //notnull
    private String subject; //notnull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entryDate; //notnull  dd
    private int priority; //notnull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date firstUsedDate; //notnull dd
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUsedDate; //notnull dd
    private String yearsUsed;//notnull dd
    private int occurence;//notnull dd

    public ChemstryC8(int id,String questio){
    this.id=id;
    this.question=questio;
    }
    public ChemstryC8(String question, String type, String section,String choice1, String choice2, String choice3, String choice4, String choice5, String description,Double marks, String term, String grade, String subject, Date entryDate, int priority, Date firstUsedDate, Date lastUsedDate, String yearsUsed, int occurence) {
        this.question = question;
        this.type = type;
        this.section = section;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice5 = choice5;
        this.description = description;
        this.marks = marks;
        this.term = term;
        this.grade = grade;
        this.subject = subject;
        this.entryDate = entryDate;
        this.priority = priority;
        this.firstUsedDate = firstUsedDate;
        this.lastUsedDate = lastUsedDate;
        this.yearsUsed = yearsUsed;
        this.occurence = occurence;
    }
    
    
}
