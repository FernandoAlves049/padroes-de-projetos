package com.fernandoalves.observerstreaming.observer;

import com.fernandoalves.observerstreaming.domain.MediaRelease;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StreamingPlatform implements Subject {

	private final List<Observer> observers = new ArrayList<>();
	private final List<MediaRelease> releases = new ArrayList<>();

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(MediaRelease release) {
		for (Observer observer : observers) {
			if (observer instanceof Client client && client.isInterestedIn(release)) {
				client.update(release);
			}
		}
	}

	public List<String> publishAndCollectNotifications(MediaRelease release) {
		releases.add(release);
		List<String> notifications = new ArrayList<>();
		for (Observer observer : observers) {
			if (observer instanceof Client client && client.isInterestedIn(release)) {
				String notification = client.createNotificationMessage(release);
				client.update(release);
				notifications.add(notification);
			}
		}
		return notifications;
	}

	public void publish(MediaRelease release) {
		publishAndCollectNotifications(release);
	}

	public List<MediaRelease> getReleases() {
		return Collections.unmodifiableList(releases);
	}

}