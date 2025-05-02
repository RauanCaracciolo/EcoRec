package controler.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommandFactory {
	public static Command getCommand(String action, HttpServletRequest request, HttpServletResponse response) {
		if(action == null || action.isEmpty()){
			System.out.println("Default command");
			return new DefaultCommand();
		}else {
			switch(action) {
				case"Login":
					return new LoginCommand();
				case"RegisterUser":  			
					return new RegisterUserCommand(); 
				case"RegisterColetor":
					return new RegisterColetorCommand();
				default: return new DefaultCommand();
			}	
		}
	}
}
