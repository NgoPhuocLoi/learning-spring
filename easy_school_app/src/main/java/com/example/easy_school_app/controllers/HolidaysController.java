package com.example.easy_school_app.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easy_school_app.models.Holiday;

@Controller
public class HolidaysController {

    @GetMapping("/holidays")
    public String displayHolidaysPage(Model model,
            @RequestParam(required = false, defaultValue = "true") boolean festival,
            @RequestParam(required = false, defaultValue = "true") boolean federal) {
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL));

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
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL));

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
