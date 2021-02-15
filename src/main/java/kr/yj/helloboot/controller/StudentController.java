package kr.yj.helloboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.yj.helloboot.model.Student;
import kr.yj.helloboot.model.Ticket;
import kr.yj.helloboot.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;
	
	/*
	 * Create
	 */
	@RequestMapping(method = RequestMethod.GET, value="/student/add")
	public Student addNewStudent() {
		Student s = new Student();
		s.setName("yj");
		s.setEmail("ruzun88@github.xxx");
		s.setTmp("tmp");
		s.setSchoolId(new Long(1));
		return studentRepo.save(s);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/student/add")
	public Student addNewStudent(@RequestBody Student student) {
		if(student == null)
			return null;
		if(student.getId() != null) {
			student.setId(null);
		}
		return studentRepo.save(student);
	}
	
	/*
	 * Read
	 */
	@RequestMapping(method = RequestMethod.GET, value="/student/showAll")
	public List<Student> findAllStudent() {
		return studentRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/student/find/{id}")
	public Optional<Student> findStudentById(@PathVariable Long id) {
		return studentRepo.findById(id);
	}
	
	/*
	 * Update
	 */
	@RequestMapping(method = RequestMethod.POST, value="/student/update")
	public Student updateStudent(@RequestBody Student student) {
		if(student == null)
			return null;
		return studentRepo.save(student);
	}
	
	/*
	 * Delete
	 */
	@RequestMapping(method = RequestMethod.POST, value="/student/delete/{id}")
	public List<Student> deleteStudentById(@PathVariable Long id) {
		studentRepo.deleteById(id);
		return studentRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/ticket/all")
	public List<Ticket> findAllTickets() {
		return studentRepo.getAllTickets();
	}
}