package bw.khpi.reqmit.plugin.model;

public enum EventType {
	OPEN {
		@Override
		public String toString(){
			return "open";
		}
	},
	ACTIVATE {
		@Override
		public String toString(){
			return "activate";
		}
	},
	DEACTIVATE {
		@Override
		public String toString(){
			return "deactivate";
		}
	},
	EDIT {
		@Override
		public String toString(){
			return "edit";
		}
	},
	CLOSE {
		@Override
		public String toString(){
			return "close";
		}
	},
	CREATE {
		@Override
		public String toString(){
			return "create";
		}
	},
	REMOVE {
		@Override
		public String toString(){
			return "remove";
		}
	}
}
