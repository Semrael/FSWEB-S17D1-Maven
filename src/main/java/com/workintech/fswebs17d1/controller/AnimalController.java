package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    HashMap<Integer, Animal> animals=new HashMap<Integer, Animal>();
    @GetMapping()
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Animal findOne(@PathVariable Integer id)  {
        return animals.get(id);
    }

    @PostMapping()
    public Animal create(@RequestBody Animal animal ){
        animals.put(animal.getId(),animal);
        return animal;
    }
    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id,@RequestBody Animal animal){
        animals.put(id,animal);
        return animal;
    }
    @DeleteMapping("/{id}")
    public Animal remove(@PathVariable Integer id){
        Animal animal=animals.get(id);
        animals.remove(animal);
        return animal;
    }
}
