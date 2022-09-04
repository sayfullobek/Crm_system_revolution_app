package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.Color;
import app_mini_crm.minicrm.repository.ColorRepository;
import app_mini_crm.minicrm.service.ColorService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    final
    ColorService colorService;

    final ColorRepository colorRepository;

    public ColorController(ColorService colorService, ColorRepository colorRepository) {
        this.colorService = colorService;
        this.colorRepository = colorRepository;
    }

    @PostMapping
    public HttpEntity<?> addColor(@RequestBody String color) {
        return ResponseEntity.ok(colorService.changeColor(color));
    }
}
