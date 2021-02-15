package kr.yj.helloboot.repository.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.yj.helloboot.model.Ticket;

@Repository
public interface StudentRepositoryCustom {
	List<Ticket> getAllTickets();
}
