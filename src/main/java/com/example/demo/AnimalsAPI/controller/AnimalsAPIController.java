package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("animalsSearch")
	public String getPets(Model model) {
		try {
			List<Animals> animalsList = animalsAPIService.getAnimals();
			model.addAttribute("animalsList", animalsList);

			return "animalsSearch.html";

		} catch (IOException e) {
			e.printStackTrace();

			return "error";
		}
	}

	@GetMapping("animalsDetail")
	public String getPets(@RequestParam(name = "animalsSelect") int animalsSelect, Model model) {
		try {
			List<Animals> animal = animalsAPIService.getAnimal(animalsSelect);
			model.addAttribute("animal", animal);

			return "animalsDetail.html";

		} catch (IOException e) {
			e.printStackTrace();

			return "error";
		}
	}
}
