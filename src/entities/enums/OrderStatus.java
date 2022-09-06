package entities.enums;

public enum OrderStatus {
	PENDING_PAYMENT {
		public String toString() {
			return "Pending payment";
		}
	},
	PROCESSING {
		public String toString(){
			return "Processing";
		}
	},
	SHIPPED {
		public String toString() {
			return "Shipped";
		}
	},
	DELIVERED {
		public String toString() {
			return "Delivered";
		}
	};
}
