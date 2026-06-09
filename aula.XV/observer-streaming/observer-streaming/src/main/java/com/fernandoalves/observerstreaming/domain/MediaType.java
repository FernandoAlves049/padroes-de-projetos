package com.fernandoalves.observerstreaming.domain;

public enum MediaType {

	MOVIE("Filme"),
	SERIES("Série");

	private final String label;

	MediaType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}