package bw.khpi.reqmit.plugin;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetEditWizard;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import bw.khpi.reqmit.plugin.listener.ActivationListener;
import bw.khpi.reqmit.plugin.listener.ResourceChangeListener;
import bw.khpi.reqmit.plugin.service.ConnectionProvider;
import bw.khpi.reqmit.plugin.service.ListenerService;
import bw.khpi.reqmit.plugin.service.SenderService; 
public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "ReqMIT2Plugin"; //$NON-NLS-1$

	private static Activator plugin;
	

	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		
		ConnectionProvider.setSenderService(new SenderService());
		ConnectionProvider.setListenerService(new ListenerService());
		
		ActivationListener listener = new ActivationListener();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(listener);
		PlatformUI.getWorkbench().addWindowListener(listener);

		ResourcesPlugin.getWorkspace().addResourceChangeListener(
				new ResourceChangeListener(), IResourceChangeEvent.POST_CHANGE);
		
		
		IWorkingSetManager wsm=PlatformUI.getWorkbench().getWorkingSetManager();
		IWorkingSet[] a = wsm.getAllWorkingSets();
		
		IWorkingSet ws = wsm.createWorkingSet("34", new IAdaptable[0]);
		IWorkingSetEditWizard wizard = wsm.createWorkingSetEditWizard(ws);
		
		//Method updateWorkingSetSelection = WorkingSetConfigurationBlock.class.getDeclaredMethod("setSelection");
		//updateWorkingSetSelection.invoke(null, "");
		System.out.println(a.length);
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
