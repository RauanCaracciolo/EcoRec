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
				case"RegisterUser":  			
					System.out.println("Default command");
					return new RegisterUserCommand(); 
				default: return new DefaultCommand();
			}	
		}
	}
}
