package com.yamanin.model.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yamanin.model.dto.ReservationRequest;

public interface ReservationRequestDao {
    int insertReservationRequest(ReservationRequest reservationRequest);
    List<ReservationRequest> selectReservationRequestsByPostId(@Param("postId") Long postId);
    ReservationRequest selectReservationRequestById(@Param("requestId") Long requestId);
    int deleteReservationRequest(@Param("requestId") Long requestId);
}
