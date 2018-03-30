package com.yek.hibernateLearn;

import com.yek.hibernateLearn.entity.Employee;
import com.yek.hibernateLearn.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Administrator on 2018-03-29.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();
        try {

            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.
            session.getTransaction().begin();

            // Create an HQL statement, query the object.
            // Equivalent to the SQL statement:
            // Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
            String sql = "Select e from " + Employee.class.getName() + " e "
                    + " order by e.empName, e.empNo ";


            // Create Query object.
            Query<Employee> query = session.createQuery(sql);


            // Execute query.
            List<Employee> employees = query.getResultList();

            for (Employee emp : employees) {
                System.out.println("Emp: " + emp.getEmpNo() + " : "
                        + emp.getEmpName());
            }

            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}
