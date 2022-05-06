package pe.edu.upc.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.student.beans.Course;
import pe.edu.upc.student.data.CourseRepository;


@Service
public class CourseBusinessImpl implements CourseBusiness{

	
	@Autowired
	private CourseRepository repository; 
	
	@Override
	public List<Course> getAllCourses() {
		
		return repository.findAll();
	}

	@Override
	public void saveCourse(Course course) {
		repository.save(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		if(repository.existsById(course.getId()))
			repository.save(course);
		
	}

	@Override
	public Long deleteCourse(Course course) {
		repository.deleteById(course.getId());
		return course.getId();
	}

	@Override
	public Course searchById(Long id) {
		return repository.getById(id);
	}

}
