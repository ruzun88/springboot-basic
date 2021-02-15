package kr.yj.helloboot.repository.querydsl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.yj.helloboot.model.QSchool;
import kr.yj.helloboot.model.QStudent;
import kr.yj.helloboot.model.Ticket;
import kr.yj.helloboot.repository.querydsl.StudentRepositoryCustom;

public class StudentRepositoryImpl implements StudentRepositoryCustom {
	@Autowired
	private JPAQueryFactory queryFactory;

	@Override
	public List<Ticket> getAllTickets() {
		QStudent student = QStudent.student;
		QSchool school = QSchool.school;
		
		JPAQuery<Ticket> query = queryFactory
				.select(
						Projections.fields(Ticket.class,
								school.name.as("schoolName"),
								student.name.as("name"),
								student.email)
						)
				.from(student)
				.join(school).on(school.id.eq(student.schoolId))
				.orderBy(school.name.asc())
				.orderBy(student.name.asc());
		
		return query.fetch();
	}
	

}
