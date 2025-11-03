package awesomecucumber.types;

import java.util.Map;

import awesomecucumber.domain.BillingDetails;
import io.cucumber.java.DataTableType;

public class CustomerDataTabeType {
    @DataTableType
    public BillingDetails billingDetails(Map<String, String> entry) {
        return new BillingDetails(
                entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("country"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }

}
