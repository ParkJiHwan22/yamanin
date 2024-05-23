package com.yamanin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yamanin.model.dto.Reservation;
import com.yamanin.model.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<Reservation>> getReservationsByGameId(@PathVariable("gameId") Long gameId) {
        List<Reservation> reservations = reservationService.getReservationsByGameId(gameId);
//        System.out.println(reservations);
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/")
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation) {
        boolean isSuccess = reservationService.addReservation(reservation);
        if (isSuccess) {
            return new ResponseEntity<>("Reservation added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add reservation", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable("reservationId") Long reservationId) {
        boolean isSuccess = reservationService.deleteReservation(reservationId);
        if (isSuccess) {
            return new ResponseEntity<>("Reservation deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete reservation", HttpStatus.BAD_REQUEST);
        }
    }
}
