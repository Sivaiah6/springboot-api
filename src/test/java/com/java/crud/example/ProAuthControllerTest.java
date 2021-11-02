package com.java.crud.example;

import com.java.crud.example.controller.ProAuthController;
import com.java.crud.example.entity.ProAuth;
import com.java.crud.example.service.ProAuthService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({ProAuthController.class, ProAuthService.class})
public class ProAuthControllerTest {
    @InjectMocks
    private
    ProAuthController proAuthController;
    @Mock
    private
    ProAuthService proAuthService;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        List<ProAuth> proAuths = new ArrayList<>();
        ProAuth proAuth = new ProAuth();
        proAuth.setMemberId(11);
        proAuth.setName("Gowtham");
        proAuths.add(proAuth);
        when(proAuthService.getMembers()).thenReturn(proAuths);
    }

    @Test
    public void getMemberByIdTest() throws Exception
    {
        //Creating a mock using the PowerMockito.mock
        setProAuthService(PowerMockito.mock(ProAuthService.class));
        ProAuth proAuth = new
                ProAuth();
        proAuth.setMemberId(11);
        when(getProAuthService().getMemberById(11)).thenReturn(proAuth);
        setProAuthController(new ProAuthController(getProAuthService()));
        final ProAuth proAuthDto = proAuthService.getMemberById(11);
        Assert.assertNotNull(proAuthDto);
        Assert.assertEquals(11, proAuthDto.getMemberId());
    }

    @Test
    public void getMembersTest() throws Exception
    {
        ProAuth proAuth = new
                ProAuth();
        List<ProAuth> proAuthList = new ArrayList<>();
        proAuthList.add(proAuth);
        ProAuthController proAuthControllerSpy = PowerMockito.spy(getProAuthController());
        PowerMockito.doReturn(proAuthList).when(proAuthControllerSpy, "findAllMembers");
        List<ProAuth> result = proAuthService.getMembers();
        Assert.assertNotNull(result);
        Assert.assertEquals(proAuthList, result);
    }

    public ProAuthController getProAuthController() {
        return proAuthController;
    }

    public void setProAuthController(ProAuthController proAuthController) {
        this.proAuthController = proAuthController;
    }

    public ProAuthService getProAuthService() {
        return proAuthService;
    }

    public void setProAuthService(ProAuthService proAuthService) {
        this.proAuthService = proAuthService;
    }
}
