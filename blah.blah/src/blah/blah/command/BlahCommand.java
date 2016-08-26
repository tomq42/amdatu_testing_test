package blah.blah.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import blah.blah.api.Blah;
import osgi.enroute.debug.api.Debug;

/**
 * This is the implementation. It registers the Blah interface and calls it
 * through a Gogo command.
 * 
 */
@Component(service=BlahCommand.class, property = { Debug.COMMAND_SCOPE + "=blah",
		Debug.COMMAND_FUNCTION + "=blah" }, name="blah.blah.command")
public class BlahCommand {
	private Blah target;

	public void blah(String message) {
		target.say(message);
	}

	@Reference
	void setBlah(Blah service) {
		this.target = service;
	}

}
