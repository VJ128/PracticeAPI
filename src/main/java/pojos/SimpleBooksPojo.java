package pojos;

public class SimpleBooksPojo {
	int bookId;
	String customerName;

	SimpleBooksPojo() {
	}

	public SimpleBooksPojo(int bookId, String customerName) {
		super();
		this.bookId = bookId;
		this.customerName = customerName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "SimpleBooksPojo [bookId=" + bookId + ", customerName=" + customerName + "]";
	}

}
