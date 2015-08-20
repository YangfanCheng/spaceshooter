package GameStates;

public class StatesManager {
	DifferentStates currentState= DifferentStates.Menu;
	public StatesManager(DifferentStates state){
				state= currentState;
				switch(state){
				case Menu: 
					new MenuState();
					break;
				case NewGame:
					new Level1State();
					break;
				case Exit:
					System.exit(0);
					break;
					
				}
	} 
	public void getNewGame(){}
	public void getExit(){}
			

	
}
