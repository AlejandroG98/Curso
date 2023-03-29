package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ActorRepository dao;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Aplicación arrancada");
//		(new EjemplosIoC()).run();
//		dao.save(actor);
//		dao.deleteById(215);
//		var item = dao.findById(215);
//		if(item.isPresent()) {
//			var actor = item.get();
//			actor.setLastName(actor.getLastName().toUpperCase());
//			dao.save(actor);
//			dao.findAll().forEach(System.out::println);
//		} else {
//			System.out.println("Actor no encontrado");
//		}
//		dao.findTop5ByFirstNameStartingWithOrderByLastNameDesc("P")
//			.forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("LastName").descending())
//			.forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("FirstName"))
//		.forEach(System.out::println);
//		dao.findConJPQL().forEach(System.out::println);
//		dao.findConJPQL(5).forEach(System.out::println);
//		dao.findConSQL(5).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 5))
//			.forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.greaterThan(root.get("actorId"), 200))
//			.forEach(System.out::println);
//		var item = dao.findById(1);
// 		if(item.isPresent()) {
// 			var actor = item.get();
// 			System.out.println(actor);
// 			actor.getFilmActors().forEach(o ->
// 			System.out.println(o.getFilm().getTitle()));
// 		} else {
// 			System.out.println("Actor no encontrado");
// 		}
/*		var actor = new Actor(0, "Pepito", "Grillo");
		
		/*Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		var err = validator.validate(actor);
		if (err.size() > 0) {
			err.forEach(e->System.out.println(e.getPropertyPath()+": "+e.getMessage()));
		}else {
			dao.save(actor);
		}
		
		if(actor.isInvalid())
		{
			System.out.println(actor.getErrorsMessage());
		} else {
			dao.save(actor);
		}*/
		//var rslt = dao.findAll(PageRequest.of(1, 20, Sort.by("actorId")));
		//rslt.getContent().stream().map(item -> ActorDTO.from(item)).forEach(System.out::println);
		dao.findByActorIdNotNull().forEach(item->System.out.println(item.getActorId()+" "+item.getNombre()));
	}
}
