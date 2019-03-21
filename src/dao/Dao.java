package dao;

import beans.ChemstryC8;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import javafx.scene.control.DatePicker;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {
    

    private static SessionFactory factory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();

    public void addChemData() {
        //EntityManagerFactory emFactory= new Persistence.
        Session session = factory.openSession();
        //session.
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ChemstryC8 chem = new ChemstryC8("The masses of 1 mole of a substance expressed in grams is called",
                    "blank",
                    "A",
                    "", "", "", "", "",
                    "",
                    1.0,
                    "1st Quarter",
                    "class 8",
                    "Chmestry",
                    null,
                    1,
                    null,
                    null,
                    "2009,2010",
                    2
            );

            ChemstryC8 chem1 = new ChemstryC8("Define the following:",
                    "short question",
                    "B",
                    "Thermo chemistry", "Exothermic reactions", "Endothermic Reactions", "Neutralization", "",
                    "",
                    5.0,
                    "1st Quarter",
                    "class 8",
                    "Chmestry",
                    null,
                    2,
                    null,
                    null,
                    "2009",
                    1
            );

            ChemstryC8 chem2 = new ChemstryC8("Calculate the Molar Masses of:",
                    "long question",
                    "C",
                    "Na2CO3", "NH3", "", "", "",
                    "(At. Mass  N = 14, H = 1 , Na  =23 , C = 12 , O = 16)",
                    5.0,
                    "1st Quarter",
                    "class 8",
                    "Chmestry",
                    null,
                    1,
                    null,
                    null,
                    "2011",
                    1
            );

            session.save(chem);
            session.save(chem1);
            session.save(chem2);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public List<ChemstryC8> getChemDat(String grade, String section, String term, String type) {

        Session session = factory.openSession();
        Transaction tx = null;
        List<ChemstryC8> b = null;
        try {
            tx = session.beginTransaction();

            String hql = "SELECT  c FROM ChemstryC8 c WHERE c.grade= :grades AND c.section= :sectios";
            TypedQuery<ChemstryC8> query = session.createQuery(hql, ChemstryC8.class);
            query.setParameter("grades", grade);
            query.setParameter("sectios", section);
            b = query.getResultList();

//            for (Iterator<ChemstryC8> it = b.iterator(); it.hasNext();) {
//                ChemstryC8 i = it.next();
//                System.out.printf("%d  %s \n",i.getId(),i.getQuestion());
//              //  System.out.println(i.getQuestion());
//            }
            //List s= session.createQuery("SELECT  c.id , c.question FROM ChemstryC8 c WHERE c.grade= :grades AND c.section = :sections").setParameter("grades", grade).setParameter("sections", section).getResultList();
            // Collections.checkList(lQuery.getResultList(), Person.class);
            //  System.out.println(b.get(0).getId());
//            query.setParameter("term", term);
//            query.setParameter("type", type);
            // Iterator<ChemstryC8> results = (Iterator<ChemstryC8>)query.getResultList().iterator();
            // System.out.println(results.next().getChoice1());
//             results.stream().map((c) -> {
//                 System.out.println(c.getId());
//                return c;
//            }).forEachOrdered((c) -> {
//                System.out.println(c.getQuestion());
//            });//            List<ChemstryC8> result= session.createQuery("From ChemstryC8").getResultList();
//            for (Iterator it = result.iterator(); it.hasNext();) {
//                ChemstryC8 x = (ChemstryC8) it.next();
//                System.out.println(x.toString());
//            }
// int result = query.executeUpdate();
            // System.out.println("Rows affected: " + result);
            //System.out.println(query.list());
//            foreach (ChemstryC8 c : results)
//            {
//            }
            //     System.out.println(results.get(0).getId());
            //  System.out.println(results.get(0).getQuestion());
            //
            //   Iterator iterator = results.iterator();
            // ChemstryC8 employee = (ChemstryC8) iterator.next();
            //System.out.println(iterator.next());
//             for(Iterator iterator = results.iterator(); iterator.hasNext();){
//          // ChemstryC8 employee = (ChemstryC8)iterator.next();
//          iterator.next();
//            System.out.println("First Name: " +iterator.hasNext() );
//            System.out.println("  Last Name: " +employee.getQuestion());
            //   }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return b;

    }

    public String addRecord(String grade, String subject, String quarter, String section, String type, Double marks, int priority, String question, String description, String choice1, String choice2, String choice3, String choice4, String choice5) {

        Session session = factory.openSession();
        Transaction tx = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        
        
        
       // Date datee = new Date();
       /// Calender c = new Calender();
        //; DatePicker datePicker = new DatePicker();
        // LocalDate eintryDate = datePicker.getValue();
         
        //Date entryDate = dateFormat.format(date) ;
        Date entryDate= new Date();
        Date firstUsedDate = new Date();
        Date lastUsedDate = new Date();
        String yearsUsed = "";
        int occurence = 0;

        try {
            tx = session.beginTransaction();
            ChemstryC8 chemstryC8 = new ChemstryC8(question, type, section, choice1, choice2, choice3, choice4, choice5, description, marks, quarter, grade, subject, entryDate, priority, firstUsedDate, lastUsedDate, yearsUsed, occurence);

            session.save(chemstryC8);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return "success i guess";
    }

    /* Method to  READ all the employees */
 /*   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM EmployeeA").list(); 
         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            EmployeeA employee = (EmployeeA) iterator.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      } finally {
         session.close(); 
      }
   }*/
 /* Method to UPDATE salary for an employee */
 /*  public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
		 session.update(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }*/
 /* Method to DELETE an employee from the records */
 /* public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }*/
}
