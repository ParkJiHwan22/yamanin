package com.yamanin.model.service;

import java.util.List;
import com.yamanin.model.dto.ReservationRequest;

public interface ReservationRequestService {
    boolean addReservationRequest(ReservationRequest reservationRequest);
    List<ReservationRequest> getReservationRequestsByPostId(Long postId);
    ReservationRequest getReservationRequestById(Long requestId);
    boolean deleteReservationRequest(Long requestId);
}
