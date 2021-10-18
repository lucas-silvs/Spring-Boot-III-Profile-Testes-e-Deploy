package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
//para testes automatizados utilizando banco de dados que não sejam e memória
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CursoRepositoryTest {
    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void deveriaCarregarumCursoAoBuscarPeloNome(){
        Curso html = new Curso();
        html.setNome("HTML 5");
        html.setCategoria("Programação");

        entityManager.persist(html);
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso,curso.getNome());
    }

    @Test
    public void NaodeveriaCarregarumCursoAoBuscarPeloNome(){
        String nomeCurso = "Não existe";
        Curso curso = repository.findByNome(nomeCurso);
        Assert.assertNull(curso);

    }


}
