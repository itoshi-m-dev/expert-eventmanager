package com.emanuel.eventmanager.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.emanuel.eventmanager.entities.Event;
import com.emanuel.eventmanager.entities.Participant;
import com.emanuel.eventmanager.repositories.EventRepository;
import com.emanuel.eventmanager.repositories.ParticipantRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	public EventRepository eventRepo;

	@Autowired
	public ParticipantRepository participantRepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		eventRepo.deleteAll();
		participantRepo.deleteAll();
		
		Participant p1 = new Participant(null, "Carlos", "Silva", "carlos.silva@gmail.com", "(11) 98877-1122", null);
	    Participant p2 = new Participant(null, "Mariana", "Oliveira", "mariana.oliveira@gmail.com", "(21) 97766-3344", null);
	    Participant p3 = new Participant(null, "João", "Pereira", "joao.pereira@gmail.com", "(31) 96655-7788", null);
	    Participant p4 = new Participant(null, "Fernanda", "Souza", "fernanda.souza@gmail.com", "(41) 95544-9900", null);
	    Participant p5 = new Participant(null, "Rafael", "Costa", "rafael.costa@gmail.com", "(51) 94433-2211", null);
	    Participant p6 = new Participant(null, "Beatriz", "Almeida", "beatriz.almeida@gmail.com", "(61) 93322-5566", null);
	    Participant p7 = new Participant(null, "Lucas", "Mendes", "lucas.mendes@gmail.com", "(71) 92211-7788", null);
	    Participant p8 = new Participant(null, "Patrícia", "Lima", "patricia.lima@gmail.com", "(81) 91100-8899", null);
	    
	    participantRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
	    
	    System.out.println(">>> Participantes inseridos com sucesso!");

		Event ev1 = new Event(null, "Joao e Maria", "Caçar Doce", "Centro SP", sdf.parse("31-10-2025"),sdf.parse("04-11-2025"), 5, null);
		Event ev2 = new Event(null, "Festa das Flores", "Exposição de Primavera", "Parque Ibirapuera",sdf.parse("10-09-2025"), sdf.parse("15-09-2025"), 200, null);
		Event ev3 = new Event(null, "Conferência TechSP", "Evento de tecnologia e inovação", "Av. Paulista, 1000",sdf.parse("20-11-2025"), sdf.parse("22-11-2025"), 300, null);
		
		
		eventRepo.saveAll(Arrays.asList(ev1,ev2,ev3));
		
		System.out.println(">>> Instantiation executada! Eventos salvos: " + eventRepo.count());
		
		

	    
	    
	    

		
		
	}

}
