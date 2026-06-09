package com.fernandoalves.observerstreaming.domain;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public record MediaRelease(String title, MediaType type, Set<Genre> genres) {

	public MediaRelease {
		genres = genres == null || genres.isEmpty()
				? Collections.emptySet()
				: Collections.unmodifiableSet(EnumSet.copyOf(genres));
	}

}