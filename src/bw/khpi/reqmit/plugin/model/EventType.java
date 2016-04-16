package bw.khpi.reqmit.plugin.model;

public enum EventType {
	OPEN {
		@Override
		public String toString(){
			return "open";
		}
	},
	VISIBLE {
		@Override
		public String toString(){
			return "visible";
		}
	},
	HIDDEN {
		@Override
		public String toString(){
			return "hidden";
		}
	},
	CLOSE {
		@Override
		public String toString(){
			return "close";
		}
	},
	EDIT {
		@Override
		public String toString(){
			return "edit";
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
