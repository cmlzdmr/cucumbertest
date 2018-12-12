package com.automationpractise.step_definitions;

import java.util.Locale;
import java.util.Map;

import com.automationpractise.beans.User;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;


public class DataTableConfigurer implements TypeRegistryConfigurer{
	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	public void configureTypeRegistry(TypeRegistry typeRegistry) {

		typeRegistry.defineDataTableType(new DataTableType(User.class,

				new TableEntryTransformer<User>() {

					@Override
					public User transform(Map<String, String> row) throws Throwable {
						// these keys must match the data table in the feature file
						String firstName = row.get("First Name");
						String lastName = row.get("Last Name");
						String company = row.get("Company");
						String email = row.get("Email");
						String password = row.get("Password");
						String address = row.get("Address");
						String zipcode = row.get("Zipcode");
						String state = row.get("State");
						String phone = row.get("Phone");
						String city = row.get("City");
						return new User(firstName, lastName, email, phone, company, address, city, password, zipcode,
								state);
					}
				}));
}}
