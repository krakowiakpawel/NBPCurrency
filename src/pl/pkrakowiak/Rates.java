package pl.pkrakowiak;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rates")
public class Rates {

	List<Rate> rates;

	public List<Rate> getRates() {
		return rates;
	}

	@XmlElement(name = "Rate")
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}
