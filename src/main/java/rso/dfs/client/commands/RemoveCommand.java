package rso.dfs.client.commands;

import java.io.File;

import rso.dfs.client.handlers.GetHandler;
import rso.dfs.client.handlers.RemoveHandler;

/**
 * @author Adam Papros <adam.papros@gmail.com>
 * */
public class RemoveCommand extends ClientActionBase {

	public RemoveCommand() {
	}

	@Override
	public String getCommandName() {
		return "rm";
	}

	@Override
	public String getHelp() {
		return "help for get command";
	}

	@Override
	public void performCommand(String line) throws Exception {
		String filePath = assemblyFileName(line);

		RemoveHandler handler = new RemoveHandler(masterIpAddress);
		try {
			handler.performRemove(filePath);
		} catch (Exception e) {

		}

	}

	private String assemblyFileName(final String line) {
		String[] tokens = line.split(" ");
		if (tokens.length != 2) {
			// raise error
		}
		return tokens[1];
	}

}
