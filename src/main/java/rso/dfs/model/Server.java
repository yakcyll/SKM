package rso.dfs.model;

import org.joda.time.DateTime;

/**
 * @author Adam Papros <adam.papros@gmail.com>
 * */
public class Server {

	private Long id;
	
	private String ip;

	private ServerRole role;

	private long memory;

	private DateTime lastConnection;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public ServerRole getRole() {
		return role;
	}

	public void setRole(ServerRole role) {
		this.role = role;
	}

	public long getMemory() {
		return memory;
	}

	public void setMemory(long memory) {
		this.memory = memory;
	}

	public DateTime getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(DateTime lastConnection) {
		this.lastConnection = lastConnection;
	}

	@Override
	public boolean equals(Object obj) {
		Server s = (Server) obj;
		return this.ip.equals(s.getIp());
	}

	@Override
	public String toString() {
		return "Server [ip=" + ip + ", role=" + role + ", memory=" + memory + ", lastConnection=" + lastConnection + "]";
	}

}
