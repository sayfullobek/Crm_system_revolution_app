package app_mini_crm.minicrm.service;

import app_mini_crm.minicrm.entity.Color;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    final
    ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public ApiResponse changeColor(String name) {
        colorRepository.deleteAll();
        Color color = new Color(
                1,
                name
        );
        colorRepository.save(color);
        return new ApiResponse("color saved", true, color);
    }
}
