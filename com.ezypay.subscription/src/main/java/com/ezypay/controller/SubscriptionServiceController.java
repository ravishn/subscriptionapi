package com.ezypay.controller;

import com.ezypay.model.Subscription;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller class to read the Request payload and process the JSON response
 * Created by ravishnagaraj on 12/2/18.
 */

@RestController
public class SubscriptionServiceController {

    /**
     * API for POST
     * @param subscription
     * @return JSON Response
     */
    @RequestMapping(value = "/user/subscription", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<List<Subscription>> createSubscription(@RequestBody Subscription subscription) {

        subscription.setAmount(subscription.getAmount());

        subscription.setInvoiceDates(recurringDates(subscription));

        return new ResponseEntity(subscription, HttpStatus.OK);
    }

    public List<String> recurringDates(Subscription subscription) {

        String invoiceDatesStr = subscription.getInvoiceDates().toString();

        System.out.println(invoiceDatesStr);

        List<String> subscriptionDates = Arrays.asList(invoiceDatesStr.split(","));

        String subscriptionStartDate = subscriptionDates.get(0).substring(1);
        String subscriptionEndDate = subscriptionDates.get(1).substring(1, subscriptionDates.get(1).length() -1);

        System.out.println(subscriptionStartDate);
        System.out.println(subscriptionEndDate);

        DateTime dateTime1 = new DateTime(subscriptionStartDate);
        DateTime dateTime2 = new DateTime(subscriptionEndDate);

        List<String> allDates = new ArrayList();

        while(dateTime1.isBefore(dateTime2)) {
            allDates.add(dateTime1.toDate().toString());

            if(subscription.getSubscriptionType().equals("weekly")) {
                dateTime1 = dateTime1.plusDays(7);
            } else if (subscription.getSubscriptionType().equals("monthly")) {
                dateTime1 = dateTime1.plusDays(30);
            } else {
                return allDates;
            }
            if(allDates.isEmpty()) {
                HTTPException exception = new HTTPException(1);
                throw exception;
            }
        }
        System.out.println(allDates);
        return allDates;
    }
}