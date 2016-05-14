package bw.khpi.reqmit.plugin.listener;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;

import bw.khpi.reqmit.plugin.model.Event;
import bw.khpi.reqmit.plugin.model.EventType;
import bw.khpi.reqmit.plugin.service.ConnectionProvider;
import bw.khpi.reqmit.plugin.util.FormatUtils;
import bw.khpi.reqmit.plugin.util.TimeUtils;

class DeltaVisitor implements IResourceDeltaVisitor {

	@Override
	public boolean visit(IResourceDelta delta) {
		IResource res = delta.getResource();
		switch (delta.getKind()) {
		case IResourceDelta.ADDED: {
			//System.out.print(res.getFullPath());
			ConnectionProvider.sendMessage(FormatUtils.eventToJson(res.getFullPath().toString(), 
					new Event(TimeUtils.getCurrentTime(), EventType.CREATE)));
			break;
		}
		case IResourceDelta.REMOVED: {
			//System.out.print(res.getFullPath());
			ConnectionProvider.sendMessage(FormatUtils.eventToJson(res.getFullPath().toString(), 
					new Event(TimeUtils.getCurrentTime(), EventType.REMOVE)));
			break;
		}
		case IResourceDelta.CHANGED: {
			// IMarkerDelta[] markerDelta = delta.getMarkerDeltas();
			//System.out.print(res.getFullPath());
			ConnectionProvider.sendMessage(FormatUtils.eventToJson(res.getFullPath().toString(), 
					new Event(TimeUtils.getCurrentTime(), EventType.EDIT)));
			break;
		}
		}
		return true;
	}
}
