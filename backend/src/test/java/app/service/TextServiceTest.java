package app.service;

import app.entity.Text;
import app.repository.TextRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TextServiceTest
{
    @Mock
    TextRepository textRepository;
    TextService textService;

    @BeforeEach
    void setUp()
    {
        textService=new TextService(textRepository);
    }
    @Test
    void save()
    {
        Text text=new Text();
        Mockito.when(textRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Text.class));
        Text saved=textService.save(text);
        Assertions.assertEquals(saved,text);
    }
    @Test
    void update()
    {
        Text text=new Text();
        Mockito.when(textRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Text.class));
        Text updated=textService.update(text);
        Assertions.assertEquals(updated,text);
    }
    @Test
    void findById_returnsText()
    {
        Text text=new Text();
        Mockito.when(textRepository.findById(Mockito.any())).thenReturn(Optional.of(text));
        Text actual=textService.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,text);
    }
    @Test
    void findById_throwsEntityNotFoundException()
    {
        Mockito.when(textRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,()->textService.findById(Long.valueOf("1")));
    }
}