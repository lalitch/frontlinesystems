package com.plessentials.frontlinesystems.cacheproviders;

import com.plessentials.frontlinesystems.dataproviders.DynamoDBDataProvider;
import com.plessentials.frontlinesystems.dataproviders.IDataProvider;
import com.plessentials.frontlinesystems.models.AvailableNumbers;

import java.util.ArrayList;
import java.util.List;

public class AvailableNumbersCacheProvider {
    private List<AvailableNumbers> availableNumbers;
    private IDataProvider<AvailableNumbers> availableNumbersDataProvider;

    public AvailableNumbersCacheProvider()
    {
        this.availableNumbers = new ArrayList<>();
        this.availableNumbersDataProvider = new DynamoDBDataProvider<>(AvailableNumbers.class);
    }

    public String getAvailableNumber()
    {
        this.refreshNumbers();
        AvailableNumbers av = this.availableNumbers.remove(0);
        return av.getNumber();
    }

    private void refreshNumbers()
    {
        if(this.availableNumbers.size() > 0)
            return;

        this.availableNumbers = this.availableNumbersDataProvider.listAndDelete(2);
    }
}
