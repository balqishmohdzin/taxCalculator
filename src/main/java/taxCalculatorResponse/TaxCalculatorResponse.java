package taxCalculatorResponse;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TaxCalculatorResponse {

	@JsonProperty("net_salary")
	private BigDecimal netSalary;

	@JsonProperty("tax_rate")
	private double taxRate;

	public void setTaxCalculatorResponse(BigDecimal netSalary, double tax) {
		this.netSalary = netSalary;
		this.taxRate = tax;
	}
}
