package com.fernandoalves.observerstreaming.observer;

import com.fernandoalves.observerstreaming.domain.MediaRelease;

public interface Subject {

	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers(MediaRelease release);

}