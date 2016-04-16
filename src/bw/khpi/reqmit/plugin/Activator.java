package bw.khpi.reqmit.plugin;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import bw.khpi.reqmit.plugin.listener.ActivationListener;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "ReqMIT2Plugin"; //$NON-NLS-1$

	private static Activator plugin;
	

	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ActivationListener listener = new ActivationListener();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(listener);
		PlatformUI.getWorkbench().addWindowListener(listener);
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
