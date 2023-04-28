package netpolix.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import netpolix.entity.Usuario;
import netpolix.repository.IUsuarioRepository;
import netpolix.services.impl.UsuarioServiceImpl;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioServices;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@GetMapping("/listar")
	public String listarUsuarios(Model model){
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios" , usuarioServices.listar());
		return "usuarios/listaUsuarios";
	}
	
	@GetMapping("/crearUsuario")
	public String crearUsuario(Map<String, Object> model){
		
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Formulario de usuario");
		return "usuarios/formUsuario";
	}
	

	@PostMapping("/save")
	public String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		Usuario usuarioNew = null;
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Usuario");
			return "usuarios/formUsuario";
		}
		
		String mensajeFlash =(usuario.getIdUsuario() != null) ? "Usuario editado con éxito!" : "Usuario creado con éxito!";

		usuarioNew = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioNew == null) {
			if (usuarioRepository.save(usuario) == null) {
				model.addAttribute("titulo", "Formulario de Usuario");
				model.addAttribute("error", "No se pudo crear el usuario intenta nuevamente");
				return "usuarios/formUsuario";
			}else {
				status.setComplete();
				flash.addFlashAttribute("success", "el usuario fue creado con exito!!");
			}
		}else {
			model.addAttribute("titulo", "Formulario de Usuario");
			model.addAttribute("error", "El usuario con email: " + usuario.getEmail() + " ya existe intente con otro");
			return "usuarios/formUsuario";
		}
		return "redirect:/usuarios/listar";
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
