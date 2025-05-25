package com.example.demo.controller;

import com.example.demo.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private Game game = new Game();

    @PostMapping("/new")
    public Game newGame() {
        game = new Game();
        return game;
    }





}
