package com.example.easy_school_app.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easy_school_app.models.Holiday;
import com.example.easy_school_app.repositories.HolidayRepo;

@Controller
public class HolidaysController {
    @Autowired
    HolidayRepo holidayRepo;

    @GetMapping("/holidays")
    public String displayHolidaysPage(Model model,
            @RequestParam(required = false, defaultValue = "true") boolean festival,
            @RequestParam(required = false, defaultValue = "true") boolean federal) {
        List<Holiday> holidays = this.holidayRepo.getAllHolidays();
        model.addAttribute("hasFestival", festival);
        model.addAttribute("hasFederal", federal);
        for (var type : Holiday.Type.values()) {
            model.addAttribute(type.toString(),
                    holidays.stream().filter(h -> h.getType().equals(type)).collect(Collectors.toList()));
        }
        return "holidays.html";
    }

    @GetMapping("/holidays/{display}")
    public String displayHolidaysWithPathParams(Model model, @PathVariable String display) {
        model.addAttribute("display", display);
        List<Holiday> holidays = this.holidayRepo.getAllHolidays();
        if (display != null) {
            model.addAttribute("hasFestival", (display.equals("all") || display.equals("festival")));
            model.addAttribute("hasFederal", (display.equals("all") || display.equals("federal")));
        }
        for (var type : Holiday.Type.values()) {
            model.addAttribute(type.toString(),
                    holidays.stream().filter(h -> h.getType().equals(type)).collect(Collectors.toList()));
        }
        return "holidays.html";
    }
}
