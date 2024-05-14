package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.Alarm;
import com.yamanin.model.service.AlarmService;

import java.util.List;

@RestController
@RequestMapping("/api-alarms")
public class AlarmController {

    private final AlarmService alarmService;

    @Autowired
    public AlarmController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Alarm>> getAllAlarms() {
        List<Alarm> alarms = alarmService.getAllAlarm();
        return ResponseEntity.ok(alarms);
    }

    @PostMapping("/")
    public ResponseEntity<String> createAlarm(@RequestBody Alarm alarm) {
        int result = alarmService.insert(alarm);
        if (result == 1) {
            return ResponseEntity.ok("Alarm created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to create alarm.");
        }
    }

    @DeleteMapping("/{alarmId}")
    public ResponseEntity<String> deleteAlarm(@PathVariable int alarmId) {
        int result = alarmService.delete(alarmId);
        if (result == 1) {
            return ResponseEntity.ok("Alarm deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete alarm.");
        }
    }
}