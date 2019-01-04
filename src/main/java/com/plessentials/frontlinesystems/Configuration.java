package com.plessentials.frontlinesystems;

import com.plessentials.frontlinesystems.cacheproviders.AvailableNumbersCacheProvider;
import com.plessentials.frontlinesystems.dataproviders.DynamoDBDataProvider;
import com.plessentials.frontlinesystems.dataproviders.IDataProvider;
import com.plessentials.frontlinesystems.models.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean("usersDataProvider")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IDataProvider<User> getUserDataProvider(){
        return new DynamoDBDataProvider<User>(User.class);
    }

    @Bean("availableNumbersCacheProvider")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AvailableNumbersCacheProvider getAvailableNumbersCacheProvider(){
        return new AvailableNumbersCacheProvider();
    }
}
