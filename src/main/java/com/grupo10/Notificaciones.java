package com.grupo10;

import java.util.ArrayList;
import java.util.List;

public class Notificaciones {
	private List<String> emails = new ArrayList<String>();

	void notificar(String email)
	{
		emails.add(email);
	}
}
