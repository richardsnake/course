package pe.edu.upc.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.student.beans.Course;
import pe.edu.upc.student.business.CourseBusiness;

@RestController
@RequestMapping(value = "/api/v1")
public class CourseController {
	
	
	@Autowired
	private CourseBusiness business;
	
	//listar
	@GetMapping(value = "/courses")
	public ResponseEntity<Object> getAllCourses(){
		return new ResponseEntity<>(business.getAllCourses(), HttpStatus.OK);
	}
	
	
	//buscar por id
	@GetMapping(value = "/courses/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id){
		return new ResponseEntity<>(business.searchById(id),  HttpStatus.OK);
	} 
	
	
	//guardar
	@PostMapping(value = "/courses")
	public ResponseEntity<Object> saveCourse(@RequestBody Course course){
		business.saveCourse(course);
		return new ResponseEntity<>("Curse guardado", HttpStatus.OK);
	}
	
	//modificar
	@PatchMapping(value = "/courses")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course){
		business.updateCourse(course);
		return new ResponseEntity<>("Curse actualizado", HttpStatus.OK);
	}
	//eliminar
	@DeleteMapping(value = "/courses")
	public ResponseEntity<Object> deleteCourse(Course course){
		Long id = business.deleteCourse(course);
		return new ResponseEntity<>("Curso con "+id+" eliminado", HttpStatus.OK);
	}
	
	
}
