package com.fernandoalves.observerstreaming.domain;

public enum Genre {

	ACTION("Ação"),
	COMEDY("Comédia"),
	HORROR("Terror"),
	ANIME("Anime"),
	SCIENCE_FICTION("Ficção científica");

	private final String label;

	Genre(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}