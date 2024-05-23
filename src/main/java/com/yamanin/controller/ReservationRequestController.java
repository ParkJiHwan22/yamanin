package com.yamanin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yamanin.model.dto.ReservationRequest;
import com.yamanin.model.service.ReservationRequestService;
import com.yamanin.model.dto.Reservation;
import com.yamanin.model.service.ReservationService;

@RestController
@RequestMapping("/reservation_requests")
public class ReservationRequestController {
    private final ReservationRequestService reservationRequestService;
    private final ReservationService reservationService;

    @Autowired
    public ReservationRequestController(ReservationRequestService reservationRequestService, ReservationService reservationService) {
        this.reservationRequestService = reservationRequestService;
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    public ResponseEntity<String> addReservationRequest(@RequestBody ReservationRequest reservationRequest) {
        boolean isSuccess = reservationRequestService.addReservationRequest(reservationRequest);
        if (isSuccess) {
            return new ResponseEntity<>("Reservation request added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add reservation request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<ReservationRequest>> getReservationRequestsByPostId(@PathVariable("postId") Long postId) {
        List<ReservationRequest> requests = reservationRequestService.getReservationRequestsByPostId(postId);
        return ResponseEntity.ok(requests);
    }

    @PostMapping("/accept/{requestId}")
    public ResponseEntity<String> acceptReservationRequest(@PathVariable("requestId") Long requestId, @RequestParam("gameId") Long gameId) {
        ReservationRequest request = reservationRequestService.getReservationRequestById(requestId);
        if (request != null) {
            Reservation reservation = new Reservation();
            reservation.setUserId(request.getUserId());
            reservation.setGameId(gameId); // gameId 설정
            reservation.setUserName(request.getUserName());
            reservation.setIsAuthor(false);
            boolean isAdded = reservationService.addReservation(reservation);
            if (isAdded) {
                reservationRequestService.deleteReservationRequest(requestId);
                return new ResponseEntity<>("Reservation request accepted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to add reservation", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Reservation request not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reject/{requestId}")
    public ResponseEntity<String> rejectReservationRequest(@PathVariable("requestId") Long requestId) {
        boolean isSuccess = reservationRequestService.deleteReservationRequest(requestId);
        if (isSuccess) {
            return new ResponseEntity<>("Reservation request rejected", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to reject reservation request", HttpStatus.BAD_REQUEST);
        }
    }
}
