package com.java.crud.example;

import com.java.crud.example.controller.ProAuthController;
import com.java.crud.example.entity.Member.ProAuth;
import com.java.crud.example.repository.ProAuthRepository;
import com.java.crud.example.service.ProAuthService;
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
@PrepareForTest({ProAuthController.class, ProAuthService.class})
public class ProAuthControllerTest {
    @InjectMocks
    private
    ProAuthController proAuthController;
    @InjectMocks
    private
    ProAuthService proAuthService;
    @InjectMocks
    private ProAuth proAuth;
    @Mock
    private ProAuthRepository proAuthRepository;

    List<ProAuth> proAuths = new ArrayList<>();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
       // ProAuth proAuth = new ProAuth();
        proAuth.setMemberId("11");
        proAuth.setName("Gowtham");
        proAuths.add(proAuth);
        when(proAuthService.getMembers()).thenReturn(proAuths);
    }

    @Test
    public void getMemberByIdTest() {
        //Creating a mock using the PowerMockito.mock
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.getMemberById(11)).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.findMemberById(11));
    }

    @Test
    public void getMembersTest() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);
        PowerMockito.when(mock.getMembers()).thenReturn(proAuths);
        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths, proAuthController.findAllMembers());
    }

    @Test
    public void getMemberbyNameTest() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.getMemberByName("Gowtham")).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.findMemberByName("Gowtham"));
    }

    @Test
    public void saveTestMember() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.saveMember(proAuth)).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.addMember(proAuth));
    }
    @Test
    public void saveTestMembers() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.saveMembers(proAuths)).thenReturn(proAuths);

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths, proAuthController.addMembers(proAuths));
    }

    @Test
    public void updateTestMember() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.updateMember(proAuths.get(0))).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.updateMember(proAuths.get(0)));
    }

    @Test
    public void deleteTestMember() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.deleteMember(11)).thenReturn("Member 11 is removed !! ");

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals("Member 11 is removed !! ", proAuthController.deleteMember(11));
    }



}
