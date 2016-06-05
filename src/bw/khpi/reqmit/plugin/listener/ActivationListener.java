package bw.khpi.reqmit.plugin.listener;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;

import bw.khpi.reqmit.plugin.model.Event;
import bw.khpi.reqmit.plugin.model.EventType;
import bw.khpi.reqmit.plugin.model.UnitMap;
import bw.khpi.reqmit.plugin.model.UnitStructure;
import bw.khpi.reqmit.plugin.model.WorkspaceUnit;
import bw.khpi.reqmit.plugin.service.ConnectionProvider;
import bw.khpi.reqmit.plugin.util.FormatUtils;
import bw.khpi.reqmit.plugin.util.TimeUtils;

public class ActivationListener implements IPartListener2, IWindowListener {
	
	private String activPath;

	@Override
	public void partOpened(IWorkbenchPartReference part) {
		WorkspaceUnit workspaceUnit = new WorkspaceUnit(part.getPart(true));
		if (workspaceUnit.getPart() != null) {
			UnitStructure structure = new UnitStructure(workspaceUnit, new LinkedList<Event>());

			ConnectionProvider.sendMessage(FormatUtils.eventToJson(FormatUtils.convertPath(structure.getUnit().getPath()), 
					new Event(TimeUtils.getCurrentTime(), EventType.OPEN)));
			if (!UnitMap.getUnits().containsKey(workspaceUnit.getPath())) {
				UnitMap.addUnit(FormatUtils.convertPath(structure.getUnit().getPath()), structure);
				structure = UnitMap.getUnits().get(FormatUtils.convertPath(structure.getUnit().getPath()));
				List<Event> list = structure.getEvents();
				list.add(new Event(TimeUtils.getCurrentTime(), EventType.OPEN));
			}
		}
	}

	@Override
	public void partClosed(IWorkbenchPartReference part) {
		String path = "/" + FormatUtils.convertPath(part.getPart(true).getTitleToolTip());
		if (UnitMap.getUnits().containsKey(path)) {
			UnitStructure structure = UnitMap.getUnits().get(path);
			List<Event> list = structure.getEvents();
			long date = TimeUtils.getCurrentTime();
			if (list.get(list.size() - 1).getEventTime().compareTo(date) == 0) {
				list.remove(list.size() - 1);
			}
			list.add(new Event(date, EventType.CLOSE));
			ConnectionProvider.sendMessage(FormatUtils.eventToJson(structure.getUnit().getPath(), 
					new Event(TimeUtils.getCurrentTime(), EventType.CLOSE)));
			UnitMap.removeUnit(path);
		}
	}

	@Override
	public void partVisible(IWorkbenchPartReference part) {
		String path = "/" + FormatUtils.convertPath(part.getPart(true).getTitleToolTip());
		if (UnitMap.getUnits().containsKey(path)) {
			UnitStructure structure = UnitMap.getUnits().get(path);
			List<Event> list = structure.getEvents();
			if (list.get(list.size() - 1).getEventType() != EventType.OPEN
					&& list.get(list.size() - 1).getEventType() != EventType.VISIBLE){
				list.add(new Event(TimeUtils.getCurrentTime(), EventType.VISIBLE));
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(structure.getUnit().getPath(), 
						new Event(TimeUtils.getCurrentTime(), EventType.VISIBLE)));
			}
			
		} else {
			partOpened(part);
		}

	}

	@Override
	public void partHidden(IWorkbenchPartReference part) {
		String path = "/" + FormatUtils.convertPath(part.getPart(true).getTitleToolTip());
		if (UnitMap.getUnits().containsKey(path)) {
			UnitStructure structure = UnitMap.getUnits().get(path);
			List<Event> list = structure.getEvents();
			if (list.get(list.size() - 1).getEventType() != EventType.HIDDEN){
				list.add(new Event(TimeUtils.getCurrentTime(), EventType.HIDDEN));
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(structure.getUnit().getPath(), 
						new Event(TimeUtils.getCurrentTime(), EventType.HIDDEN)));
			}
		}

	}

	@Override
	public void windowActivated(IWorkbenchWindow window) {
		UnitMap.getUnits().forEach((k,v) -> {
			if(k.equals(activPath)){
				v.getEvents().add(new Event(TimeUtils.getCurrentTime(), EventType.VISIBLE));
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(v.getUnit().getPath(), 
						new Event(TimeUtils.getCurrentTime(), EventType.VISIBLE)));
			}
		});
	}

	@Override
	public void windowDeactivated(IWorkbenchWindow window) {
		UnitMap.getUnits().forEach((k,v) -> {
			List<Event> event = v.getEvents();
			if(event.get(event.size() - 1).getEventType() != EventType.HIDDEN){
				event.add(new Event(TimeUtils.getCurrentTime(), EventType.HIDDEN));
				ConnectionProvider.sendMessage(FormatUtils.eventToJson(v.getUnit().getPath(), 
						new Event(TimeUtils.getCurrentTime(), EventType.HIDDEN)));
				activPath = k;
			}
		});
	}

	// ---------------------------------
	// unused method's
	// ---------------------------------

	@Override
	public void partInputChanged(IWorkbenchPartReference arg0) {

	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference arg0) {

	}

	@Override
	public void partActivated(IWorkbenchPartReference arg0) {

	}

	@Override
	public void partDeactivated(IWorkbenchPartReference arg0) {

	}

	@Override
	public void windowOpened(IWorkbenchWindow arg0) {

	}

	@Override
	public void windowClosed(IWorkbenchWindow window) {

	}

}
