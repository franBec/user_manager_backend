package dev.pollito.user_manager_backend.controller.advice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ExtendWith(MockitoExtension.class)
class GlobalControllerAdviceTest {
  @InjectMocks private GlobalControllerAdvice globalControllerAdvice;

  private static void problemDetailAssertions(
      @NotNull ProblemDetail response, @NotNull Exception e, @NotNull HttpStatus httpStatus) {
    assertEquals(httpStatus.value(), response.getStatus());
    assertEquals(e.getClass().getSimpleName(), response.getTitle());
    assertNotNull(response.getProperties());
    assertNotNull(response.getProperties().get("timestamp"));
    assertNotNull(response.getProperties().get("trace"));
  }

  @Test
  void whenNoResourceFoundExceptionThenReturnProblemDetail() {
    NoResourceFoundException e = mock(NoResourceFoundException.class);
    problemDetailAssertions(globalControllerAdvice.handle(e), e, HttpStatus.NOT_FOUND);
  }

  @Test
  void whenNoSuchElementExceptionThenReturnProblemDetail() {
    NoSuchElementException e = mock(NoSuchElementException.class);
    problemDetailAssertions(globalControllerAdvice.handle(e), e, HttpStatus.NOT_FOUND);
  }

  @Test
  void whenMethodArgumentNotValidExceptionThenReturnProblemDetail() {
    MethodArgumentNotValidException e = mock(MethodArgumentNotValidException.class);
    problemDetailAssertions(globalControllerAdvice.handle(e), e, HttpStatus.BAD_REQUEST);
  }

  @Test
  void whenMethodArgumentTypeMismatchExceptionThenReturnProblemDetail() {
    MethodArgumentTypeMismatchException e = mock(MethodArgumentTypeMismatchException.class);
    problemDetailAssertions(globalControllerAdvice.handle(e), e, HttpStatus.BAD_REQUEST);
  }

  @Test
  void whenExceptionThenReturnProblemDetail() {
    Exception e = mock(Exception.class);
    problemDetailAssertions(globalControllerAdvice.handle(e), e, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
