package io.pivotal.pal.paluserprovidedservices;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CohortRepository {

    private final JdbcTemplate jdbcTemplate;

    public CohortRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Cohort create(Cohort cohort) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO time_entries (project_id, user_id, date, hours) " +
                            "VALUES (?, ?, ?)",
                    RETURN_GENERATED_KEYS
            );

            statement.setLong(1, cohort.getId());
            statement.setString(2, cohort.getName());
            statement.setString(3, cohort.getNickname());

            return statement;
        }, generatedKeyHolder);

        return find(generatedKeyHolder.getKey().longValue());
    }


    public Cohort find(Long id) {
        return jdbcTemplate.query(
                "SELECT id, name, nickname FROM cohort WHERE id = ?",
                new Object[]{id},
                extractor);
    }

    public List<Cohort> getNames() {
        return jdbcTemplate.query(
                "SELECT name FROM cohort",
                nameMapper);
    }


    public List<Cohort> list() {
        return jdbcTemplate.query("SELECT id, name, nickname FROM cohort", mapper);
    }


    public Cohort update(Long id, Cohort cohort) {
        jdbcTemplate.update("UPDATE cohort " +
                        "SET id = ?, name = ?, nickname = ? " +
                        "WHERE id = ?",
                cohort.getId(),
                cohort.getName(),
                cohort.getNickname(),
                id);

        return find(id);
    }


    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM cohort WHERE id = ?", id);
    }

    private final RowMapper<Cohort> mapper = (rs, rowNum) -> new Cohort(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("nickname")

    );

    private final ResultSetExtractor<Cohort> extractor =
            (rs) -> rs.next() ? mapper.mapRow(rs, 1) : null;

    private final RowMapper<Cohort> nameMapper = (rs, rowNum) -> new Cohort(

            rs.getString("name")


    );

    private final ResultSetExtractor<Cohort> nameExtractor =
            (rs) -> rs.next() ? nameMapper.mapRow(rs, 1) : null;
}
