package br.com.claratersi.autoinvite.init;

public class FormProperties {
		
	private String apiAddress;
	private String apiKey;
	private String formUID;
	private Boolean resultsCompleted;
	private Long resultsSince;
	private Integer resultsLimit;
	private String resultsOrderBy;
	private String resultsSortBy;
	
	public FormProperties(String apiAddress, String apiKey, String formUID) {
		this.apiAddress = apiAddress;
		this.apiKey = apiKey;
		this.formUID = formUID;
	}
	
	public void setResultsCompleted(Boolean resultsCompleted) {
		this.resultsCompleted = resultsCompleted;
	}

	public void setResultsSince(Long resultsSince) {
		this.resultsSince = resultsSince;
	}

	public void setResultsLimit(Integer resultsLimit) {
		this.resultsLimit = resultsLimit;
	}

	public void setResultsOrderBy(String resultsOrderBy) {
		this.resultsOrderBy = resultsOrderBy;
	}

	public void setResultsSortBy(String resultsSortBy) {
		this.resultsSortBy = resultsSortBy;
	}

	public String getTarget() {
		StringBuilder builder = new StringBuilder()
				.append(apiAddress)
				.append(formUID)
				.append("?key=").append(apiKey);
		if(resultsCompleted) {
			builder.append("&completed=").append(resultsCompleted);
		}
		if(resultsSince != null) {
			builder.append("&since=").append(String.valueOf(resultsSince));
		}
		if(resultsLimit != null) {
			builder.append("&limit=").append(String.valueOf(resultsLimit));
		}
		if(resultsOrderBy != null && !resultsOrderBy.isEmpty()) {
			if(resultsSortBy == null || resultsSortBy.isEmpty() || resultsSortBy.equalsIgnoreCase("asc")) {
				builder.append("&order_by=").append(String.valueOf(resultsOrderBy));
			} else {
				builder.append("&order_by[]=").append(String.valueOf(resultsOrderBy)).append(",desc");
			}			
		}
		return builder.toString();
	}
	
}
