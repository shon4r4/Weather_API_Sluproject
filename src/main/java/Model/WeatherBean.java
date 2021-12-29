package Model;

public class WeatherBean {

	
	

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	private String weatherDescription;

	private String lastUpdated;
	
	public WeatherBean(String cityStr, String countryStr) {
		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

		public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}

		public Double getWeatherDescription() {
			return Double.parseDouble(weatherDescription);
		}

		public void setWeatherDescription(String weatherDescription) {
			this.weatherDescription = weatherDescription;
		}

		public String getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(String lastUpdated) {
			this.lastUpdated = lastUpdated;
		}


	
	}
	
	
	























	
	
	
	
	
	
	

