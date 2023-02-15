package com.infinite.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.infinite.entity.Student;
import com.infinite.service.StudentService;

@RestController
@RequestMapping("/student")
@ConfigurationProperties(prefix = "spring.datasource")
//@CrossOrigin(origins = "http://localhost:4400")
public class StudentController {	
	
	String driverClassName;
	String url;
	String username;
	String password;
	String json;
	
	public String getDriverClassName() {
		new Date().compareTo(null);
		Integer[] array=new Integer[] {12,12};
		new String().chars().mapToObj(Character[]::new);
		int[] a=Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
		Arrays.stream(a).boxed().toArray(Integer[]::new);
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(path ="/getStudentByCity",method = RequestMethod.GET)
	public List<Student> fetchStudentByCity(@RequestParam(required = true,defaultValue = "London") String city,@RequestHeader Map<String, String> headers) {
		System.out.println(headers);	 
		return studentService.getStudentByCity(city);
	}
	
	@RequestMapping(path ="/saveStudent",method = RequestMethod.POST,produces = "application/json",consumes = "*/*")
	public ResponseEntity<String> saveStudent(@RequestBody(required = true) Student student) {
		System.out.println(driverClassName+url+username+password+json);
		return new ResponseEntity<String>(studentService.saveStudent(student),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/requestParams")
	public String requestParams(@RequestParam(required = true,defaultValue = "Pavan") String name,@RequestParam Integer id) {
		return name+id;
	}
	
	@DeleteMapping(path = "/pathParams/{id}/{name}")
	public String pathParams(@PathVariable String name,@PathVariable Integer id) {
		return name+id;
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return student;
	}
	
	
	@RequestMapping("/getStudentsByPagination")
	public List<Student> getStudentsByPagination(@RequestParam(defaultValue = "0") Integer startIndex,
			@RequestParam(defaultValue = "10") Integer lastIndex, @RequestHeader Map<String,Object> map){
		System.out.println(map);
		List<Student> list = studentService.getStudensByPagination(startIndex, lastIndex);
		return list;
	}
	
	@RequestMapping(path="/getCount",method = RequestMethod.GET)
	public Integer getCount(){
		return studentService.fetchCountOfStudents();
	}
	
	@RequestMapping(path ="/getStudentById",method = RequestMethod.GET)
	public Student fetchStudentByCity(@RequestParam(required = true) String studentId) {	 
		return studentService.getStudentById(studentId);
	}
	
	

}
