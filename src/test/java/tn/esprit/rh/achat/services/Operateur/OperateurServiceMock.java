package tn.esprit.rh.achat.services.Operateur;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IProduitService;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.runner.RunWith;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServiceMock {

    @MockBean
    private OperateurRepository operateurRepository;

    private Operateur op1 = new Operateur(1L,"Zoubli","Rafik","12345");
    private Operateur op2 = new Operateur(2L,"Zoubli","Faten","56432");

    @Autowired
    IOperateurService operateurService;


    @Test
    public void addOperateurTest() {
        when(operateurRepository.save(op1)).thenReturn(op1);
        assertNotNull(op1);
        assertEquals(op1, operateurService.addOperateur(op1));
    }

    @Test
    public void retrieveAllOperateursTest() {
        when(operateurRepository.findAll()).thenReturn(Stream.of(op1,op2).collect(Collectors.toList()));
        assertEquals(2,operateurService.retrieveAllOperateurs().size());
    }



    @Test
    public void DeleteOperateurTest() {
        operateurRepository.save(op1);
        operateurService.deleteOperateur(op1.getIdOperateur());
        verify(operateurRepository, times(1)).deleteById(op1.getIdOperateur());

    }

    @Test
    public void UpdateOperateurTest() {
        when(operateurRepository.save(op1)).thenReturn(op1);
        assertNotNull(op1);
        assertEquals(op1, operateurService.updateOperateur(op1));
    }

    @Test
    public void retrieveOperateurTest() {
        when(operateurRepository.findById(op1.getIdOperateur())).thenReturn(Optional.of(op1));
        assertEquals(op1, operateurService.retrieveOperateur(op1.getIdOperateur()));
    }
}
