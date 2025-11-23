package santana.dev.skillbridge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Types;

@RestController
@RequestMapping("/api/users")
public class UserJsonController {

    private final JdbcTemplate jdbcTemplate;

    public UserJsonController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/{id}/profile-json")
    public ResponseEntity<String> getUserJson(@PathVariable Long id) {
        String sql = "{ ? = call PKG_USERS.user_to_json(?) }";
        return ResponseEntity.ok(
                jdbcTemplate.execute(sql, (CallableStatement cs) -> {
                    cs.registerOutParameter(1, Types.CLOB);
                    cs.setLong(2, id);
                    cs.execute();
                    Clob clob = cs.getClob(1);
                    return clob != null ? clob.getSubString(1, (int) clob.length()) : "{}";
                })
        );
    }
}

