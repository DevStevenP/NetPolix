package netpolix.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import netpolix.entity.Video;
import netpolix.services.ICategoriaService;
import netpolix.services.impl.VideoServiceImpl;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private VideoServiceImpl videoServiceImpl;
	
	@Autowired
	private ICategoriaService categoriaServices;
	
	@GetMapping("/listar")
	public String listarVideos(Model model) {
		model.addAttribute("titulo", "Lista de videos");
		model.addAttribute("videos",videoServiceImpl.listar());
		return "videos/listaVideos";
	}
	
	@GetMapping("/crearVideo")
	public String crearVideo(Map<String, Object> model) {
		Video video = new Video();
		model.put("video", video);
		model.put("titulo", "Formulario para agregar Video");
		return "videos/formVideo";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid Video video, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario De Video");
			return "videos/formVideo";
		}
		
		String mensajeFlash = (video.getIsan() != null) ? "Video editado con éxito!" : "Video creado con éxito!";
		

		videoServiceImpl.save(video);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/video/listar";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", categoriaServices.busarTodas());
	}

}
