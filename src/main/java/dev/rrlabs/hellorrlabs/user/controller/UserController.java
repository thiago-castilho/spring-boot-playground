package dev.rrlabs.hellorrlabs.user.controller;

import dev.rrlabs.hellorrlabs.user.api.UserApi;
import dev.rrlabs.hellorrlabs.user.api.mapper.UserMapper;
import dev.rrlabs.hellorrlabs.user.api.resource.UserResource;
import dev.rrlabs.hellorrlabs.user.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<Void> create(UserResource resource) {
        log.info("Recebendo informações do usuário a ser criado: {}", resource);

        // Converter para um objeto de domínio do usuário
        User parse = UserMapper.INSTANCE.parse(resource);
        log.info("Parser do objeto: {}", parse);

        // TODO: Chamar o serviço que vai persistir esse usuário

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<UserResource> findById(String email) {
        log.info("Recebendo informações para consulta do usuário: {}", email);
        return ResponseEntity.ok(UserResource.builder()
                .phoneNumber("11 985858585")
                .name("Thiago")
                .email(email)
                .build());
    }

    @Override
    public ResponseEntity<List<UserResource>> find(UserResource filter) {
        log.info("Recebendo informações para consulta do(s) usuário(s): {}", filter);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> update(UserResource resource) {
        log.info("Recebendo informações para atualizar o usuário: {}", resource);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResource> delete(String email) {
        log.info("Recebendo informações para deletar o usuário: {}", email);
        return ResponseEntity.ok().build();
    }
}
