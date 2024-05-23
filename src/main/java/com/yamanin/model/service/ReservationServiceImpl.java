package com.yamanin.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yamanin.model.dao.ReservationDao;
import com.yamanin.model.dto.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;

    @Autowired
    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public List<Reservation> getReservationsByGameId(Long gameId) {
        return reservationDao.selectReservationsByGameId(gameId);
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        return reservationDao.insertReservation(reservation) == 1;
    }

    @Override
    public boolean deleteReservation(Long reservationId) {
        return reservationDao.deleteReservation(reservationId) == 1;
    }
}
