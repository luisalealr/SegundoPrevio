package com.negocio.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.negocio.practica.entities.Estadio;
import com.negocio.practica.entities.Partido;
import com.negocio.practica.repository.EstadioRepository;
import com.negocio.practica.repository.PartidoRepository;

@Controller
public class EstadioController {

	@Autowired
	EstadioRepository repositorio;
	
	@Autowired
	PartidoRepository repositorioPartido;
	
	@GetMapping("/estadios")
	public String verPartidos(Model modelo) {
		List<Estadio> estadio = repositorio.findAll();
		modelo.addAttribute("estadio", estadio);
		return "estadio";
	}

	@GetMapping("/estadios/nuevo")
	public String mostrarFormulario(Model modelo) {
		List<Partido> partidos = repositorioPartido.findAll();
		Estadio estadio = new Estadio();
		modelo.addAttribute("estadio", estadio);
		modelo.addAttribute("partido", partidos);
		return "crear-estadio";
	}

	@PostMapping("/estadios")
	public String guardarPartido(@ModelAttribute("estadio") Estadio estadio) {
		repositorio.save(estadio);
		return "redirect:/estadios";
	}

	@GetMapping("/estadios/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model modelo) {
		List<Partido> partidos = repositorioPartido.findAll();
		modelo.addAttribute("estadio", repositorio.findById(id).get());
		modelo.addAttribute("partido", partidos);
		return "editar-estadio";
	}

	@PostMapping("/estadios/{id}")
	public String actualizarPartido(@PathVariable("id") Integer id,
			@ModelAttribute("estadio") Estadio estadio) {
		Estadio estadioActual = repositorio.findById(id).get();
		estadioActual.setId(id);
		estadioActual.setCapacidad(estadio.getCapacidad());
		estadioActual.setNombre(estadio.getNombre());
		estadioActual.setPartidos(estadio.getPartidos());
		repositorio.save(estadioActual);
		return "redirect:/estadios";
	}

	@GetMapping("/estadios/{id}/eliminar")
	public String eliminarPartido(@PathVariable("id") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/estadios";
	}
	
}
