package bw.khpi.reqmit.plugin.listener;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;

class DeltaVisitor implements IResourceDeltaVisitor {
	
	@Override
    public boolean visit(IResourceDelta delta) {
       IResource res = delta.getResource();
       switch (delta.getKind()) {
          case IResourceDelta.ADDED:{
              break;
          }
          case IResourceDelta.REMOVED:{
              break;
          }
          case IResourceDelta.CHANGED:{
              break;
          }
       }
       return true;
    }
 }
