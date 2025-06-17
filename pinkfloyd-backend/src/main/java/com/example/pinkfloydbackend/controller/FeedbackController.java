package com.example.pinkfloydbackend.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@CrossOrigin(origins = "*")
public class FeedbackController {

    @PostMapping("/submit")
    public String submitFeedback(@RequestBody FeedbackRequest request) {
        if (request == null || request.getName() == null || request.getName().trim().isEmpty() ||
                request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            return "Ошибка: Имя и сообщение обязательны.";
        }
        System.out.println("Получен отзыв: Имя = " + request.getName() + ", Сообщение = " + request.getMessage());
        return "Спасибо за ваш отзыв, " + request.getName() + "!";
    }
}

class FeedbackRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("message")
    private String message;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}