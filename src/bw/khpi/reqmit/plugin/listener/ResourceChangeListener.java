package bw.khpi.reqmit.plugin.listener;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;

import bw.khpi.reqmit.plugin.service.ConnectionProvider;

public class ResourceChangeListener implements IResourceChangeListener {

	private static List<IResourceDelta> deltas = new LinkedList<>();

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		deltas = new LinkedList<>();
		getModifiedDeltas(event.getDelta());
		switch (event.getType()) {
        case IResourceChangeEvent.PRE_CLOSE:
           break;
        case IResourceChangeEvent.PRE_DELETE:
           break;
        case IResourceChangeEvent.POST_CHANGE:
        	for (IResourceDelta d : deltas) {
    			try {
    				d.accept(new DeltaVisitor());
    			} catch (CoreException e) {
    				e.printStackTrace();
    			}
    		}
           break;
        case IResourceChangeEvent.PRE_BUILD:
           break;
        case IResourceChangeEvent.POST_BUILD:
           break;
     }
		

	}

	public void getModifiedDeltas(IResourceDelta delta) {
		if (delta != null && delta.getAffectedChildren().length == 0
				&& !"class".equalsIgnoreCase(delta.getResource().getFileExtension())) {
			deltas.add(delta);
			return;
		}
		for (IResourceDelta d : delta.getAffectedChildren()) {
			getModifiedDeltas(d);
		}
		return;
	}
}
