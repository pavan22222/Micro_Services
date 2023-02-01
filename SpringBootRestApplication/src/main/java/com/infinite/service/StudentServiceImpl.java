package com.infinite.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.entity.Student;
import com.infinite.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired(required = true)
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudentByCity(String cityName) {
		return studentRepository.findByCity(cityName);
	}

	@Override
	@Transactional(rollbackOn = {IllegalArgumentException.class})
	public Integer saveStudent(String id, String name, String city, Long pincode) {
		Session session = entityManager.unwrap(Session.class);
		Session session1 = (Session) entityManager.getDelegate();		
		return studentRepository.saveStudent(id, name, city, pincode);
	}
	
	@Override
	public List<Student> getStudensByPagination(Integer startIndex,Integer lastIndex) {
		Query query = entityManager.createNamedQuery("getStudentsByPagination");
		query.setFirstResult(startIndex);
		query.setMaxResults(lastIndex);
		return query.getResultList();
	}
	
	@Override
	public  Integer fetchCountOfStudents() {
		Query query = entityManager.createNativeQuery("select count(*) FROM Student");
		/*List list = query.getResultList();
		System.out.println(list);
		return (Integer) list.get(0);*/
		return (Integer)query.getSingleResult();
	}

}
