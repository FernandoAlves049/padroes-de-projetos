package com.fernandoalves.observerstreaming.web;

import com.fernandoalves.observerstreaming.domain.Genre;
import com.fernandoalves.observerstreaming.domain.MediaRelease;
import com.fernandoalves.observerstreaming.domain.MediaType;
import com.fernandoalves.observerstreaming.observer.Client;
import com.fernandoalves.observerstreaming.observer.StreamingPlatform;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class StreamingCatalogService {

	private final StreamingPlatform streamingPlatform;
	private final List<Client> clients = new ArrayList<>();
	private final List<MediaRelease> releases = new ArrayList<>();
	private final List<String> notifications = new ArrayList<>();

	public StreamingCatalogService(StreamingPlatform streamingPlatform) {
		this.streamingPlatform = streamingPlatform;
	}

	@PostConstruct
	public void seedDemoData() {
		registerClient("João", EnumSet.of(Genre.ACTION, Genre.ANIME));
		registerClient("Maria", EnumSet.of(Genre.HORROR));
		registerClient("Pedro", EnumSet.of(Genre.COMEDY, Genre.ACTION));
		registerClient("Ana", EnumSet.of(Genre.SCIENCE_FICTION));
		registerClient("Carlos", EnumSet.of(Genre.ANIME));

		publishContent("Velozes e Furiosos 11", MediaType.MOVIE, Genre.ACTION);
		publishContent("One Piece Film Red", MediaType.MOVIE, Genre.ANIME);
		publishContent("Invocação do Mal", MediaType.MOVIE, Genre.HORROR);
	}

	public void registerClient(String name, Set<Genre> genres) {
		Client client = new Client(name, genres == null ? Set.of() : new LinkedHashSet<>(genres));
		clients.add(client);
		streamingPlatform.registerObserver(client);
	}

	public void publishContent(String title, MediaType type, Genre genre) {
		MediaRelease release = new MediaRelease(title, type, EnumSet.of(genre));
		releases.add(release);
		notifications.addAll(streamingPlatform.publishAndCollectNotifications(release));
	}

	public List<Client> getClients() {
		return List.copyOf(clients);
	}

	public List<MediaRelease> getReleases() {
		return List.copyOf(releases);
	}

	public List<String> getNotifications() {
		return List.copyOf(notifications);
	}

	public List<Genre> getGenres() {
		return List.of(Genre.values());
	}

	public List<MediaType> getMediaTypes() {
		return List.of(MediaType.values());
	}

	public long getUsersCount() {
		return clients.size();
	}

	public long getMoviesCount() {
		return releases.stream().filter(release -> release.type() == MediaType.MOVIE).count();
	}

	public long getSeriesCount() {
		return releases.stream().filter(release -> release.type() == MediaType.SERIES).count();
	}

	public long getNotificationsCount() {
		return notifications.size();
	}

}