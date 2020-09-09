package at.porscheinformatik.happyrest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import at.porscheinformatik.happyrest.RestCall;
import at.porscheinformatik.happyrest.RestCallFactory;
import at.porscheinformatik.happyrest.RestLoggerAdapter;
import at.porscheinformatik.happyrest.RestUtils;
import at.porscheinformatik.happyrest.slf4j.Slf4jRestLoggerAdapter;

/**
 * A factory for REST calls using spring
 *
 * @author ham
 */
@Service
public class Spring4RestCallFactory implements RestCallFactory
{

    private static Spring4RestCallFactory defaultFactory = null;

    public static Spring4RestCallFactory getDefault()
    {
        Spring4RestCallFactory factory = defaultFactory;

        if (factory == null)
        {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getInterceptors().add((request, body, execution) -> {
                request.getHeaders().add("user-agent", RestUtils.getUserAgent("Spring 4's RestTemplate"));

                return execution.execute(request, body);
            });

            factory = new Spring4RestCallFactory(restTemplate, Slf4jRestLoggerAdapter.getDefault(), null);

            defaultFactory = factory;
        }

        return factory;
    }

    private final RestTemplate restTemplate;
    private final RestLoggerAdapter loggerAdapter;
    private final ConversionService conversionService;

    @Autowired
    public Spring4RestCallFactory(RestTemplate restTemplate, RestLoggerAdapter loggerAdapter,
        ConversionService conversionService)
    {
        super();

        this.restTemplate = restTemplate;
        this.loggerAdapter = loggerAdapter;
        this.conversionService = conversionService;
    }

    @Override
    public RestCall url(String url)
    {
        return new Spring4RestCall(restTemplate, loggerAdapter, new SpringRestFormatter(conversionService), url);
    }

}
