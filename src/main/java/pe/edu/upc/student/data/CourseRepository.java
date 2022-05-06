package pe.edu.upc.student.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.student.beans.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
