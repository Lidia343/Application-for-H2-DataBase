import java.util.ArrayList;

/**
 * Класс предназначен для реализации команды обновления пользователя.
 */
public class CommandUpdate implements Command{
	
	private Storage storage;
	private User prevUser;
	private User nextUser;
	
	/**
	 * Конструктор класса CommandUpdate.
	 * @param storage - хранилище данных пользователей
	 * @param user - объект класса User
	 */
	public CommandUpdate (Storage storage, User user) {
		this.storage = storage;
		nextUser = user;
		prevUser = null;
	}
	
	@Override
	public void execute() throws Exception {
		ArrayList<User> users = new ArrayList<User>();
		users = storage.getUsersDataSet(false);
		for (User temp : users) 
			if (temp.getId() == nextUser.getId()) {
				storage.updateUser(nextUser);
				prevUser = temp;
				break;
			}
	}
	
	@Override public void undo() throws Exception {
		storage.updateUser(prevUser);
	}
	
	@Override
	public void redo() throws Exception {
		storage.updateUser(nextUser);
	}
}