package bw.khpi.reqmit.plugin.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IWorkbenchPart;

public class WorkspaceUnit {

	private IWorkbenchPart part;
	private String path;

	public IWorkbenchPart getPart() {
		return part;
	}

	public String getPath() {
		return path;
	}
	
	public String getFullPath() {
		return path + "/" + part.getTitle();
	}

	public WorkspaceUnit(IWorkbenchPart part) {
		this.part = part;
		setFilePath();
	}

	private void setFilePath() {
		try {
			IFile file = part.getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			this.path = file.getFullPath().toOSString();
		} catch (NullPointerException e) {
			part = null;
		}
	}
}
