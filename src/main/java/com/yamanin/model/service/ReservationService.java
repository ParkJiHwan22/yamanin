package com.yamanin.model.service;

import java.util.List;
import com.yamanin.model.dto.Reservation;

public interface ReservationService {
    List<Reservation> getReservationsByGameId(Long gameId);
    boolean addReservation(Reservation reservation);
    boolean deleteReservation(Long reservationId);
}
