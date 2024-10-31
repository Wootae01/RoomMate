package hello.roommate.profile.repository;

import hello.roommate.profile.domain.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

@Repository
public class ProfileRepository {
    private final NamedParameterJdbcTemplate template;

    public ProfileRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    public Profile save(Profile profile) {
        String sql = "insert into profile(profile_id, introduce, img) " +
                "values(:id, :introduce, :img)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", profile.getId())
                .addValue("introduce", profile.getIntroduce())
                .addValue("img", profile.getImg());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, param, keyHolder);

        Long key = keyHolder.getKey().longValue();
        profile.setId(key);
        return profile;
    }

    public Profile findById(Long id) {
        String sql = "select * from profile where profile_id=:id";
        Map<String, Long> param = Map.of("id", id);

        Profile profile = template.queryForObject(sql, param, profileRowMapper());
        return profile;
    }

    public void update(Long profileId, ProfileUpdateDto updateDto) {
        String sql = "update profile set " +
                "introduce=:introduce, img=:img " +
                "where profile_id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("introduce", updateDto.getIntroduce())
                .addValue("img", updateDto.getImg())
                .addValue("id", profileId);
        template.update(sql, param);
    }

    public void delete(Long id) {
        String sql = "delete from profile where id=:id";
        Map<String, Long> param = Map.of("id", id);
        template.update(sql, param);
    }

    private RowMapper<Profile> profileRowMapper() {
        return BeanPropertyRowMapper.newInstance(Profile.class);
    }
}