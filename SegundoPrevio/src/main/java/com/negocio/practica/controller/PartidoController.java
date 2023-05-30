package com.negocio.practica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.negocio.practica.entities.Partido;
import com.negocio.practica.repository.PartidoRepository;

@Controller
public class PartidoController {
	
	@Autowired
	PartidoRepository repositorio;

	@GetMapping("/partidos")
	public String verPartidos(Model modelo) {
		List<Partido> partidos = repositorio.findAll();
		modelo.addAttribute("partido", partidos);
		return "partido";
	}

	@GetMapping("/partidos/nuevo")
	public String mostrarFormulario(Model modelo) {
		Partido partido = new Partido();
		modelo.addAttribute("partido", partido);
		return "crear-partido";
	}

	@PostMapping("/partidos")
	public String guardarPartido(@ModelAttribute("partido") Partido partido) {
		repositorio.save(partido);
		return "redirect:/partidos";
	}

	@GetMapping("/partidos/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model modelo) {
		modelo.addAttribute("partido", repositorio.findById(id).get());
		return "editar-partido";
	}

	@PostMapping("/partidos/{id}")
	public String actualizarPartido(@PathVariable("id") Integer id,
			@ModelAttribute("partido") Partido partido) {
		Partido partidoActual = repositorio.findById(id).get();
		partidoActual.setId(id);
		partidoActual.setFecha(partido.getFecha());
		partidoActual.setEstadio(partido.getEstadio());
		partidoActual.setResultados(partido.getResultados());
		repositorio.save(partidoActual);
		return "redirect:/partidos";
	}

	@GetMapping("/partidos/{id}/eliminar")
	public String eliminarPartido(@PathVariable("id") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/partidos";
	}
	
}
