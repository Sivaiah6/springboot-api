package com.java.crud.example;

import com.java.crud.example.controller.ProAuthController;
import com.java.crud.example.entity.ProAuth;
import com.java.crud.example.service.ProAuthService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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

    @Test
    public void getMemberByIdTest() throws Exception
    {
        //Creating a mock using the PowerMockito.mock
        setProAuthService(PowerMockito.mock(ProAuthService.class));
        ProAuth proAuth = new
                ProAuth();
        proAuth.setMemberId(11);
        PowerMockito.when(getProAuthService().getMemberById(11)).thenReturn(proAuth);
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
        proAuth.setName("Gowtham");
        ProAuthController proAuthControllerSpy = PowerMockito.spy(getProAuthController());
        List<ProAuth> result = getProAuthService().getMembers();
        Assert.assertEquals(result.size(), 0);
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
