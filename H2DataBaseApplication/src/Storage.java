
/**
 * Интерфейс, необходимый для определения методов, которые должны содержать классы, реализующие хранение данных.
 */
public interface Storage {
	
	/**
	 * Метод для установки хранилища.
	 */
	void setStorage();
	
	/**
	 * Метод для создания объекта хранилища.
	 */
	void createStorageObject();
	
	/**
	 * Метод для сброса первичного ключа.
	 */
	void updateStorageObject();
	
	/**
	 * Метод для добавления данных пользователя в хранилище.
	 * @param user - объект, содержащий данные пользователя
	 */
	void addUser(User user);
	
	/**
	 * Метод для добавления данных пользователя в хранилище.
	 * @param user - объект, содержащий данные пользователя
	 * @param deletedUserId - код удалённого пользователя (передаётся при восстановлении удалённого пользователя)
	 */
	void addUser(User user, int deletedUserId);
	
	/**
	 * Метод для изменения данных пользователя в хранилище.
	 * @param id - код, необходимый для поиска данных пользователя (не изменяется)
	 * @param name - имя
	 * @param surname - фамилия
	 * @param age - возраст
	 * @param isActive - активен/неактивен
	 */
	void updateUser(User user);
	
	/**
	 * Метод для удаления данных пользователя из хранилища.
	 * @param id - код пользователя
	 */
	void deleteUser(int id);
	
	/**
	 * Метод для возврата объекта, содержащего данные всех пользователей хранилища.
	 * @return объект класса DataSet
	 */
	User getUsersDataSet(boolean isSorted);
	
	/**
	 * Метод для возврата сообщения об ошибке.
	 * @return сообщение об ошибке, если она произошла, иначе - пустую строку  
	 */
	String getErrorMessage();
	
	/**
	 * Метод для закрытия хранилища без потерь данных, содержащихся в нём.
	 */
	void closeStorage();
}
