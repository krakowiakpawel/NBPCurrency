package pl.pkrakowiak;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")

public class Rate {

	String Currency;
	String Code;
	Double Bid;
	Double Ask;

	public String getCurrency() {
		return Currency;
	}

	@XmlElement(name = "Currency")
	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getCode() {
		return Code;
	}

	@XmlElement(name = "Code")
	public void setCode(String code) {
		Code = code;
	}

	public Double getBid() {
		return Bid;
	}

	@XmlElement(name = "Bid")
	public void setBid(Double bid) {
		Bid = bid;
	}

	public Double getAsk() {
		return Ask;
	}

	@XmlElement(name = "Ask")
	public void setAsk(Double ask) {
		Ask = ask;
	}

}
