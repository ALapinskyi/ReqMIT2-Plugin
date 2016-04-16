package bw.khpi.reqmit.plugin.listener;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.CoreException;

public class ResourceChangeListener implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		IResource res = event.getResource();

		switch (event.getType()) {
		case IResourceChangeEvent.PRE_CLOSE: {
			break;
		}
		case IResourceChangeEvent.PRE_DELETE: {
			break;
		}
		case IResourceChangeEvent.POST_CHANGE: {
			break;
		}
		case IResourceChangeEvent.PRE_BUILD: {
			break;
		}
		case IResourceChangeEvent.POST_BUILD: {
			break;
		}
		}

	}
}
