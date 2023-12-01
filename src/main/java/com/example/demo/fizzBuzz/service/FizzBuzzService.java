package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

 public List<String> fizzBuzz(int start, int end) {
     List<String> results = new ArrayList<>();

     for (int i = start; i <= end; i++) {
         if (i % 3 == 0 && i % 5 == 0) {
             results.add("FizzBuzz");
         } else if (i % 3 == 0) {
             results.add("Fizz");
         } else if (i % 5 == 0) {
             results.add("Buzz");
         } else {
             results.add(Integer.toString(i));
         }
     }

     return results;
 }
}
