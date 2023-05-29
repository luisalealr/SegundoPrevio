package com.negocio.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.negocio.practica.entities.Continente;
import com.negocio.practica.repository.ContinenteRepository;

@Controller
public class ContinenteController {

	@Autowired
	ContinenteRepository repositorio;

	@GetMapping("/continentes")
	public String verContinentes(Model modelo) {
		List<Continente> continente = repositorio.findAll();
		modelo.addAttribute("continentes", continente);
		return "continente";
	}

	@GetMapping("/continentes/nuevo")
	public String mostrarFormulario(Model modelo) {
		Continente continente = new Continente();
		modelo.addAttribute("continente", continente);
		return "crear-continente";
	}

	@PostMapping("/continentes")
	public String guardarContinente(@ModelAttribute("continente") Continente continente) {
		repositorio.save(continente);
		return "redirect:/continentes";
	}

	@GetMapping("/continentes/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model modelo) {
		modelo.addAttribute("continente", repositorio.findById(id).get());
		return "editar-continente";
	}

	@PostMapping("/continentes/{id}")
	public String actualizarNoticia(@PathVariable("id") Integer id,
			@ModelAttribute("continente") Continente continente) {
		Continente continenteActual = repositorio.findById(id).get();
		continenteActual.setId(id);
		continenteActual.setNombre(continente.getNombre());
		repositorio.save(continenteActual);
		return "redirect:/continentes";
	}

	@GetMapping("/continentes/{id}/eliminar")
	public String eliminarNoticia(@PathVariable("id") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/continentes";
	}
}
