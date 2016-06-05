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

	private static int lastEvent;

	@Override
	public boolean visit(IResourceDelta delta) {
		IResource res = delta.getResource();
		switch (delta.getKind()) {
		case IResourceDelta.ADDED: {
			if (lastEvent == IResourceDelta.REMOVED) {
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(FormatUtils.convertPath(res.getFullPath().toString()),
						new Event(TimeUtils.getCurrentTime(), EventType.RENAME)));
				lastEvent = 0;
			} else {
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(FormatUtils.convertPath(res.getFullPath().toString()),
						new Event(TimeUtils.getCurrentTime(), EventType.CREATE)));
				lastEvent = IResourceDelta.ADDED;
			}
			break;
		}
		case IResourceDelta.REMOVED: {
			if (lastEvent == IResourceDelta.ADDED) {
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(FormatUtils.convertPath(res.getFullPath().toString()),
						new Event(TimeUtils.getCurrentTime(), EventType.REPLACE)));
				lastEvent = 0;
			} else {
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(FormatUtils.convertPath(res.getFullPath().toString()),
						new Event(TimeUtils.getCurrentTime(), EventType.REMOVE)));
				lastEvent = IResourceDelta.REMOVED;
			}
			break;
		}
		case IResourceDelta.CHANGED: {
			ConnectionProvider.sendMessage(FormatUtils.eventToJson(FormatUtils.convertPath(res.getFullPath().toString()),
					new Event(TimeUtils.getCurrentTime(), EventType.EDIT)));
			break;
		}
		}
		return true;
	}
}
