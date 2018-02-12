package com.ezypay;

import com.ezypay.controller.SubscriptionServiceController;
import com.ezypay.model.Amount;
import com.ezypay.model.Subscription;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @RunWith(SpringJUnit4ClassRunner.class)
    @WebAppConfiguration
    public static class SampleControllerTests {

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
                MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

        private MockMvc mockMvc;
        @Autowired
        private WebApplicationContext webApplicationContext;

        @Before
        public void setup() {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }
    }

    @Test
    public void testSampleWebService() throws Exception {
        String requestBody = "{\n" +
                "\t\"amount\": {\n" +
                "\t\t\"value\": 20,\n" +
                "        \"currency\": \"AUD\"\n" +
                "\t},\n" +
                "\t\"subscription_type\": \"weekly\",\n" +
                "    \"invoice_dates\": [\"2018-02-26\",\"2018-02-22\"]\n" +
                "}";

        MockMvc mockMvc;

        WebApplicationContext webApplicationContext = null;

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

	@Test
	public void weeklySubscription() {

		SubscriptionServiceController controller = new SubscriptionServiceController();

		Subscription subscription = new Subscription();

		Amount amount = new Amount();
		amount.setValue(100);
		amount.setCurrency("AUD");

		subscription.setAmount(amount);
		subscription.setSubscriptionType("weekly");

		ArrayList<String> invoiceDates = new ArrayList<>();
		invoiceDates.add("2018-02-06");
		invoiceDates.add("2018-02-27");
		subscription.setInvoiceDates(invoiceDates);

		controller.createSubscription(subscription);
	}

	@Test
	public void monthlySubscription() {

		SubscriptionServiceController controller = new SubscriptionServiceController();

		Subscription subscription = new Subscription();

		Amount amount = new Amount();
		amount.setValue(100);
		amount.setCurrency("AUD");

		subscription.setAmount(amount);
		subscription.setSubscriptionType("monthly");

		ArrayList<String> invoiceDates = new ArrayList<>();
		invoiceDates.add("2018-02-06");
		invoiceDates.add("2018-05-27");
		subscription.setInvoiceDates(invoiceDates);

		controller.createSubscription(subscription);
	}

	@Test
	public void weeklySubscriptionDatesMismatch() {

		SubscriptionServiceController controller = new SubscriptionServiceController();

		Subscription subscription = new Subscription();

		Amount amount = new Amount();
		amount.setValue(100);
		amount.setCurrency("AUD");

		subscription.setAmount(amount);
		subscription.setSubscriptionType("monthly");

		ArrayList<String> invoiceDates = new ArrayList<>();
		invoiceDates.add("2018-02-06");
		invoiceDates.add("2018-02-05");
		subscription.setInvoiceDates(invoiceDates);

		controller.createSubscription(subscription);
	}
	@Test
	public void monthlySubscriptionDatesMismatch() {

		SubscriptionServiceController controller = new SubscriptionServiceController();

		Subscription subscription = new Subscription();

		Amount amount = new Amount();
		amount.setValue(100);
		amount.setCurrency("AUD");

		subscription.setAmount(amount);
		subscription.setSubscriptionType("monthly");

		ArrayList<String> invoiceDates = new ArrayList<>();
		invoiceDates.add("2018-02-26");
		invoiceDates.add("2018-05-20");
		subscription.setInvoiceDates(invoiceDates);

		controller.createSubscription(subscription);
	}
}
