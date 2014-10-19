package com.grupo10.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.group10.db.*;

public class TestConexionSQL {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		EntityManagerHelper.withTransaction(() -> {
		});
	}
}
