package pojos;

public class PojoSingleUser {
	String name;
	String job;
	String id;
	String createdAt;

	PojoSingleUser() {
	}

	public PojoSingleUser(String name, String job) {
		super();
		this.name = name;
		this.job = job;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PojoSingleUser [name=" + name + ", job=" + job + ", id=" + id + ", createdAt=" + createdAt + "]";
	}
}
