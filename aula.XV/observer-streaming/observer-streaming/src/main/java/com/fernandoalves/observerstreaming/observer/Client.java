package com.fernandoalves.observerstreaming.observer;

import com.fernandoalves.observerstreaming.domain.Genre;
import com.fernandoalves.observerstreaming.domain.MediaRelease;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Client implements Observer {

	private final String name;
	private final Set<Genre> subscribedGenres;
	private final List<String> notifications;

	public Client(String name, Set<Genre> subscribedGenres) {
		this.name = name;
		this.subscribedGenres = subscribedGenres == null || subscribedGenres.isEmpty()
				? Collections.emptySet()
				: Collections.unmodifiableSet(EnumSet.copyOf(subscribedGenres));
		this.notifications = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public Set<Genre> getSubscribedGenres() {
		return subscribedGenres;
	}

	public List<String> getNotifications() {
		return Collections.unmodifiableList(notifications);
	}

	public boolean isInterestedIn(MediaRelease release) {
		return release.genres().stream().anyMatch(subscribedGenres::contains);
	}

	public String createNotificationMessage(MediaRelease release) {
		String time = LocalTime.now().withSecond(0).withNano(0).toString();
		return String.format(
				"[%s] %s recebeu notificação: Novo %s de %s: %s",
				time,
				name,
				release.type().getLabel().toLowerCase(),
				release.genres().stream().findFirst().map(Genre::getLabel).orElse("conteúdo"),
				release.title()
		);
	}

	@Override
	public void update(MediaRelease release) {
		String message = createNotificationMessage(release);
		notifications.add(message);
		System.out.println(message);
	}

	public String formatSubscriptions() {
		if (subscribedGenres.isEmpty()) {
			return "sem assinatura";
		}

		return subscribedGenres.stream()
				.map(Genre::getLabel)
				.reduce((left, right) -> left + ", " + right)
				.orElse("sem assinatura");
	}

}