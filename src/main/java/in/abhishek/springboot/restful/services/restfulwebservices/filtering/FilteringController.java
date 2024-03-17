package in.abhishek.springboot.restful.services.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBeans filtering() {
		return new SomeBeans("value1", "value2", "value3");
	}
	
	@GetMapping("/filtering-lists")
	public List<SomeBeans> filteringLists() {
		return Arrays.asList(new SomeBeans("value1", "value2", "value3"), new SomeBeans("value4", "value5", "value6"));
	}
}
