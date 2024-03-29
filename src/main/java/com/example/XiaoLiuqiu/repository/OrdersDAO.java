package com.example.XiaoLiuqiu.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.vo.RoomVo;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer>{

	
	
	public List<Orders> findByMemberNameContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual
	(String memberName ,LocalDate startDate, LocalDate endDate);
	
	public Optional<Orders> findByOrderId(int orderId);
	
	public List<Orders> findByMemberNameContaining(String memberName);
	
	@Query(value="select * from orders where member_name like %:member_name% " ,nativeQuery = true)
	public List<Orders> findByLikeMember(@Param("member_name")String memberName);
	
	@Query(value="select * from orders where room_id like ?1"
			+ " AND start_date >= ?2"
			+ " AND end_date <= ?3",nativeQuery = true)
	public List<Orders> findByLike(@Param("roomId")List<Room> roomId, 
			@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);
	
	@Query(value="select * from orders where member_name like %:Membername%",nativeQuery = true)
	public Optional<Orders> findByName(@Param("Membername")String Membername);
	
	@Query("select new com.example.XiaoLiuqiu.vo.RoomVo(O.roomId, O.startDate, O.endDate, "
			+ " R.roomName) "
			+ " from Orders as O "
			+ " join Room as R on O.roomId = R.roomId "
			+ " where O.startDate >= :startDate "
			+ " AND O.endDate <= :endDate "
			+ " AND R.roomName LIKE %:roomName% ")
	public List<RoomVo> joinTwoTables(@Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("roomName") String roomName);

}
