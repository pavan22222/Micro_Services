package com.infinite.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ConsumerController {
	
	
	private static class Student {
		private String id;
		private String name;
		private String city;
		private Long pincode;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Long getPincode() {
			return pincode;
		}
		public void setPincode(Long pincode) {
			this.pincode = pincode;
		}
		
		
	}

	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getStudentsByCity")
	public ResponseEntity<List<Student>> getStudentsByCity() throws JsonMappingException, JsonProcessingException{
		String url="http://localhost:8888/Rest-Application/student/getStudentByCity?city=London";
		//String result=restTemplate.getForObject(url, String.class);
		
		//ResponseEntity<List<Student>> responseEntity= restTemplate.getForEntity(url,List.class,new HashMap());
		ResponseEntity<String> responseEntity= restTemplate.exchange(url,HttpMethod.GET,null,String.class,new HashMap());
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
		System.out.println(responseEntity.getStatusCode());
		ObjectMapper mapper = new ObjectMapper();
		
		//List<Student> list = mapper.readValue(responseEntity.getBody(), List.class);
		List<Student> list = mapper.readValue(responseEntity.getBody(), new TypeReference<List<Student>>() {});
		System.out.println(mapper.writeValueAsString(list));
		return new ResponseEntity<List<Student>>(list,HttpStatus.ACCEPTED);
		//return result;
	}
	
	@GetMapping("/deleteByIdAndName")
	public String deleteById(@RequestParam String name,@RequestParam Integer id){
		String url="http://localhost:8888/Rest-Application/student/pathParams/{id}/{name}";
		//restTemplate.delete(url, id,name);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", name);
		map.put("id", id);
		restTemplate.delete(url,map);
		//return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
		return null;
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Integer> saveStudent() throws JsonProcessingException {
		String url="http://localhost:8888/Rest-Application/student/saveStudent";
		Student st= new Student();
		st.setId("ffff-fddff-tttt-dhhff");
		st.setName("Green");
		st.setCity("London");
		st.setPincode(9077877l);
		//String jsonBody="{ \"id\":\"nhSt--xxx-dydyy-sss\",\"name\":\"James\",\"city\":\"London\",\"pincode\": 123454}";
		String jsonBody = new ObjectMapper().writeValueAsString(st);
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		return restTemplate.postForEntity(url, entity, Integer.class);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent() throws JsonMappingException, JsonProcessingException {
		String url="http://localhost:8888/Rest-Application/student/updateStudent";
		String jsonBody="{ \"id\":\"nhSt--xxx-dydyy-sss\",\"name\":\"James\",\"city\":\"London\",\"pincode\": 123454}";
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		ResponseEntity<String> result= restTemplate.exchange(url,HttpMethod.PUT, entity,String.class);
		ObjectMapper objectMapper=new ObjectMapper();
		return new ResponseEntity<Student>(objectMapper.readValue(result.getBody(), Student.class),HttpStatus.OK);
	}

}
