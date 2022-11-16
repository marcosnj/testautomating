package basicsPOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POJO_Example {

	private int page;
	private int perPage;
	private int total;
	private int totalPages;
	private List<POJO_Datum> data = null;
	private POJO_Support support;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<POJO_Datum> getData() {
		return data;
	}

	public void setData(List<POJO_Datum> data) {
		this.data = data;
	}

	public POJO_Support getSupport() {
		return support;
	}

	public void setSupport(POJO_Support support) {
		this.support = support;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
