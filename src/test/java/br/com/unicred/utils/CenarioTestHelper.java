package br.com.unicred.utils;

import br.com.unicred.domain.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CenarioTestHelper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void limparBanco() {
        jdbcTemplate.execute("delete from ass_assembleia.ass_pauta;");
    }

    public Map<String, Object> consultarPautaPorId(long id) {
        return jdbcTemplate.queryForMap("select * from ass_assembleia.ass_pauta where id = ?", id);
    }
}
