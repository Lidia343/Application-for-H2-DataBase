import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;

public class IsActiveEditingSupport extends UserEditingSupport {

	public IsActiveEditingSupport(TableViewer viewer, TableViewerUserEditingListener userEditingListener) {
		super(viewer, userEditingListener, null);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);
	}

	@Override
	protected Object getValue(Object element) {
		User user = (User) element;
	    return user.isActive();
	}

	@Override
	protected void setValue(Object element, Object value) {
		User prevUser = (User)element;
		User nextUser = (User)element;
		nextUser.setIsActive((Boolean) value);
		userEditingListener.changeUserInStorage(prevUser, nextUser);
	    viewer.update((Object)nextUser, null);
	}
}
