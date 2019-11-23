package mainPackage;
import org.eclipse.jface.viewers.TableViewer;

/**
 * Класс предназначен для реализации поддержки редактирования столбца "Имя" таблицы Table.
 */
public class NameEditingSupport extends UserEditingSupport {
	
	/**
	 * Конструктор класса AgeEditingSupport.
	 * @param viewer - объект класса TableViewer, связанный с таблицей
	 * @param userEditingListener - слушатель нажатия на столбец таблицы
	 * @param errorInputListener - слушатель ввода в таблицу неподдерживаемого столбцом значения 
	 */
	public NameEditingSupport(TableViewer viewer, UserEditingListener userEditingListener, ErrorInputListener errorInputListener) {
		super(viewer, userEditingListener, errorInputListener);
	}

	@Override
	protected Object getValue(Object element) {
	    return ((User) element).getName();
	}

	@Override
	protected void setValue(Object element, Object userInputValue) {
		ErrorChecker nameChecker = new ErrorChecker();
		nameChecker.checkName(String.valueOf(userInputValue));
		if (!nameChecker.getErrorMesssage().equals("")) {
			errorInputListener.createMessage(nameChecker.getErrorMesssage());
			return;
		}
	    userEditingListener.changeUserName((User)element, String.valueOf(userInputValue));
	}
}
