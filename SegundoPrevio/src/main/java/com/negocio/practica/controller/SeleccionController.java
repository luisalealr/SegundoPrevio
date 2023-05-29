package com.negocio.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.negocio.practica.entities.Seleccion;
import com.negocio.practica.repository.SeleccionRepository;

public class SeleccionController {

	@Autowired
	SeleccionRepository repositorio;
	
	@GetMapping("/selecciones")
	public String verSelecciones(Model modelo) {
		List<Seleccion> selecciones = repositorio.findAll();
		modelo.addAttribute("selecciones", selecciones);
		return "seleccion";
	}
	
	@GetMapping("/selecciones/nuevo")
	public String mostrarFormulario(Model modelo){
		Seleccion seleccion = new Seleccion();
		modelo.addAttribute("seleccion", seleccion);
		return "crear-seleccion";
	}
	
	@PostMapping("/selecciones")
	public String guardarSeleccion(@ModelAttribute("seleccion") Seleccion seleccion) {
		repositorio.save(seleccion);
		return "redirect:/selecciones";
	}
	
	@GetMapping("/selecciones/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model modelo) {
		modelo.addAttribute("seleccion", repositorio.findById(id).get());
		return "editar-seleccion";
	}
	
	@PostMapping("/selecciones/{id}")
	public String actualizarNoticia(@PathVariable("id") Integer id, @ModelAttribute("seleccion") Seleccion seleccion) {
		Seleccion seleccionActual = repositorio.findById(id).get();
		seleccionActual.setId(id);
		seleccionActual.setGrupo(seleccion.getGrupo());
		seleccionActual.setNombre(seleccion.getNombre());
		seleccionActual.setResultados(seleccion.getResultados());
		seleccionActual.setContinente(seleccion.getContinente());
		repositorio.save(seleccionActual);
		return "redirect:/selecciones";
	}
	
	@GetMapping("/selecciones/{id}/eliminar")
	public String eliminarNoticia(@PathVariable("id") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/seleccion";
	}

	@GetMapping("/selecciones/{id}/resultados")
	public String mostrarResultadosSeleccion(@PathVariable("id") Integer id) {
		
		return "seleccion-resultados";
	}
}
