# subscriptionapi

Scope: Web application with an endpoint to create a user subscription

End-point: /user/subscription

Request payload format: Application accepts request payload in JSON format

{
	"amount": {
		"value": <integer>,
        "currency": "AUD"
	},
	"subscription_type": <"weekly"/"monthly">,
    "invoice_dates": ["<subscription_start_date","<subscription_end_date>"]
}
accepted date format: yyyy/mm/dd. Example: 2018-02-26

Running the application:
This project has been created with Spring boot initializer module using IntelliJ. Built using Gradle.

Run com.ezypay.Application.java file
OR
run the command ./gradlew bootRun from Terminal/CommandLine
