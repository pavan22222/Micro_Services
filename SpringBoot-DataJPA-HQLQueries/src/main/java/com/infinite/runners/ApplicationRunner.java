package com.infinite.runners;

import java.sql.CallableStatement;
import java.util.Date;
import java.util.List;

import javax.lang.model.util.Types;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.Student;
import com.infinite.repository.StudentRepository;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//getAllStudents();
		//getAllStudentsByStudentNameLike("Adams");
		//getSpecificColsOfStudentsByStudentNameLike("Crist");
		//getSingleColOfStudentsByStudentNameLike("Crist");
		//getCountOfStudents();
		//getAggregateValues();
		//insertStudent();
		//updateStudent();
		deleteStudent();
		//getCurrentDate();
		Session session=(Session) entityManager.getDelegate();
		System.out.println(session);
	}
	
	private void getAllStudents() {
		List<Student> list=repository.fectchAllStudents();
		list.forEach(System.out::println);
	}
	
	private void getAllStudentsByStudentNameLike(String studentName) {
		List<Student> list=repository.fectchAllStudentsByStudentNameLike(studentName);
		list.forEach(System.out::println);
	}
	
	private void getSpecificColsOfStudentsByStudentNameLike(String studentName) {
		List<Object[]> list=repository.fectchSpecificColsOfStudentsByStudentNameLike(studentName);
		list.forEach(obj->{
			System.out.println(obj[0]+" "+obj[1]);
		});
	}
	
	private void getSingleColOfStudentsByStudentNameLike(String studentName) {
		List<Integer> list=repository.fectchSingleColOfStudentsByStudentNameLike(studentName);
		list.forEach(obj->{
			System.out.println(obj);
		});
	} 
	
	private void getCountOfStudents() {
		System.out.println(repository.fetchCountOfStudents());
	}
	
	private void getAggregateValues() {
		for(Object object:(Object[])repository.fecthAggregateValues()) {
			System.out.println(object);
		}
	}
	
	private void insertStudent() {
		Integer result = repository.insertStudent(28,19, new Date(), "James", true);
		System.out.println(result);
	}
	
	private void updateStudent() {
		Integer result=repository.updateStudent("Rhonson",  17, new Date(),14);
		System.out.println(result);
	}
	
	private void deleteStudent() {
		Integer result=repository.deleteStudent(14,17);
		System.out.println(result);
	}
	
	private void getCurrentDate() {
		System.out.println(repository.fetchCurrentDate());
	}
	
	/**
	 * 
	 * CREATE OR REPLACE PROCEDURE GET_EMPLOYYES_BY_STUDENT_ID(
	 * STUDENT_ID IN NUMBER,DETAILS OUT SYS_REFCURSOR)
	 * AS
	 * BEGIN
	 * 
	 * OPEN DETAILS FOR
	 * 	SELECT * FROM STUDENT WHERE STUDENT_ID=STUDENR_ID;
	 * 
	 * END;
	 */
	
	private void callProcedure() {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("GET_EMPLOYYES_BY_STUDENT_ID",Student.class);
		procedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter(2, Student.class, ParameterMode.OUT);
		procedureQuery.setParameter(1, 15);
		List<Student> students=procedureQuery.getResultList();
	}
	
	
	/**
	 * 
	 * CREATE OR REPLACE FUNCTION AUTHENTICATE(
	 * USERNAME IN VARCHAR,PASSWORD IN VARCHAR2) RETURN VARCHAR2
	 * AS
	 * CNT NUMBER(5)
	 * RESULT VARCHAR2(20)
	 * BEGIN
	 * 
	 * 	SELECT COUNT(*) INTO CNT FROM AUTHENTICATION WHERE USERNAME=USERNAME AND PASSWORD=PASSWORD;
	 * 
	 * IF(CNT <>0)
	 *  THEN 
	 *    RESULT:='VALID CREDENTIALS';
	 * ELSE
	 *    RESULT:='INVALID CREDENTIALS';
	 *    
	 * END IF;
	 * RETURN RESULT;      
	 * 
	 * END AUTHENTICATION;
	 */
	
	private void callFunction() {
		Session session=entityManager.unwrap(Session.class);
		session.doReturningWork(con->{
			try {
				CallableStatement callableStatement = con.prepareCall("{?=call AUTHENTICATION(?,?)}");
				callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
				callableStatement.setString(2, "Jhonson");
				callableStatement.setString(3, "Jhonson");
				callableStatement.execute();
				String result = callableStatement.getString(1);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		});
	}
	

}
