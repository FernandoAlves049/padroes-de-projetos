package com.fernandoalves.observerstreaming.web;

import com.fernandoalves.observerstreaming.domain.Genre;
import com.fernandoalves.observerstreaming.domain.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashSet;
import java.util.Set;

@Controller
public class StreamingController {

	private final StreamingCatalogService catalogService;

	public StreamingController(StreamingCatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("usersCount", catalogService.getUsersCount());
		model.addAttribute("moviesCount", catalogService.getMoviesCount());
		model.addAttribute("seriesCount", catalogService.getSeriesCount());
		model.addAttribute("notificationsCount", catalogService.getNotificationsCount());
		model.addAttribute("clients", catalogService.getClients());
		model.addAttribute("releases", catalogService.getReleases());
		model.addAttribute("notifications", catalogService.getNotifications());
		model.addAttribute("genres", catalogService.getGenres());
		model.addAttribute("mediaTypes", catalogService.getMediaTypes());
		return "index";
	}

	@PostMapping("/usuarios")
	public String registerClient(@RequestParam String name,
								@RequestParam(required = false, name = "genres") Set<Genre> genres) {
		Set<Genre> selectedGenres = genres == null ? Set.of() : new LinkedHashSet<>(genres);
		catalogService.registerClient(name, selectedGenres);
		return "redirect:/";
	}

	@PostMapping("/conteudos")
	public String publishContent(@RequestParam String title,
								@RequestParam MediaType mediaType,
								@RequestParam Genre genre) {
		catalogService.publishContent(title, mediaType, genre);
		return "redirect:/";
	}

	@GetMapping("/uml")
	public String uml(Model model) {
		model.addAttribute("usersCount", catalogService.getUsersCount());
		model.addAttribute("notificationsCount", catalogService.getNotificationsCount());
		return "uml";
	}

	@GetMapping("/observer")
	public String observer(Model model) {
		model.addAttribute("genres", catalogService.getGenres());
		return "observer";
	}

	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}

}