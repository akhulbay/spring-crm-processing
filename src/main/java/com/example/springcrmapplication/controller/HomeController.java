package com.example.springcrmapplication.controller;

import com.example.springcrmapplication.dto.ApplicationRequestCreateEditDto;
import com.example.springcrmapplication.dto.ApplicationRequestReadDto;
import com.example.springcrmapplication.service.ApplicationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ApplicationRequestService appRequestService;

    @GetMapping("/")
    public String findAll(Model model) {
        List<ApplicationRequestReadDto> requests = appRequestService.findAll();
        model.addAttribute("requests", requests);
        return "index";
    }

    @GetMapping("/processed")
    public String findAllProcessed(Model model) {
        List<ApplicationRequestReadDto> requests = appRequestService.findAllProcessed();
        model.addAttribute("requests", requests);
        return "processed-requests";
    }

    @GetMapping("/unprocessed")
    public String findAllUnprocessed(Model model) {
        List<ApplicationRequestReadDto> requests = appRequestService.findAllUnprocessed();
        model.addAttribute("requests", requests);
        return "unprocessed-requests";
    }

    @GetMapping("/details/{id}")
    public String findById(Model model,
                           @PathVariable Long id) {
        ApplicationRequestReadDto request = appRequestService.findById(id);
        model.addAttribute("requestBody", request);
        return "details";
    }

    @GetMapping("/create-request")
    public String createPage() {
        return "add-request";
    }

    @PostMapping("/create-request")
    public String create(ApplicationRequestCreateEditDto request) {
        appRequestService.create(request);
        return "redirect:/";
    }

    @PostMapping("/process-request")
    public String process(@RequestParam(name = "id") Long id,
                          ApplicationRequestCreateEditDto request) {
        appRequestService.process(id, request);
        return "redirect:/details/" + id;
    }

    @PostMapping("/delete-request")
    public String delete(@RequestParam(name = "id") Long id) {
        appRequestService.delete(id);
        return "redirect:/";
    }
}
