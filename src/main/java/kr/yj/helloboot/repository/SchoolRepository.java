package kr.yj.helloboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.yj.helloboot.model.School;
import kr.yj.helloboot.repository.querydsl.SchoolRepositoryCustom;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>, SchoolRepositoryCustom{
	
}
