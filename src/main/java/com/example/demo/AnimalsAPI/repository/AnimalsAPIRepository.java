package com.example.demo.AnimalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AnimalsAPI.data.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalsAPIRepository {

	public Animals[] getAnimals() throws IOException {
		try {

			String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

			RestTemplate rest = new RestTemplate();
			ResponseEntity<String> response = rest.getForEntity(url, String.class);
			String json = response.getBody();
			ObjectMapper mapper = new ObjectMapper();
			Animals[] animalsList = mapper.readValue(json, Animals[].class);

			return animalsList;

		} catch (IOException e) {
			throw new IOException("取得に失敗しました", e);
		}
	}

	public Animals[] getAnimal(int index) throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi?id=" + index;
		try {
			RestTemplate rest = new RestTemplate();
			ResponseEntity<String> response = rest.getForEntity(url, String.class);
			String json = response.getBody();
			ObjectMapper mapper = new ObjectMapper();
			Animals[] animal = mapper.readValue(json, Animals[].class);

			return animal;

		} catch (IOException e) {
			throw new IOException("取得に失敗しました", e);
		}
	}

}