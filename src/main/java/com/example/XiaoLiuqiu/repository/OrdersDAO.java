package com.example.XiaoLiuqiu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.entity.RoomMessageBoard;
import com.example.XiaoLiuqiu.vo.RoomVo;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByMemberNameContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual
	(String memberName ,LocalDate startDate, LocalDate endDate);
	
	
	@Query(value="select * from orders where room_id like ?1"
			+ " AND start_date >= ?2"
			+ " AND end_date <= ?3",nativeQuery = true)
	public List<Orders> findByLike(@Param("roomId")List<Room> roomId, 
			@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);
	
	
//	@Query("select new com.example.XiaoLiuqiu.vo.RoomVo(, O.startDate, O.endDate, "
//			+ " R.roomName) "
//			+ " form Orders as O "
//			+ " join Room as R on O.num = W.quizNum ")
//	public List<RoomVo> joinTwoTables();

}
