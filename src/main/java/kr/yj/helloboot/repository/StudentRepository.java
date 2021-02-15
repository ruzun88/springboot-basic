package kr.yj.helloboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.yj.helloboot.model.Student;
import kr.yj.helloboot.repository.querydsl.StudentRepositoryCustom;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom{
	
}
