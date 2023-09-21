package com.repaso.sandoval_repaso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.repaso.sandoval_repaso.entity.Paciente;
import com.repaso.sandoval_repaso.service.CategoriaService;
import com.repaso.sandoval_repaso.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private CategoriaService cat;
	@Autowired
	private PacienteService pac;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("categorias", cat.ListarTodo());
		model.addAttribute("pacientes", pac.ListarTodo());
		
		return "paciente";
	}
	
	//@RequestParam, permite recuperar valores que se encuentran en los
	//controles del formulario(cajas,checkbox,radio,etc)
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("sex") String sex,
						 @RequestParam("cat") Integer cat) {
		try {
			Paciente p=new Paciente();
			p.setNombre(nom);
			p.setApellido(ape);
			p.setSexo(sex);
			p.setCategoria(this.cat.BuscarPorId(cat));
			
			pac.Registrar(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:/paciente/lista";
	}
	
}
