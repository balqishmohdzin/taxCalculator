package taxCalculatorRequest;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TaxCalculatorRequest {

	@JsonProperty("salary")
	private BigDecimal salary;
}
