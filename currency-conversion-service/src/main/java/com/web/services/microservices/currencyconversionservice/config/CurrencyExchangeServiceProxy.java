package com.web.services.microservices.currencyconversionservice.config;

import com.web.services.microservices.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//Adding ribbon we can get the url instance where the service is running.
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    //@GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}