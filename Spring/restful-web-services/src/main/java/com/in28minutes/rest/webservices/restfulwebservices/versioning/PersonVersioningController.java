package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// Using different methods for versioning
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Sandeep Negi");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Sandeep", "Negi"));
	}

	// Using request param for versioning
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Sandeep Negi");
	}

	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Sandeep", "Negi"));
	}

	// Using header param for versioning
	@GetMapping(value = "person/header", headers = "X_API_VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Sandeep Negi");
	}

	@GetMapping(value = "person/header", headers = "X_API_VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Sandeep", "Negi"));
	}

	// Using Content negotiotion/ Accept header  for versioning
		@GetMapping(value = "person/produces", produces = "application/v1+json")
		public PersonV1 producesV1() {
			return new PersonV1("Sandeep Negi");
		}

		@GetMapping(value = "person/produces", produces = "application/v2+json")
		public PersonV2 producesV2() {
			return new PersonV2(new Name("Sandeep", "Negi"));
		}
	
}
