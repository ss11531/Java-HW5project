package model;

public class Porder {
	private Integer id;
	private String name;
	private Integer water;// 水洗服務
	private Integer dry;// 乾洗服務
	private Integer exquisite;// 精緻清洗
	private Integer doll;// 玩偶清洗
	
	public Porder(String name, Integer water, Integer dry, Integer exquisite, Integer doll) {
		super();
		this.name = name;
		this.water = water;
		this.dry = dry;
		this.exquisite = exquisite;
		this.doll = doll;
	}

	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWater() {
		return water;
	}

	public void setWater(Integer water) {
		this.water = water;
	}

	public Integer getDry() {
		return dry;
	}

	public void setDry(Integer dry) {
		this.dry = dry;
	}

	public Integer getExquisite() {
		return exquisite;
	}

	public void setExquisite(Integer exquisite) {
		this.exquisite = exquisite;
	}

	public Integer getDoll() {
		return doll;
	}

	public void setDoll(Integer doll) {
		this.doll = doll;
	}
	


}
