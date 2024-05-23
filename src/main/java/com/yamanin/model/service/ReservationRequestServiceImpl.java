package com.yamanin.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yamanin.model.dao.ReservationRequestDao;
import com.yamanin.model.dto.ReservationRequest;

@Service
public class ReservationRequestServiceImpl implements ReservationRequestService {

    private final ReservationRequestDao reservationRequestDao;

    @Autowired
    public ReservationRequestServiceImpl(ReservationRequestDao reservationRequestDao) {
        this.reservationRequestDao = reservationRequestDao;
    }

    @Override
    public boolean addReservationRequest(ReservationRequest reservationRequest) {
        return reservationRequestDao.insertReservationRequest(reservationRequest) == 1;
    }

    @Override
    public List<ReservationRequest> getReservationRequestsByPostId(Long postId) {
        return reservationRequestDao.selectReservationRequestsByPostId(postId);
    }

    @Override
    public ReservationRequest getReservationRequestById(Long requestId) {
        return reservationRequestDao.selectReservationRequestById(requestId);
    }

    @Override
    public boolean deleteReservationRequest(Long requestId) {
        return reservationRequestDao.deleteReservationRequest(requestId) == 1;
    }
}
