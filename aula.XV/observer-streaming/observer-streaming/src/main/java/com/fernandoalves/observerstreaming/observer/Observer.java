package com.fernandoalves.observerstreaming.observer;

import com.fernandoalves.observerstreaming.domain.MediaRelease;

public interface Observer {

	void update(MediaRelease release);

}