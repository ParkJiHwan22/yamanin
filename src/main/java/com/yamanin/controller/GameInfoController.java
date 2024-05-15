package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yamanin.model.dto.GameInfo;
import com.yamanin.model.service.GameInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/gameinfos")
public class GameInfoController {

    private final GameInfoService gameInfoService;

    @Autowired
    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }

    // Get all games
    @GetMapping("/")
    public ResponseEntity<List<GameInfo>> getAllGameInfo() {
        List<GameInfo> gameInfos = gameInfoService.getAllGameInfo();
        return ResponseEntity.ok(gameInfos);
    }

    // Get a single game by ID
    @GetMapping("/{gameId}")
    public ResponseEntity<GameInfo> getGameInfoByGameId(@PathVariable int gameId) {
        GameInfo gameInfo = gameInfoService.getGameInfoByGameId(gameId);
        return gameInfo != null ? ResponseEntity.ok(gameInfo) : ResponseEntity.notFound().build();
    }

    // Create a new game
    @PostMapping("/")
    public ResponseEntity<String> insertGameInfo(@RequestBody GameInfo gameInfo) {
        int result = gameInfoService.insert(gameInfo);
        return result == 1 ? ResponseEntity.ok("Game added successfully") : ResponseEntity.badRequest().body("Error adding game");
    }

    // Delete a game
    @DeleteMapping("/{gameId}")
    public ResponseEntity<String> deleteGameInfo(@PathVariable int gameId) {
        int result = gameInfoService.delete(gameId);
        return result == 1 ? ResponseEntity.ok("Game deleted successfully") : ResponseEntity.badRequest().body("Error deleting game");
    }
}
