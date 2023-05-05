package com.shivu.financetracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivu.financetracker.dto.AppResponse;
import com.shivu.financetracker.dto.SavingsDto;
import com.shivu.financetracker.dto.SavingsUserDto;
import com.shivu.financetracker.service.SavingsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/savings")
@AllArgsConstructor
@CrossOrigin
public class SavingsController {

    private final SavingsService service;

    @CrossOrigin
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewSavings(@RequestBody SavingsDto dto) {

        final Integer sts = service.createNewSavings(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("finance added Successfully")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @CrossOrigin
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewUSerSavings(@Valid @RequestBody SavingsUserDto dto) {

        final Integer sts = service.createNewSavings(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Finance added Successfully")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/allsavings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<SavingsDto>>> allSavings() {
        List<SavingsDto> finances = service.all();

        AppResponse<List<SavingsDto>> response = AppResponse.<List<SavingsDto>>builder()
                .sts("success")
                .msg("this ones working")
                .bd(finances)
                .build();

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteSavings(@PathVariable Long id) {

        final Integer sts = service.deleteSavings(id);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Finance Deleted Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<SavingsDto>> getSavingsById(@PathVariable Long id) {

        final SavingsDto dto = service.fetchSavingsDetails(id);

        final AppResponse<SavingsDto> response = AppResponse.<SavingsDto>builder()
                .sts("success")
                .msg("FInancial Details")
                .bd(dto)
                .build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<SavingsDto>>> allUserSavings(@PathVariable Long id) {
        List<SavingsDto> savings = service.allUserSavings(id);

        AppResponse<List<SavingsDto>> response = AppResponse.<List<SavingsDto>>builder()
                .sts("success")
                .msg("Users FInacne")
                .bd(savings)
                .build();

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewSavings(@Valid @RequestBody SavingsDto dto) {

        final Integer sts = service.updateSavings(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Finance Updated Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.ok().body(response);
    }
}
