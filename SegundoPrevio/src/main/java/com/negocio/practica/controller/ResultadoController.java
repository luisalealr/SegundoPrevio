package com.negocio.practica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.negocio.practica.entities.Resultado;
import com.negocio.practica.repository.ResultadoRepository;

@Controller
public class ResultadoController {
	
	@Autowired
	ResultadoRepository repositorio;
	
	@GetMapping("/resultados")
	public String verResultados(Model modelo) {
		List<Resultado> resultados = repositorio.findAll();
		modelo.addAttribute("resultados", resultados);
		return "resultados";
	}

	@GetMapping("/resultados/nuevo")
	public String mostrarFormulario(Model modelo) {
		Resultado resultado = new Resultado();
		modelo.addAttribute("resultado", resultado);
		return "crear-resultado";
	}

	@PostMapping("/resultados")
	public String guardarResultado(@ModelAttribute("resultado") Resultado resultado) {
		repositorio.save(resultado);
		return "redirect:/resultados";
	}

	@GetMapping("/resultados/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model modelo) {
		modelo.addAttribute("resultado", repositorio.findById(id).get());
		return "editar-resultado";
	}

	@PostMapping("/resultados/{id}")
	public String actualizarResultado(@PathVariable("id") Integer id,
			@ModelAttribute("resultado") Resultado resultado) {
		Resultado resultadoActual = repositorio.findById(id).get();
		resultadoActual.setId(id);
		resultadoActual.setAmarillas(resultado.getAmarillas());
		resultadoActual.setGoles(resultado.getGoles());
		resultadoActual.setRojas(resultado.getRojas());
		resultadoActual.setPartido(resultado.getPartido());
		resultadoActual.setSeleccion(resultado.getSeleccion());
		repositorio.save(resultadoActual);
		return "redirect:/resultados";
	}

	@GetMapping("/resultados/{id}/eliminar")
	public String eliminarResultado(@PathVariable("id") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/resultados";
	}
}
