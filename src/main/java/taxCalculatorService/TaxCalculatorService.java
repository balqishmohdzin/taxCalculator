package taxCalculatorService;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import taxCalculatorRequest.TaxCalculatorRequest;
import taxCalculatorResponse.TaxCalculatorResponse;

@Slf4j
@Service
public class TaxCalculatorService {

	public TaxCalculatorResponse calculatingIncomeTax(TaxCalculatorRequest request) {
		TaxCalculatorResponse taxCalculatorResponse = new TaxCalculatorResponse();

		return taxCalculatorResponse;
	}

	public TaxCalculatorResponse calculateTax(BigDecimal salary) {
		TaxCalculatorResponse taxCalculatorResponse = new TaxCalculatorResponse();
		if (salary.compareTo(new BigDecimal(5000)) <= 0) {
			taxCalculatorResponse.setTaxCalculatorResponse(salary, 0);
			return taxCalculatorResponse;
		}
		if (salary.compareTo(new BigDecimal(5001)) >= 0 && salary.compareTo(new BigDecimal(20000)) <= 0) {
			return this.taxCalculatorResponse(salary, 1);
		}

		if (salary.compareTo(new BigDecimal(20001)) >= 0 && salary.compareTo(new BigDecimal(35000)) <= 0) {
			return this.taxCalculatorResponse(salary, 3);
		}
		if (salary.compareTo(new BigDecimal(35001)) >= 0 && salary.compareTo(new BigDecimal(50000)) <= 0) {
			return this.taxCalculatorResponse(salary, 8);
		}
		if (salary.compareTo(new BigDecimal(50001)) >= 0 && salary.compareTo(new BigDecimal(70000)) <= 0) {
			return this.taxCalculatorResponse(salary, 13);
		}
		if (salary.compareTo(new BigDecimal(70001)) >= 0 && salary.compareTo(new BigDecimal(100000)) <= 0) {
			return this.taxCalculatorResponse(salary, 21);
		}
		if (salary.compareTo(new BigDecimal(100001)) >= 0 && salary.compareTo(new BigDecimal(250000)) <= 0) {
			return this.taxCalculatorResponse(salary, 24);
		}
		if (salary.compareTo(new BigDecimal(250001)) >= 0 && salary.compareTo(new BigDecimal(400000)) <= 0) {
			return this.taxCalculatorResponse(salary, 24.5);
		}
		if (salary.compareTo(new BigDecimal(400001)) >= 0 && salary.compareTo(new BigDecimal(600000)) <= 0) {
			return this.taxCalculatorResponse(salary, 25);
		}
		if (salary.compareTo(new BigDecimal(600001 )) >= 0 && salary.compareTo(new BigDecimal(1000000)) <= 0) {
			return this.taxCalculatorResponse(salary, 26);
		}
		if (salary.compareTo(new BigDecimal(1000001  )) >= 0 && salary.compareTo(new BigDecimal(2000000)) <= 0) {
			return this.taxCalculatorResponse(salary, 28);
		}
		if (salary.compareTo(new BigDecimal(20000001)) >= 0) {
			return this.taxCalculatorResponse(salary, 30);
        }

		return taxCalculatorResponse;

	}

	private TaxCalculatorResponse taxCalculatorResponse(BigDecimal salary, double tax) {
		TaxCalculatorResponse taxCalculatorResponse = new TaxCalculatorResponse();
		BigDecimal salaryTax;

		salaryTax = salary.multiply(new BigDecimal(tax));

		BigDecimal netIncome = salary.subtract(salaryTax);
		taxCalculatorResponse.setTaxCalculatorResponse(netIncome, tax);
		return taxCalculatorResponse;
	}
}
