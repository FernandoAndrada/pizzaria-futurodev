package br.com.agls.pizzariafuturoDev.Api.Error.Error;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefaultError {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;




}
