package com.yamanin.model.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yamanin.model.dto.Reservation;

public interface ReservationDao {
    List<Reservation> selectReservationsByGameId(@Param("gameId") Long gameId);
    int insertReservation(Reservation reservation);
    int deleteReservation(@Param("reservationId") Long reservationId);
}
