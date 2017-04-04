package com.bigmantra.obi.facade.servers;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Server {

	private String hostName;
	private int port;

	protected Server() {
		this(null, 0);
	}

}
