package taxCalculatorController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import taxCalculatorRequest.TaxCalculatorRequest;
import taxCalculatorService.TaxCalculatorService;

@Slf4j
@RestController
public class TaxCalculatorController {

	private final TaxCalculatorService taxCalculatorService;

	@PostMapping(value = "tax-calculator", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> incomeTax(@RequestBody TaxCalculatorRequest request) {
		return new ResponseEntity<>(taxCalculatorService.calculatingIncomeTax(request), HttpStatus.OK);
	}

	public TaxCalculatorController(TaxCalculatorService taxCalculatorService) {
		this.taxCalculatorService = taxCalculatorService;
	}
}
