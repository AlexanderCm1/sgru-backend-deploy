package pe.edu.upeu.sysgru.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysgru.dao.AccesoDao;
import pe.edu.upeu.sysgru.dao.PersonaDao;
import pe.edu.upeu.sysgru.dao.UsuarioDao;
import pe.edu.upeu.sysgru.entity.Acceso;
import pe.edu.upeu.sysgru.entity.Persona;
import pe.edu.upeu.sysgru.entity.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private AccesoDao accesoDao;
    @Autowired
    private PersonaDao personaDao;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Usuario user = usuarioDao.getUsuarioByUsername(authentication.getName());
        Persona per = personaDao.buscarPersona(user.getPersona_id());
        List<Acceso> accesos = new ArrayList<>();
        accesos = accesoDao.getAccesosbyid(user.getPersona_id());
        Map<String, Object> datos= new HashMap<>();
        datos.put("persona_id", user.getPersona_id());
        datos.put("nombre", per.getNombres());
        datos.put("apellidos", per.getApellidos());
        datos.put("user", user.getUsername());
        datos.put("accesos", accesos);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(datos);

        return accessToken;
    }
}
