package com.java.crud.example;

import com.java.crud.example.Swagger.SwaggerConfig;
import com.java.crud.example.controller.ClaimsController;
import com.java.crud.example.controller.DataController;
import com.java.crud.example.controller.ProAuthController;
import com.java.crud.example.controller.ProviderController;
import com.java.crud.example.entity.Claims.Claims;
import com.java.crud.example.entity.Data.Lab_Data;
import com.java.crud.example.entity.Member.Member_Demo;
import com.java.crud.example.entity.Member.Member_Elig;
import com.java.crud.example.entity.Member.Member_PCP;
import com.java.crud.example.entity.Member.ProAuth;
import com.java.crud.example.entity.Provider.Provider_Demo;
import com.java.crud.example.repository.ClaimsRepository;
import com.java.crud.example.repository.DataRepository;
import com.java.crud.example.repository.ProAuthRepository;
import com.java.crud.example.repository.ProviderRepository;
import com.java.crud.example.service.ClaimsService;
import com.java.crud.example.service.DataService;
import com.java.crud.example.service.ProAuthService;
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
@PrepareForTest({ProAuthController.class, ProAuthService.class,ProviderController.class, ProviderService.class, ClaimsController.class, ClaimsService.class, DataController.class, DataService.class, SwaggerConfig.class,SpringBootCrudProAuthApplication.class})
public class ProAuthControllerTest {
    @InjectMocks
    private SwaggerConfig swaggerConfig;
    @InjectMocks
    private SpringBootCrudProAuthApplication springBootCrudProAuthApplication;
    @InjectMocks
    private
    ClaimsController claimsController;
    @InjectMocks
    private
    ClaimsService claimsService;
    @InjectMocks
    private Claims claims;
    @Mock
    private ClaimsRepository repository;

    List<Claims> claimsList = new ArrayList<>();
    @InjectMocks
    private
    ProAuthController proAuthController;
    @InjectMocks
    private
    ProAuthService proAuthService;
    @InjectMocks
    private ProAuth proAuth;
    @InjectMocks
    private Member_Demo member_demo;
    @InjectMocks
    private Member_Elig member_elig;
    @InjectMocks
    private Member_PCP member_pcp;
    @Mock
    private ProAuthRepository proAuthRepository;

    List<ProAuth> proAuths = new ArrayList<>();

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

    @InjectMocks
    private
    DataController dataController;
    @InjectMocks
    private
    DataService dataService ;
    @InjectMocks
    private Lab_Data lab_data;
    @Mock
    private DataRepository dataRepository;

    List<Lab_Data> lab_dataList = new ArrayList<>();

    public ProAuthControllerTest() {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.initMocks(this);
        claims.setClaimId(1);
        claimsList.add(claims);
        when(claimsService.getClaims()).thenReturn(claimsList);

        proAuth.setMemberId("11");
        proAuth.setName("Gowtham");
        proAuths.add(proAuth);
        when(proAuthService.getMembers()).thenReturn(proAuths);

        provider_demo.setPrvd_frst_nm("Siva");
        provider_demo.setPrvd_id("12");
        provider_demos.add(provider_demo);
        when(providerService.getProviders()).thenReturn(provider_demos);

        lab_data.setLab_name("Citrix");
        lab_data.setLab_id("12");
        lab_dataList.add(lab_data);
        when(dataService.getLabData()).thenReturn(lab_dataList);
    }
    @Test
    public void getClaimIdTest() {
        ClaimsService mock = PowerMockito.mock(ClaimsService.class);
        PowerMockito.when(mock.getClaimById(1)).thenReturn(claimsList.get(0));

        ClaimsController claimsController = new ClaimsController(mock);
        System.out.println("--"+claims);
        Assert.assertEquals(claimsList.get(0), claimsController.findClaimById(1));
    }

    @Test
    public void getClaimsTest() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);
        PowerMockito.when(mock.getClaims()).thenReturn(claimsList);
        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals(claimsList, claimsController.findAllClaims());
    }
    @Test
    public void getClaimNameTest() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);
        PowerMockito.when(mock.getClaimsByName(" ")).thenReturn(claimsList.get(0));
        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals(claimsList.get(0), claimsController.findClaimByName(" "));
    }

    @Test
    public void saveClaimsTest() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);

        PowerMockito.when(mock.saveClaims(claimsList)).thenReturn(claimsList);

        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals(claimsList, claimsController.addClaims(claimsList));
    }

    @Test
    public void saveClaimTest() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);

        PowerMockito.when(mock.saveClaim(claims)).thenReturn(claimsList.get(0));

        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals(claimsList.get(0), claimsController.addClaim(claims));
    }
    @Test
    public void saveClaimId() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);

        PowerMockito.when(mock.saveClaim(claims)).thenReturn(claims);

        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals(claims, claimsController.addClaim(claims));
    }
    @Test
    public void updateClaims() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);

        PowerMockito.when(mock.updateClaims(claimsList.get(0))).thenReturn(claimsList.get(0));

        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals(claimsList.get(0), claimsController.updateClaim(claimsList.get(0)));
    }

    @Test
    public void deleteClaim() {
        ClaimsService mock =PowerMockito.mock(ClaimsService.class);

        PowerMockito.when(mock.deleteClaim(1)).thenReturn("ClaimId 1 is removed !! ");

        ClaimsController claimsController = new ClaimsController(mock);
        Assert.assertEquals("ClaimId 1 is removed !! ", claimsController.deleteClaim(1));
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
    public void getMemberByIdTestService() {
        //Creating a mock using the PowerMockito.mock
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

        PowerMockito.when(mock.findById(11)).thenReturn(java.util.Optional.ofNullable(proAuths.get(0)));

        ProAuthService proAuthService = new ProAuthService(mock);
        Assert.assertEquals(proAuths.get(0), proAuthService.getMemberById(11));

    }

    @Test
    public void getMembersTest() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);
        PowerMockito.when(mock.getMembers()).thenReturn(proAuths);
        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths, proAuthController.findAllMembers());
    }

    @Test
    public void getMembersTestService() {
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

        PowerMockito.when(mock.findAll()).thenReturn(proAuths);

        ProAuthService proAuthService = new ProAuthService(mock);
        Assert.assertEquals(proAuths, proAuthService.getMembers());
    }

    @Test
    public void getMemberbyNameTest() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.getMemberByName("Gowtham")).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.findMemberByName("Gowtham"));
    }

    @Test
    public void getMemberbyNameTestService() {
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

        PowerMockito.when(mock.findByName("Gowtham")).thenReturn(proAuths.get(0));

        ProAuthService proAuthService = new ProAuthService(mock);
        Assert.assertEquals(proAuths.get(0), proAuthService.getMemberByName("Gowtham"));
    }

    @Test
    public void saveTestMemberService() {
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

        PowerMockito.when(mock.save(proAuth)).thenReturn(proAuths.get(0));

        ProAuthService proAuthService = new ProAuthService(mock);
        Assert.assertEquals(proAuths.get(0), proAuthService.saveMember(proAuth));
    }
    @Test
    public void saveTestMemberController() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.saveMember(proAuths.get(0))).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.addMember(proAuths.get(0)));
    }

    @Test
    public void saveTestMembers() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.saveMembers(proAuths)).thenReturn(proAuths);

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths, proAuthController.addMembers(proAuths));
    }

    @Test
    public void saveTestMembersService() {
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

        PowerMockito.when(mock.saveAll(proAuths)).thenReturn(proAuths);

        ProAuthService proAuthService = new ProAuthService(mock);
        Assert.assertEquals(proAuths, proAuthService.saveMembers(proAuths));
    }

    @Test
    public void updateTestMember() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.updateMember(proAuths.get(0))).thenReturn(proAuths.get(0));

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals(proAuths.get(0), proAuthController.updateMember(proAuths.get(0)));
    }

    @Test
    public void updateTestMemberService() {
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

        PowerMockito.when(mock.save(proAuths.get(0))).thenReturn(proAuths.get(0));

        ProAuthService proAuthService = new ProAuthService(mock);
        ProAuth proAuth1 = new ProAuth();

        Assert.assertTrue(proAuths.get(0)!=null );

        proAuth1.setName("Gowtham");

        Assert.assertEquals(null, proAuthService.updateMember(proAuths.get(0)));
    }

    @Test
    public void deleteTestMember() {
        ProAuthService mock =PowerMockito.mock(ProAuthService.class);

        PowerMockito.when(mock.deleteMember(11)).thenReturn("Member 11 is removed !! ");

        ProAuthController proAuthController = new ProAuthController(mock);
        Assert.assertEquals("Member 11 is removed !! ", proAuthController.deleteMember(11));
    }

    @Test
    public void deleteTestMemberService() {
        ProAuthRepository mock =PowerMockito.mock(ProAuthRepository.class);

       // PowerMockito.when(mock.deleteById(11)).thenReturn("Member 11 is removed !! ");

        ProAuthService proAuthService = new ProAuthService(mock);
        Assert.assertEquals("Member 11 is removed !! ", proAuthService.deleteMember(11));
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

    @Test
    public void getlabdatasTest() {
        DataService mock =PowerMockito.mock(DataService.class);
        PowerMockito.when(mock.getLabData()).thenReturn(lab_dataList);
        DataController dataController = new DataController(mock);
        Assert.assertEquals(lab_dataList, dataController.findAllLabData());
    }

    @Test
    public void getlabdatabyidTest() {
        DataService mock =PowerMockito.mock(DataService.class);
        PowerMockito.when(mock.getLabDataById(12)).thenReturn(lab_dataList.get(0));
        DataController dataController = new DataController(mock);
        Assert.assertEquals(lab_dataList.get(0), dataController.findLabDataById(12));
    }


    @Test
    public void saveLabdata() {
        DataService mock =PowerMockito.mock(DataService.class);

        PowerMockito.when(mock.saveLabData(lab_data)).thenReturn(lab_dataList.get(0));

        DataController dataController = new DataController(mock);
        Assert.assertEquals(lab_dataList.get(0), dataController.addLabData(lab_data));
    }
    @Test
    public void saveLabdatas() {
        DataService mock =PowerMockito.mock(DataService.class);

        PowerMockito.when(mock.saveLabDatas(lab_dataList)).thenReturn(lab_dataList);

        DataController dataController = new DataController(mock);
        Assert.assertEquals(lab_dataList, dataController.addLabDatas(lab_dataList));
    }

    @Test
    public void updateLabdata() {
        DataService mock =PowerMockito.mock(DataService.class);

        PowerMockito.when(mock.updateLabData(lab_dataList.get(0))).thenReturn(lab_dataList.get(0));

        DataController dataController = new DataController(mock);
        Assert.assertEquals(lab_dataList.get(0), dataController.updateLabData(lab_dataList.get(0)));
    }

    @Test
    public void deleteLabdata() {
        DataService mock =PowerMockito.mock(DataService.class);

        PowerMockito.when(mock.deleteLabData(1)).thenReturn("Lab Data 11 is removed !! ");

        DataController dataController = new DataController(mock);
        Assert.assertEquals("Lab Data 11 is removed !! ", dataController.deleteLabData(1));
    }


}
