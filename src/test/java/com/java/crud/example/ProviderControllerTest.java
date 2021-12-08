package com.java.crud.example;

import com.java.crud.example.controller.ProviderController;
import com.java.crud.example.entity.Provider.Provider_Demo;
import com.java.crud.example.repository.ProviderRepository;
import com.java.crud.example.service.ProviderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({ProviderController.class, ProviderService.class})
public class ProviderControllerTest {
    @InjectMocks
    private
    ProviderController providerController;
    @InjectMocks
    private
    ProviderService providerService;
    @InjectMocks
    private Provider_Demo provider_demo;
    @Mock
    private ProviderRepository providerRepository;

    List<Provider_Demo> provider_demos = new ArrayList<>();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        // ProAuth proAuth = new ProAuth();
        provider_demo.setPrvd_frst_nm("Siva");
        provider_demo.setPrvd_id("12");
        provider_demos.add(provider_demo);
        when(providerService.getProviders()).thenReturn(provider_demos);
    }

    @Test
    public void getProvideByIdTest() {
        //Creating a mock using the PowerMockito.mock
       ProviderService mock = PowerMockito.mock(ProviderService.class);

        PowerMockito.when(mock.getProviderById(1L)).thenReturn(provider_demos.get(0));

        ProviderController providerController = new ProviderController(mock);
        System.out.println("--"+provider_demos);
        Assert.assertEquals(provider_demos.get(0), providerController.findProviderById(1L));
    }

    @Test
    public void getProvidersTest() {
        ProviderService mock =PowerMockito.mock(ProviderService.class);
        PowerMockito.when(mock.getProviders()).thenReturn(provider_demos);
        ProviderController providerController = new ProviderController(mock);
        Assert.assertEquals(provider_demos, providerController.findAllProviders());
    }


    @Test
    public void getProviderNameTest() {
        ProviderService mock =PowerMockito.mock(ProviderService.class);
        PowerMockito.when(mock.getProviderById(12L)).thenReturn(provider_demos.get(0));
        ProviderController providerController = new ProviderController(mock);
        Assert.assertEquals(provider_demos.get(0), providerController.findProviderById(0xcL));
    }

    @Test
    public void saveProvider() {
        ProviderService mock =PowerMockito.mock(ProviderService.class);

        PowerMockito.when(mock.saveProvider(provider_demo)).thenReturn(provider_demo.get(0));

        ProviderController providerController = new ProviderController(mock);
        Assert.assertEquals(provider_demo.get(0), providerController.addProvider(provider_demo));
    }
   @Test
    public void saveProviderid() {
        ProviderService mock =PowerMockito.mock(ProviderService.class);

        PowerMockito.when(mock.saveProviders(provider_demo)).thenReturn(provider_demo);

        ProviderController providerController = new ProviderController(mock);
        Assert.assertEquals(provider_demo, providerController.addProviders(provider_demo));
    }

    @Test
    public void updateProvider() {
        ProviderService mock =PowerMockito.mock(ProviderService.class);

        PowerMockito.when(mock.updateProvider(provider_demo.get(0))).thenReturn(provider_demo.get(0));

        ProviderController proAuthController = new ProviderController(mock);
        Assert.assertEquals(provider_demo.get(0), proAuthController.updateProvider(provider_demo.get(0)));
    }

     @Test
    public void deleteProvider() {
        ProviderService mock =PowerMockito.mock(ProviderService.class);

        PowerMockito.when(mock.deleteProvider(1L)).thenReturn("Member 11 is removed !! ");

        ProviderController providerController = new ProviderController(mock);
        Assert.assertEquals("Member 11 is removed !! ", providerController.deleteProvider(1L));
    }
}
