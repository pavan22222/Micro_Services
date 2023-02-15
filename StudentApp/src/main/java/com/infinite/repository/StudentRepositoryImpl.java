package com.infinite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.infinite.beans.Student;

public class StudentRepositoryImpl implements StudentRepository {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public StudentRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int[] saveEmployee(List<Student> students) {
		int[] returnArray = null;
		SqlParameterSource[] array = students.stream().map(st -> new BeanPropertySqlParameterSource(st))
				.collect(Collectors.toList()).toArray(new SqlParameterSource[0]);
		returnArray = jdbcTemplate.batchUpdate("Insert into Student values(:studentId,:studentName,:city,:pincode)", array);
		return returnArray;
	}
	
	@Override
	public List<Student> getAllStudentsByIds(List<String> ids) {
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("id", ids.get(0));
		return jdbcTemplate.query("select * from Student where student_id=:id", inParams,
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	@Override
	public Student getAllStudentsById(String id) {
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("id", id);
		return jdbcTemplate.queryForObject("select * from Student where student_id=:id", inParams,
				new BeanPropertyRowMapper<Student>(Student.class));
	}

}
