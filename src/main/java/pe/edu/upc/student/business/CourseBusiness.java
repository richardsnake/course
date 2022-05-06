package pe.edu.upc.student.business;

import java.util.List;

import pe.edu.upc.student.beans.Course;

public interface CourseBusiness {
	
	public List<Course> getAllCourses();
	
	public void saveCourse(Course course);
	
	public void updateCourse(Course course);
	
	public Long deleteCourse(Course course);
	
	public Course searchById(Long id);

}
